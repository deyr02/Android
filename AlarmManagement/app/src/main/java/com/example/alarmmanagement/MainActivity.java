package com.example.alarmmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView txt_selected_time;
    Button btn_set_time, btn_set_alarm, btn_cancel_alarm;

    MaterialTimePicker timePicker;
    private  Calendar calendar;
    private AlarmManager alarmManager;

    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CreateNotificationChannel();

        txt_selected_time = findViewById(R.id.txt_ime);

        btn_set_time = (Button) findViewById(R.id.btn_set_time);
        btn_set_alarm = findViewById(R.id.btn_set_alarm);
        btn_cancel_alarm = findViewById(R.id.btn_cancel_alarm);

        btn_set_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowTimePicker();

            }
        });


        btn_set_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlarm();
            }
        });


        btn_cancel_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_cancel_alarm();
            }
        });


    }

    private void btn_cancel_alarm() {
        Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0, intent, 0);

        if (alarmManager == null){
            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        }
        alarmManager.cancel(pendingIntent);
        Toast.makeText(MainActivity.this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
    }

    private void setAlarm() {
        alarmManager = (AlarmManager) getSystemService((Context.ALARM_SERVICE));

        Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);

        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY,
                pendingIntent);
        Toast.makeText(MainActivity.this, "Alarm set successfully", Toast.LENGTH_SHORT).show();
    }

    private void ShowTimePicker() {

        timePicker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select alarm Time")
                .build();

        timePicker.show(getSupportFragmentManager(), "Tag");
      

        timePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timePicker.getHour() > 12){
                    txt_selected_time.setText(
                            String.format("%02d", (timePicker.getHour()-12)) + " : " + String.format("%02d", timePicker.getMinute())+ " PM"
                    );
                }
                else {
                    txt_selected_time.setText(
                            String.format("%02d", (timePicker.getHour())) + " : " + String.format("%02d", timePicker.getMinute())+ " AM"
                    );
                }

                calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                calendar.set(Calendar.MINUTE, timePicker.getMinute());
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
            }
        });
    }

    private void CreateNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "AlarmManagementChennel";
            String Description = "Channnel for Alarm Manager";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("AlarmManagement",name, importance);
            channel.setDescription(Description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}