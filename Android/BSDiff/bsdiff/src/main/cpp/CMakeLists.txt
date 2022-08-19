# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.18.1)

# Declares and names the project.

project("bsdiff")

# 设置头文件查找路径
include_directories(bzip2 core)

# 把 bzip2 目录下的原文件用 BZIP2_SOURCE 变量表示
aux_source_directory( # 相对目录
        bzip2
        # 变量名
        BZIP2_SOURCE )
aux_source_directory( # 相对目录
        core
        # 变量名
        BSDIFF_SOURCE )


# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
        bsdiff

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        bsdiff.cpp
        ${BZIP2_SOURCE}
        ${BSDIFF_SOURCE} )

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        bsdiff

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})