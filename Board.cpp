//
// Created by Vitalii Koltok on 29/10/2024.
//

#include "Board.h"

#include <iostream>
#include <ostream>

Board::Board() {
    this->currentPlayer = 1;
    this->boardSize = 15;
    boardState.resize(boardSize + 5, std::vector<int>(boardSize + 5));

}

void Board::setBoardSize(int size) {
    this->boardSize = size;
    boardState.clear();
    this->boardState.resize(boardSize + 5, std::vector<int>(boardSize + 5));
    this->currentPlayer = 1;
    this->pointsToWin = 5;

    // this.requestFocus();
    this->hor = 0;
    this->ver = 0;
}


bool Board::fiveInRow() {
    bool win = false;
    for (int i = 0; i < boardSize+1; i++) {
        for (int j = 0; j < boardSize+1; j++) {
            if(boardState[i][j] == currentPlayer //5 in a row Horizontally
                    && boardState[i+1][j] == currentPlayer
                    && boardState[i+2][j] == currentPlayer
                    && boardState[i+3][j] == currentPlayer
                    && boardState[i+4][j] == currentPlayer
                    ||
                    boardState[i][j] == currentPlayer //5 in a row Vertically
                            && boardState[i][j+1] == currentPlayer
                            && boardState[i][j+2] == currentPlayer
                            && boardState[i][j+3] == currentPlayer
                            && boardState[i][j+4] == currentPlayer
                    || boardState[i][j] == currentPlayer //5 in a row Diagonally
                    && boardState[i+1][j+1] == currentPlayer
                    && boardState[i+2][j+2] == currentPlayer
                    && boardState[i+3][j+3] == currentPlayer
                    && boardState[i+4][j+4] == currentPlayer
                        || boardState[i+pointsToWin-1][j] == currentPlayer //5 in a row Diagonally other way
                    && boardState[i+pointsToWin-2][j+1] == currentPlayer
                    && boardState[i+pointsToWin-3][j+2] == currentPlayer
                    && boardState[i+pointsToWin-4][j+3] == currentPlayer
                    && boardState[i+pointsToWin-5][j+4] == currentPlayer
            ){
                win = true;
            }
        }
    }
    return win;
}

int Board::gameState() {
    int state = 0; // 0 - nothing, 1 - black won, 2 - white won
    if(currentPlayer == 1 && fiveInRow()){
        state = 1;
    }
    if(currentPlayer == 2 && fiveInRow()){
        state = 2;
    }
    if(checkTie()) {
        state = 3;
    }

    return state;
}

void Board::mouseClicked(int x, int y) {

    if(boardState[x][y] == 0) {
        boardState[x][y] = currentPlayer;
        if(gameState() == 0 && currentPlayer == 1){
            currentPlayer = 2;
        } else if(gameState() == 0 && currentPlayer == 2){
            currentPlayer = 1;
        }
    }
}

int Board::getBoardState(int x, int y) {
    return boardState[x][y];
}

int Board::getBoardSize() {
    return this->boardSize;
}

void Board::keyPressed(char key) {
    int jump = 0;


    if(key == 'w' && ver > 0) {
        if(boardState[hor][0] == 0 && boardState[hor][ver-1] != 0 ) {
            do {
                ver--;
                jump++;
                boardState[hor][ver + jump] = 0;

            }
            while (boardState[hor][ver] != 0);
        } else if (boardState[hor][ver-1] == 0) {
            ver--;
            boardState[hor][ver+1] = 0;
        }
        boardState[hor][ver] = currentPlayer + 2;

    }
    if(key == 's' && ver < boardSize - 1) {
        jump = 0;
        if(boardState[hor][boardSize-1] == 0 && boardState[hor][ver+1] != 0 ) {
            do {
                ver++;
                jump++;
                boardState[hor][ver - jump] = 0;

            }
            while (boardState[hor][ver] != 0);
        } else if (boardState[hor][ver+1] == 0) {
            ver++;
            boardState[hor][ver-1] = 0;
        }
        boardState[hor][ver] = currentPlayer + 2;

    }
    if(key == 'd' && hor < boardSize - 1) {
        jump = 0;
        if(boardState[boardSize-1][ver] == 0 && boardState[hor+1][ver] != 0 ) {
            do {
                hor++;
                jump++;
                boardState[hor-jump][ver] = 0;

            }
            while (boardState[hor][ver] != 0);
        } else if (boardState[hor+1][ver] == 0) {
            hor++;
            boardState[hor-1][ver] = 0;
        }
        boardState[hor][ver] = currentPlayer + 2;

    }
    if(key == 'a' &&  hor > 0) {
        jump = 0;
        if(boardState[0][ver] == 0 && boardState[hor-1][ver] != 0 ) {
            do {
                hor--;
                jump++;
                boardState[hor + jump][ver] = 0;

            }
            while (boardState[hor][ver] != 0);
        } else if (boardState[hor-1][ver] == 0) {
            hor--;
            boardState[hor+1][ver] = 0;
        }
        boardState[hor][ver] = currentPlayer + 2;
    }
        if(key == 'e' && gameState() == 0) { // enter
            boardState[hor][ver] = currentPlayer;
            for (int i = 0; i < boardSize; i++) { // check for the next free cell to put premove into
                for (int j = 0; j < boardSize; j++) {
                    if(boardState[i][j] == 0) {
                        hor = i;
                        ver = j;
                        if(gameState() == 0 && currentPlayer == 1){
                            currentPlayer = 2;
                        } else if(gameState() == 0 && currentPlayer == 2){
                            currentPlayer = 1;
                        }
                        boardState[hor][ver] = currentPlayer + 2;
                        i = boardSize; // to quit the second loop
                        break;
                    }
                }
            }
        }

}

bool Board::checkTie() {
    bool tie = false;
    for (int i = 0; i < boardSize; ++i) {
        for (int j = 0; j < boardSize; ++j) {
            while(boardState[i][j] == 0) {
                return tie;
            }

        }
    }
    tie = true;
    return tie;
}



