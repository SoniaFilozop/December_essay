package ru.myitschool.vsu2021.filozop_s_a.decemberessay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button transfer;
    Button transfer1;
    Button transfer2;
    Button transfer3;
    Button transfer4;

    private NotificationManager notificationManager;
    private static final int NOTIFY_ID = 1;
    private static final String CHANNEL_ID = "CHANNEL_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transfer = (Button) findViewById(R.id.transfer);
        transfer1 = (Button) findViewById(R.id.transfer1);
        transfer2 = (Button) findViewById(R.id.transfer2);
        transfer3 = (Button) findViewById(R.id.transfer3);
        transfer4 = (Button) findViewById(R.id.transfer4);

    }


    public void Click(View view) {
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        switch (view.getId()) {
            case R.id.transfer:
                intent.putExtra("id_theme", 1);
                startActivity(intent);
                break;
            case R.id.transfer1:
                intent.putExtra("id_theme", 2);
                startActivity(intent);
                break;
            case R.id.transfer2:
                intent.putExtra("id_theme", 3);
                startActivity(intent);
                break;
            case R.id.transfer3:
                intent.putExtra("id_theme", 4);
                startActivity(intent);
                break;
            case R.id.transfer4:
                intent.putExtra("id_theme", 5);
                startActivity(intent);
                break;
        }


    }
}
