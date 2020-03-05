package com.example.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int max = 100;

    ListView timesTableListView;

    public void generateList(int multiply) {
        ArrayList<String> timesArray = new ArrayList<String>();

        for(int i = 1; i <= 10; i++) {
            timesArray.add(Integer.toString(i*multiply));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, timesArray);

        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar baseSeekBar = findViewById(R.id.seekBar);
        timesTableListView = findViewById(R.id.listView);

        baseSeekBar.setMax(max);
        baseSeekBar.setProgress(1);
        generateList(1);

        baseSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int min = 1, timesTableNumber;

                if(progress < min) {
                    timesTableNumber = 1;
                    progress = 1;
                } else {
                    timesTableNumber = progress;
                }
                generateList(timesTableNumber);
                Log.i("SeekBar Number", Integer.toString(timesTableNumber));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }
}
