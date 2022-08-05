package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }


    //    public static void test1(Context context) {
//        File oldApk = new File(context.getExternalFilesDir("patch"),"test_1_1.0_0801.0712.apk");
//        File newFile=new File(context.getExternalFilesDir("patch"),"test_2_1.1_0801.0712.apk");
//        File patch = new File(context.getExternalFilesDir("patch"), "update.patch");
//        Log.e("####", oldApk.exists() + " # " +  newFile.exists() + " # " + patch.exists());
//        boolean diff = BSDiff.bsdiff(oldApk.getAbsolutePath(), newFile.getAbsolutePath(), patch.getAbsolutePath());
//        Log.e("####", "diff " + diff);
//    }
//
//    public static void test2(Context context) {
//        File oldApk = new File(context.getExternalFilesDir("patch"),"test_1_1.0_0801.0712.apk");
//        File newFile=new File(context.getExternalFilesDir("patch"),"update.apk");
//        File patch = new File(context.getExternalFilesDir("patch"), "update.patch");
//        Log.e("####", oldApk.exists() + " # " +  newFile.exists() + " # " + patch.exists());
//        boolean diff = BSDiff.bspatch(oldApk.getAbsolutePath(), newFile.getAbsolutePath(), patch.getAbsolutePath());
//        Log.e("####", "bspatch " + diff);
//    }
}
