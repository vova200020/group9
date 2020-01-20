package com.example.parknow;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_layout);

        final Button booking_d_t = findViewById(R.id.searchHere);

        booking_d_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookingArrivLeave();
            }
        });

    }
    public void bookingArrivLeave(){
        Intent searchHere = new Intent(this, SearchBooking.class);
        startActivity(searchHere);

    }
}
