# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.18.1)

# 把 bzip2 目录下的原文件用 BZIP2_SOURCE 变量表示
aux_source_directory(bzip2 BZIP2_SOURCE)
# 设置头文件查找路径
include_directories(bzip2)

# Declares and names the project.
project("bsdiff")

add_executable(bsdiff core/bsdiff.c ${BZIP2_SOURCE})
add_executable(bspatch core/bspatch.c ${BZIP2_SOURCE})
# add_library(bsdiff SHARED

#         # 参与编译的源码.
#         # bsdiff.cpp
#         bsdiff.c bspatch.c
#         ${BSDIFF_SOURCE} )