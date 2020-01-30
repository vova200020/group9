package com.example.parknow;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Booking extends AppCompatActivity {

    BookingDatabase myDb;

    Button selectDate;
    TextView showDate;
    Button selArrTime;
    TextView strtTime;
    Button selLeavTime;
    TextView timeEnd;

    Calendar c;
    DatePickerDialog datePickerDialog;
    int year, month, day, hour, min, hourFinal, minFinal;

    protected void onCreate(Bundle savedInstanceState){
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reserve);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.booking_actionbar);

        myDb = new BookingDatabase(this);

        selectDate = (Button) findViewById(R.id.dateSelect);
        showDate = (TextView) findViewById(R.id.dateStrt);
        selArrTime = (Button) findViewById(R.id.strtArriv);
        strtTime = (TextView) findViewById(R.id.timeStrt);
        selLeavTime = (Button) findViewById(R.id.endLeav);
        timeEnd = (TextView) findViewById(R.id.timeEnd);

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                day = c.get(Calendar.DAY_OF_MONTH);
                month = c.get(Calendar.MONTH);
                year = c.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(Booking.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int nYear, int nMonth, int nDay) {
                        c.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());
                        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd");
                        c.set(nYear, nMonth, nDay);
                        String dateString = sdf.format(c.getTime());
                        showDate.setText(dateString);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        selArrTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener timepickerlistener1 = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        // this is the listener for the first timepicker
                        //get your start time from here
                        hour = i;
                        min = i1;
                        strtTime.setText(hour +":" + min);
                    }
                };
                TimePickerDialog mTimePicker1 = new TimePickerDialog(Booking.this, timepickerlistener1,
                        hour, min, true);//parameters ---- > context, listener for the timepicker, hour, minute, is24hours?
                mTimePicker1.show();
            }
        });
        selLeavTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener timepickerlistener2 = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        // this is the listener for the first timepicker
                        //get your start time from here
                        hourFinal = i;
                        minFinal = i1;
                        timeEnd.setText(hourFinal +":" + minFinal);
                    }
                };
                TimePickerDialog mTimePicker2 = new TimePickerDialog(Booking.this, timepickerlistener2,
                        hourFinal, minFinal, true);//parameters ---- > context, listener for the timepicker, hour, minute, is24hours?
                mTimePicker2.show();

            }
        });

    }


}
