package com.litdgz.puppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import com.litdgz.puppy.adapter.PageAdapter;
import com.litdgz.puppy.fragments.PerfilFragment;
import com.litdgz.puppy.fragments.ReyclerViewFragment;
import com.litdgz.puppy.pojo.Mascota;
import com.litdgz.puppy.restApi.EndPointApi;
import com.litdgz.puppy.restApi.adapter.RestApiAdapter;
import com.litdgz.puppy.restApi.model.MascotaResponse;
import com.litdgz.puppy.restApi.model.UsuarioResponse;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private static final String TAG = "MainActivity";
    public static final String CANAL_1_ID = "canal1";
    private static final String CANAL_1_NOMBRE = "Canal 1";
    private static final String CANAL_1_DESCRIPCION = "Este es Canal 1";
    private NotificationManagerCompat notificationManagerCompat;
    private String instagram;
    ArrayList<Mascota> mascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miActionbar = (Toolbar) findViewById(R.id.ab_main_miActionBar);
        setSupportActionBar(miActionbar);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        crearCanalaesNotificaciones();
        notificationManagerCompat = NotificationManagerCompat.from(this);
        //obtenerToken();
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new ReyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dog_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog_face);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.m_contacto:

                Intent intent = new Intent(this, ActivityContacto.class);
                startActivity(intent);

                break;

            case R.id.m_acerca:

                Intent intent1 = new Intent(this, ActivityAcerca.class);
                startActivity(intent1);

                break;

            case R.id.m_configurar_cuenta:

                Intent intent2 = new Intent(this, ActivityConfigurarCuenta.class);
                startActivity(intent2);

                break;

            case R.id.m_recibir_notificaciones:
                obtenerToken();
                break;


        }

        return super.onOptionsItemSelected(item);
    }

    public void irPreferidas(View v) {
        Intent intent = new Intent(MainActivity.this, Preferidas.class);
        startActivity(intent);
    }

    public void obtenerToken(){
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        String msg = getString(R.string.msg_token_fmt, token);
                        Log.d(TAG, msg);
                        obtenerMediosRecientes(token);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void crearCanalaesNotificaciones() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel canal1 = new NotificationChannel(
                    CANAL_1_ID, CANAL_1_NOMBRE,
                    NotificationManager.IMPORTANCE_HIGH);

            canal1.setDescription(CANAL_1_DESCRIPCION);
            //Configurar notificaciones
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(canal1);
        }
    }

    public void registrarInstagramBD(String token, String instagram){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPointApi endPointApi = restApiAdapter.establecerConexionRestAPI();
        Call<UsuarioResponse> usuarioResponseCall = endPointApi.registrarUsuario(token, instagram);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                Log.d("ID_FIREBASE", usuarioResponse.getId());
                Log.d("USUARIO_FIREBASE", usuarioResponse.getToken());
                Log.d("INSTAGRAM", usuarioResponse.getInstagram());
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });
    }
    public void obtenerMediosRecientes(String token) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();

        EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall = endPointApi.getRecentMedia();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                instagram = (mascotas.get(0).getNombreCompleto());
                registrarInstagramBD(token, instagram);
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Algo pago en la conexion intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.i("FALLO LA CONEXION", t.toString());

            }
        });
    }

}