#include "Main.h"
#include <iostream>
#include <jni.h>

#include "Board.h"

Board board;

JNIEXPORT jboolean JNICALL Java_Main_fiveInRow(JNIEnv *, jclass) {

    bool result = board.fiveInRow();
    return result ? JNI_TRUE : JNI_FALSE;

}

JNIEXPORT jint JNICALL Java_Main_gameState(JNIEnv *, jclass) {

    return board.gameState();
}
JNIEXPORT jint JNICALL Java_Main_getBoardState
(JNIEnv *, jclass, jint x, jint y) {
   return board.getBoardState(x, y);
}
JNIEXPORT void JNICALL Java_Main_mouseClicked
  (JNIEnv *, jclass, jint x, jint y) {
    return board.mouseClicked(x, y);
}

JNIEXPORT void JNICALL Java_Main_setBoardSize
  (JNIEnv *, jclass, jint x) {
    board.setBoardSize(x);
}

JNIEXPORT jint JNICALL Java_Main_getBoardSize
  (JNIEnv *, jclass) {

    return board.getBoardSize();
}

JNIEXPORT void JNICALL Java_Main_keyPressed
  (JNIEnv *, jclass, jchar c) {

    return board.keyPressed(c);
}