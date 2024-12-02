//
// Created by Vitalii Koltok on 29/10/2024.
//

#ifndef GAMELOGIC_H
#define GAMELOGIC_H
#include <vector>
#include <jni.h>


class Board {

    int cellSize;
    std::vector<std::vector<int>> boardState; // 0: empty, 1: black, 2: white 3: black premove 4: white premove
    int currentPlayer = 1; // 1 - Black, 2 - White
    int pointsToWin = 5;
    int hor = 0;
    int ver = 0;
    int boardSize;

public:
    Board();
    void setBoardSize(int size);
    bool fiveInRow();
    int gameState();
    void mouseClicked(int x, int y);
    int getBoardState(int x, int y);
    int getBoardSize();
    void keyPressed(char key);
    bool checkTie();

};



#endif //GAMELOGIC_H
