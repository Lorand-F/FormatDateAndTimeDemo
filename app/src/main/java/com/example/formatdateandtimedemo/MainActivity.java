package com.example.formatdateandtimedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Spinner spDay, spMonth, spYear, spHour, spMinute, spSecond, spTime;
    TextView tvResult;
    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spDay=findViewById(R.id.sp_day);
        spMonth=findViewById(R.id.sp_month);
        spYear=findViewById(R.id.sp_year);
        spHour=findViewById(R.id.sp_hour);
        spMinute=findViewById(R.id.sp_minute);
        spSecond=findViewById(R.id.sp_second);
        spTime=findViewById(R.id.sp_time);
        tvResult=findViewById(R.id.tv_result);

        date= Calendar.getInstance().getTime();

        ArrayList<String > dayList=new ArrayList<>();
        dayList.add("d");
        dayList.add("dd");
        dayList.add("EEE");
        dayList.add("EEEE");
        spDay.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,dayList));
        spDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String sResult=changeFormat(date, dayList.get(i));
                tvResult.setText(sResult);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private String changeFormat(Date date, String s) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(s);
        return simpleDateFormat.format(date);
    }
}