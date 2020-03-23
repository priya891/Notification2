package com.example.notification2;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static com.example.notification2.App.CHANNEL_1_ID;
import static com.example.notification2.App.CHANNEL_2_ID;


public class MainActivity extends AppCompatActivity
         {
    public NotificationManagerCompat notificationManager;
    public  EditText editTextTitle;
    public  EditText editTextMessage;
   public  String title,message;
   Button b1,b2;
    private static int NOTIFICATION_ID=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.btn1);
        b2=(Button)findViewById(R.id.btn2);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = editTextTitle.getText().toString();
                message = editTextMessage.getText().toString();

                Log.d("val","ti" +title);
                Notification notification1 = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_1_ID)
                        .setSmallIcon(R.drawable.ic_name)
                        .setVibrate(new long[]{1000,1000,1000,1000})
                        .setContentTitle(title)
                        .setContentText(message)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();
                notificationManager = NotificationManagerCompat.from(getApplicationContext());
                notificationManager.notify(1,notification1);

            }
        });
        try {  // so that both notification does not occur at the same time.
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

 b2.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         title = editTextTitle.getText().toString();
         message = editTextMessage.getText().toString();
            Notification notification2= new NotificationCompat.Builder(getApplicationContext() ,CHANNEL_2_ID)
                    .setSmallIcon(R.drawable.ic_name)
                    .setVibrate(new long[]{1000,1000,1000,1000})
                    .setContentTitle(title)
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .build();
         notificationManager = NotificationManagerCompat.from(getApplicationContext());
            notificationManager.notify(1,notification2);
          }
        });
        }
    }
