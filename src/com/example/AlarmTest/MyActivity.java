package com.example.AlarmTest;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MyActivity extends Activity {
    Button button;
    Calendar calendar=Calendar.getInstance();
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button=(Button)findViewById(R.id.setTime);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar currentTime=Calendar.getInstance();

                new TimePickerDialog(MyActivity.this, 0, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        Intent intent = new Intent(MyActivity.this, AlarmActivity.class);
                        PendingIntent pi = PendingIntent.getActivity(MyActivity.this, 0, intent, 0);
                        Calendar c = Calendar.getInstance();
                        c.setTimeInMillis(System.currentTimeMillis());
                        c.set(Calendar.HOUR,i);
                        c.set(Calendar.MINUTE, i1);
                        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                        alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi);
                        Toast.makeText(MyActivity.this, "闹铃设置成功", Toast.LENGTH_SHORT).show();
                    }
                },calendar.get(Calendar.HOUR_OF_DAY),currentTime.get(Calendar.MINUTE),false).show();

            }
        });
    }
}
