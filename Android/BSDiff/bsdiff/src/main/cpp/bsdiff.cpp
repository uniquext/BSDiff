#include <jni.h>
#include <android/log.h>

#ifndef TAG
#define TAG "BSDIFF"
#endif

extern "C" {
extern int executeDiff(int argc, char *argv[]);
}
extern "C"
JNIEXPORT jboolean JNICALL
Java_com_uniquext_bsdiff_BSDiff_bsdiff(JNIEnv *env, jclass clazz,
                                       jstring old_apk_path, jstring new_apk_path, jstring patch_path) {
    int args = 4;
    char *argv[args];
    argv[0] = (char *) "bsdiff";

    argv[1] = (char *) (env->GetStringUTFChars(old_apk_path, JNI_FALSE));
    argv[2] = (char *) (env->GetStringUTFChars(new_apk_path, JNI_FALSE));
    argv[3] = (char *) (env->GetStringUTFChars(patch_path, JNI_FALSE));

    __android_log_print(ANDROID_LOG_INFO, TAG, "%s %s %s %s", argv[0], argv[1], argv[2], argv[3]);
    int result = executeDiff(args, argv);
    __android_log_print(ANDROID_LOG_INFO, TAG, "%s result code: %d", argv[0], result);

    //回收 String
    env->ReleaseStringUTFChars(old_apk_path, argv[1]);
    env->ReleaseStringUTFChars(new_apk_path, argv[2]);
    env->ReleaseStringUTFChars(patch_path, argv[3]);

    return result == 0;
}


extern "C" {
extern int executePatch(int argc, char *argv[]);
}
extern "C"
JNIEXPORT jboolean JNICALL
Java_com_uniquext_bsdiff_BSDiff_bspatch(JNIEnv *env, jclass clazz,
                                        jstring old_apk_path, jstring new_apk_path, jstring patch_path) {
    int args = 4;
    char *argv[args];
    argv[0] = (char *) "bspatch";

    argv[1] = (char *) (env->GetStringUTFChars(old_apk_path, JNI_FALSE));
    argv[2] = (char *) (env->GetStringUTFChars(new_apk_path, JNI_FALSE));
    argv[3] = (char *) (env->GetStringUTFChars(patch_path, JNI_FALSE));

    __android_log_print(ANDROID_LOG_INFO, TAG, "%s %s %s %s", argv[0], argv[1], argv[2], argv[3]);
    int result = executePatch(args, argv);
    __android_log_print(ANDROID_LOG_INFO, TAG, "%s result code: %d", argv[0], result);

    //回收 String
    env->ReleaseStringUTFChars(old_apk_path, argv[1]);
    env->ReleaseStringUTFChars(new_apk_path, argv[2]);
    env->ReleaseStringUTFChars(patch_path, argv[3]);

    return result == 0;
}
