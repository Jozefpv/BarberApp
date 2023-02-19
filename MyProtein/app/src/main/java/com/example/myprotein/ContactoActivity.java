package com.example.myprotein;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class ContactoActivity extends AppCompatActivity {

    private PendingIntent pendingIntent;
    private final static String CHANNEL_ID = "NOTIFICACION";
    private final static int NOTIFICACION_ID = 0;
    public TextView nombre;
    public TextView correo;
    public TextView asunto;
    public TextView mensaje;
    public CheckBox condiciones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
    }

    @Override
    protected void onResume() {
        super.onResume();
        nombre = (TextView) findViewById(R.id.nombreValue);
        correo = (TextView) findViewById(R.id.correoValue);
        asunto = (TextView) findViewById(R.id.asuntoValue);
        mensaje = (TextView) findViewById(R.id.mensajeValue);
        condiciones = (CheckBox) findViewById(R.id.condicionesCheckBox);

    }

    public void onEnviarAction(View view){
        if(nombre.length()==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Falta por rellenar el nombre");
            AlertDialog dialogo = builder.create();
            dialogo.show();
        } else if(correo.length()==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Falta por rellenar el correo");
            AlertDialog dialogo = builder.create();
            dialogo.show();
        }else if(asunto.length()==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Falta por rellenar el asunto");
            AlertDialog dialogo = builder.create();
            dialogo.show();
        }else if(mensaje.length()==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Falta por rellenar el mensaje");
            AlertDialog dialogo = builder.create();
            dialogo.show();
        }else if(!condiciones.isChecked()){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Falta aceptar las condicones");
            AlertDialog dialogo = builder.create();
            dialogo.show();
        }
        else {
            AlertDialog.Builder builderDialog = new AlertDialog.Builder(this);
            builderDialog.setMessage("Enviado");
            AlertDialog dialogo = builderDialog.create();
            dialogo.show();
            createNotificationChannel();
            createNotification();
            nombre.setText("");
            correo.setText("");
            asunto.setText("");
            mensaje.setText("");
        }
    }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Noticacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.check);
        builder.setContentTitle("Notificacion MyProtein");
        builder.setContentText("Reporte enviado con éxito");
        builder.setColor(Color.BLUE);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setLights(Color.MAGENTA, 1000, 1000);
        builder.setVibrate(new long[]{1000,1000,1000,1000,1000});
        builder.setDefaults(Notification.DEFAULT_SOUND);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICACION_ID, builder.build());
    }
}