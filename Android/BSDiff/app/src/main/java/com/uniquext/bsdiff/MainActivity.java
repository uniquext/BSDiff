package com.uniquext.bsdiff;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_1).setOnClickListener(v -> test1(this));
        findViewById(R.id.tv_2).setOnClickListener(v -> test2(this));
        findViewById(R.id.tv_3).setOnClickListener(v -> test3(this));
    }

    public static void test1(Context context) {
        File oldApk = new File(context.getExternalFilesDir("patch"), "old.apk");
        File newFile = new File(context.getExternalFilesDir("patch"), "new.apk");
        File patch = new File(context.getExternalFilesDir("patch"), "update.patch");
        Log.e("####", oldApk.exists() + " # " + newFile.exists() + " # " + patch.exists());
        boolean diff = BSDiff.bsdiff(oldApk.getAbsolutePath(), newFile.getAbsolutePath(), patch.getAbsolutePath());
        Log.e("####", "diff " + diff);
    }

    public static void test2(Context context) {
        File oldApk = new File(context.getExternalFilesDir("patch"), "old.apk");
        File newFile = new File(context.getExternalFilesDir("patch"), "merge.apk");
        File patch = new File(context.getExternalFilesDir("patch"), "update.patch");
        Log.e("####", oldApk.exists() + " # " + newFile.exists() + " # " + patch.exists());
        boolean diff = BSDiff.bspatch(oldApk.getAbsolutePath(), newFile.getAbsolutePath(), patch.getAbsolutePath());
        Log.e("####", "bspatch " + diff);
    }

    public static void test3(Context context) {
        File newFile = new File(context.getExternalFilesDir("patch"), "merge.apk");
        BSDiff.installApk(context, newFile);
        Log.e("####", "installApk end");
    }

}