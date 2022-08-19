# BSDiff
> 该项目基于[BSDiff](http://www.daemonology.net/bsdiff/) 差量更新算法实现。

## 简介
基于两个 apk 字节码的差异，生成 patch 包，然后客户端通过同样的算法，把已安装的 apk 与 patch 包结合生成更新后的 apk 进行安装，以此减小 app 版本升级时的下载时间，提高更新效率。

## 下载
可在 [Release](https://github.com/uniquext/BSDiff/releases/tag/v1.0)中下载 PC端 [可执行程序](https://github.com/uniquext/BSDiff/releases/download/v1.0/bsdiff.zip) 和 Android端 [AAR](https://github.com/uniquext/BSDiff/releases/download/v1.0/bsdiff-release.aar)。

## PC端
可在上述下载地址中直接下载可执行程序，也可下载源码后编译 [C工程](https://github.com/uniquext/BSDiff/tree/master/C/BSDiff)生成。 <br>
下述命令均在 CMD 中执行
* 生成补丁包 <br>
  ***source_old_apk*** ：旧版本APK（即当前版本APK <br>
  ***source_new_apk*** ：新版本APK（即要发布的APK <br>
  ***target_update_patch*** ：目标补丁包 
  ```
  bsdiff source_old_apk source_new_apk  target_update_patch
  ```
* 合成安装包 <br>
  ***source_old_apk*** ：旧版本APK（即当前版本APK <br>
  ***target_merge_apk*** ：合成的APK（即要发布的APK <br>
  ***source_update_patch*** ：对应补丁包 <br>
  ```
  bspatch source_old_apk target_merge_apk  source_update_patch
  ```

## Android端
可在上述下载地址中直接下载AAR，也可下载源码后编译 [Android工程](https://github.com/uniquext/BSDiff/tree/master/Android/BSDiff)生成。
* 生成补丁包 <br>
  ```
  /**
   * 根据新旧 APK 文件生成对应补丁包
   * @param oldApkPath 旧版本apk路径 {@link ApplicationInfo#sourceDir}
   * @param newApkPath 新版本apk路径
   * @param patchPath 目标补丁包
   */
  BSDiff.bsdiff(String oldApkPath, String newApkPath, String patchPath);
  ```
* 合成安装包
  ```
  /**
   * 根据补丁包合成新版本 APK 文件
   * @param oldApkPath 旧版本apk路径 {@link ApplicationInfo#sourceDir}
   * @param newApkPath 目标新版本apk路径
   * @param patchPath 补丁包
   */
  BSDiff.bspatch(String oldApkPath, String newApkPath, String patchPath);
  ```
* 安装APK
  ```
  /**
   * 安装 APK
   * @param context 上下文
   * @param apkFile apk文件
   */
   BSDiff.installApk(Context context, File apkFile);
  ```
