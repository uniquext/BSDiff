#include <jni.h>
#include <android/log.h>

//
// Created by UniqueXT on 2022/8/1.
//

extern "C" {
extern int executeDiff(int argc, char *argv[]);
}
extern "C"
JNIEXPORT jboolean JNICALL
Java_com_uniquext_bsdiff_BSDiff_bsdiff(JNIEnv *env, jclass clazz, jstring old_apk_path, jstring new_apk_path,
                                       jstring patch_path) {
    int args = 4;
    char *argv[args];
    argv[0] = "bsdiff";

    argv[1] = (char *) (env->GetStringUTFChars(old_apk_path, 0));
    argv[2] = (char *) (env->GetStringUTFChars(new_apk_path, 0));
    argv[3] = (char *) (env->GetStringUTFChars(patch_path, 0));

    int result = executeDiff(args, argv);

    //回收 String
    env->ReleaseStringUTFChars(old_apk_path, argv[1]);
    env->ReleaseStringUTFChars(new_apk_path, argv[2]);
    env->ReleaseStringUTFChars(patch_path, argv[3]);
    __android_log_print(ANDROID_LOG_ERROR, "diff", "==%s==%s==%s==%d", argv[1], argv[2], argv[3], result);
    return result == 0;
}


extern "C" {
extern int executePatch(int argc, char *argv[]);
}
extern "C"
JNIEXPORT jboolean JNICALL
Java_com_uniquext_bsdiff_BSDiff_bspatch(JNIEnv *env, jclass clazz, jstring old_apk_path, jstring new_apk_path,
                                        jstring patch_path) {
    int args = 4;
    char *argv[args];
    argv[0] = "bspatch";

    argv[1] = (char *) (env->GetStringUTFChars(old_apk_path, 0));
    argv[2] = (char *) (env->GetStringUTFChars(new_apk_path, 0));
    argv[3] = (char *) (env->GetStringUTFChars(patch_path, 0));

    int result = executePatch(args, argv);

    //回收 String
    env->ReleaseStringUTFChars(old_apk_path, argv[1]);
    env->ReleaseStringUTFChars(new_apk_path, argv[2]);
    env->ReleaseStringUTFChars(patch_path, argv[3]);
    __android_log_print(ANDROID_LOG_ERROR, "diff", "==%s==%s==%s==%d", argv[1], argv[2], argv[3], result);
    return result == 0;
}