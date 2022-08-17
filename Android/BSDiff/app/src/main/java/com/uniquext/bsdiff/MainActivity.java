package com.uniquext.bsdiff;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_1).setOnClickListener(v -> BSDiff.test1(this));
        findViewById(R.id.tv_2).setOnClickListener(v -> BSDiff.test2(this));
        findViewById(R.id.tv_3).setOnClickListener(v -> BSDiff.test3(this));
    }


}