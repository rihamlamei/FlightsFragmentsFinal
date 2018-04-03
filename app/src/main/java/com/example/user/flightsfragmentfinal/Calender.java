package com.example.user.flightsfragmentfinal;

import android.content.Intent;
import android.icu.util.Calendar;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.util.Date;

public class Calender extends AppCompatActivity {
    int counter = 0;
    public static String datefrom;
    public static String dateto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        Button btn_done = (Button)findViewById(R.id.button_timeSelected);

        final Date today = new Date();
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        final CalendarPickerView datePicker = (CalendarPickerView)findViewById(R.id.calendar);
        datePicker.init(today, nextYear.getTime()).inMode(CalendarPickerView.SelectionMode.RANGE);

        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                Calendar calselected = Calendar.getInstance();
                calselected.setTime(date);

                String selectedDate ="" + calselected.get(Calendar.DAY_OF_MONTH)
                        + " " + (calselected.get(Calendar.MONTH)+1)
                        +" " + (calselected.get(Calendar.YEAR));
                if(counter %2==0) {
                    datefrom = selectedDate;
                    Log.d("from", datefrom);

                }
                else
                {
                    dateto = selectedDate;
                    Log.d("to", dateto);
                }
                counter++;
                Toast.makeText(Calender.this, selectedDate, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Calender.this, BlankFragment.class);
                startActivity(i);
            }
        });
    }
}
