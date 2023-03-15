package com.example.testik;


import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.TextView;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.testik.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    TextView labelDatum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labelDatum = findViewById(R.id.twDatum);
        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);

        labelDatum.setText(formattedDate);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.vse);

        //System.out.println("Current time => " + c);
    }
    FragmentVse fragmentVse = new FragmentVse();
    FragmentObj fragmentObj = new FragmentObj();
    MapsFragment mapsFragment = new MapsFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.vse:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentVse).commit();
                return true;

            case R.id.objednavka:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentObj).commit();
                return true;

            case R.id.mapa:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mapsFragment).commit();
                return true;
        }
        return false;
    }
}