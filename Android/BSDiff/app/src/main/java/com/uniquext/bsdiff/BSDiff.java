package com.uniquext.bsdiff;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import androidx.core.content.FileProvider;

import java.io.File;

/**
 * 　 　　   へ　　　 　／|
 * 　　    /＼7　　　 ∠＿/
 * 　     /　│　　 ／　／
 * 　    │　Z ＿,＜　／　　   /`ヽ
 * 　    │　　　 　　ヽ　    /　　〉
 * 　     Y　　　　　   `　  /　　/
 * 　    ｲ●　､　●　　⊂⊃〈　　/
 * 　    ()　 へ　　　　|　＼〈
 * 　　    >ｰ ､_　 ィ　 │ ／／      去吧！
 * 　     / へ　　 /　ﾉ＜| ＼＼        比卡丘~
 * 　     ヽ_ﾉ　　(_／　 │／／           消灭代码BUG
 * 　　    7　　　　　　　|／
 * 　　    ＞―r￣￣`ｰ―＿
 * ━━━━━━━━━━感觉萌萌哒━━━━━━━━━━
 *
 * @author UniqueXT
 * @version 1.0
 * @date 2022/8/1 - 16:04
 */
public class BSDiff {

    static {
        System.loadLibrary("bsdiff");
    }


    public static native boolean bsdiff(String oldApkPath, String newApkPath, String patchPath);

    public static native boolean bspatch(String oldApkPath, String newApkPath, String patchPath);



    public static void test1(Context context) {
        File oldApk = new File(context.getExternalFilesDir("patch"),"old.apk");
        File newFile=new File(context.getExternalFilesDir("patch"),"new.apk");
        File patch = new File(context.getExternalFilesDir("patch"), "update.patch");
        Log.e("####", oldApk.exists() + " # " +  newFile.exists() + " # " + patch.exists());
        boolean diff = BSDiff.bsdiff(oldApk.getAbsolutePath(), newFile.getAbsolutePath(), patch.getAbsolutePath());
        Log.e("####", "diff " + diff);
    }

    public static void test2(Context context) {
        File oldApk = new File(context.getExternalFilesDir("patch"),"old.apk");
        File newFile=new File(context.getExternalFilesDir("patch"),"merge.apk");
        File patch = new File(context.getExternalFilesDir("patch"), "update.patch");
        Log.e("####", oldApk.exists() + " # " +  newFile.exists() + " # " + patch.exists());
        boolean diff = bspatch(oldApk.getAbsolutePath(), newFile.getAbsolutePath(), patch.getAbsolutePath());
        Log.e("####", "bspatch " + diff);
    }

    public static void test3(Context context) {
        File newFile=new File(context.getExternalFilesDir("patch"),"merge.apk");
        installApk(context, newFile);
        Log.e("####", "installApk end");
    }

    private static void installApk(Context context, File newFile) {

        Log.e("####", "installApk ");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { // 7.0+以上版本
            Uri apkUri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", newFile);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(newFile), "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }

}
