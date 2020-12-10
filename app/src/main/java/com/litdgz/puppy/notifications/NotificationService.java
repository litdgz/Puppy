package com.litdgz.puppy.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.litdgz.puppy.MainActivity;
import com.litdgz.puppy.R;

public class NotificationService extends FirebaseMessagingService {
    public static final String CANAL_1_ID = "canal1";
    private static final String CANAL_1_NOMBRE = "Canal 1";
    private static final String CANAL_1_DESCRIPCION = "Este es Canal 1";
    private NotificationManagerCompat notificationManagerCompat;
    public static final String TAG = "FIREBASE";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());

        crearCanalaesNotificaciones();

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification notification = new NotificationCompat.Builder(
                this, CANAL_1_ID)
                .setDefaults(Notification.DEFAULT_ALL)
                //.setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.icons8_year_of_dragon_48)
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setContentText(remoteMessage.getNotification().getBody())
                .setColor(Color.GREEN)
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
        notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(0, notification);

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

    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);
        sendRegistrationToServer(token);
    }

    public void sendRegistrationToServer(String token){
        Log.d(TAG, token);

    }
}


