package com.uniquext.bsdiff;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;

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

    /**
     * 根据新旧 APK 文件生成对应补丁包
     * @param oldApkPath 旧版本apk路径 {@link ApplicationInfo#sourceDir}
     * @param newApkPath 新版本apk路径
     * @param patchPath 目标补丁包
     */
    public static native boolean bsdiff(String oldApkPath, String newApkPath, String patchPath);

    /**
     * 根据补丁包合成新版本 APK 文件
     * @param oldApkPath 旧版本apk路径 {@link ApplicationInfo#sourceDir}
     * @param newApkPath 目标新版本apk路径
     * @param patchPath 补丁包
     */
    public static native boolean bspatch(String oldApkPath, String newApkPath, String patchPath);

    /**
     * 安装 APK
     * @param context 上下文
     * @param apkFile apk文件
     */
    public static void installApk(Context context, File apkFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Uri apkUri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", apkFile);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }

}
