package com.litdgz.puppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.litdgz.puppy.adapter.PageAdapter;
import com.litdgz.puppy.fragments.PerfilFragment;
import com.litdgz.puppy.fragments.ReyclerViewFragment;
import com.litdgz.puppy.pojo.Mascota;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miActionbar = (Toolbar) findViewById(R.id.ab_main_miActionBar);
        setSupportActionBar(miActionbar);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
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
        }

        return super.onOptionsItemSelected(item);
    }

    public void irPreferidas(View v) {
        Intent intent = new Intent(MainActivity.this, Preferidas.class);
        startActivity(intent);
    }

}