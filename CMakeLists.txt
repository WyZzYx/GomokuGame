cmake_minimum_required(VERSION 3.29)
project(UTPProjectGomoku)

set(CMAKE_CXX_STANDARD 20)

add_library(UTPProjectGomoku SHARED
        Main.cpp
        Main.h
        Board.cpp
        Board.h)



target_include_directories(UTPProjectGomoku PRIVATE "/Users/vitaliikoltok/Library/Java/JavaVirtualMachines/openjdk-23/Contents/Home/include")
target_include_directories(UTPProjectGomoku PRIVATE "/Users/vitaliikoltok/Library/Java/JavaVirtualMachines/openjdk-23/Contents/Home/include/darwin")