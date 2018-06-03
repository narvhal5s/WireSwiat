package board;

import java.awt.*;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;

import LoadSave.*;

public  class Board {

    private int width ;
    private int height ;
    private Cell[][] board_game ;

    //Konstruktor dla zadanej szerokosci i wysokosci
    public Board(int height , int width) {
        this.width = width;
        this.height = height;
        this.board_game = new Cell[height][width];

        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j ++){
                board_game[i][j] = new Cell() ;
            }
        }
    }



    public void loadBoard ( String filename ) {
        Load generation = null ;
        if(filename.endsWith(".txt")) {
            generation = new LoadingText(height , width);
        }
        int[][] tmp = null;
        tmp = generation.loadGeneration(filename);

        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j ++){
                if(tmp[i][j] == 0) {
                    board_game[i][j].setState(Cell.EMPTY);
                }

                else if(tmp[i][j] == 1) {
                    board_game[i][j].setState(Cell.ELECTRON_HEAD);
                }

                else if(tmp[i][j] == 2) {
                    board_game[i][j].setState(Cell.ELECTRON_TAIL);
                }

                else if(tmp[i][j] == 3) {
                    board_game[i][j].setState(Cell.CONDUCTOR);
                }
            }
        }

    }

    public void genNext(){
        countNeighbours();
        for( int k = 0 ; k < height ; k++ ) {
            for (int l = 0; l < width ; l++) {
                if(board_game[k][l].getState() == Cell.ELECTRON_HEAD){
                    board_game[k][l].setState(Cell.ELECTRON_TAIL);
                }

                else if(board_game[k][l].getState() == Cell.CONDUCTOR && ( board_game[k][l].getNeighbour() == 1 || board_game[k][l].getNeighbour() == 2 ) ){
                    board_game[k][l].setState(Cell.ELECTRON_HEAD);
                }
                else if(board_game[k][l].getState() == Cell.ELECTRON_TAIL ){
                    board_game[k][l].setState(Cell.CONDUCTOR);
                }
            }
        }
    }

    public void saveBoard(String filename) {
        SaveTxt out = new SaveTxt(filename);
        out.saveGeneration(this.parseToTable());
    }

    private void countNeighbours(){
        int neihbour_number = 0 ;
        for(int i = 0 ; i <  height ; i++){
            for(int j = 0 ; j < width ; j ++){
                if(board_game[i][j].getState() == Cell.CONDUCTOR){
                    for(int l = i - 1 ; l < i+2 ; l++){
                        if(l >= 0 && l < height){
                            for(int k = j - 1 ; k < j+2 ; k++){
                                if(k >= 0 && k < width) {
                                    if (k != j || l != i) {
                                        if (board_game[l][k].getState() == Cell.ELECTRON_HEAD) neihbour_number++;
                                    }
                                }
                            }
                        }
                    }
                }
                board_game[i][j].setNeighbour(neihbour_number);
                neihbour_number = 0 ;
            }
        }
    }

    private int[][] parseToTable() {
        int[][] result = new int[height][width];
        for( int k = 0 ; k < height ; k++ ) {
            for (int l = 0; l < width; l++){
                if(board_game[k][l].getState() == Cell.EMPTY) result[k][l] = 0 ;
                if(board_game[k][l].getState() == Cell.ELECTRON_HEAD) result[k][l] = 1 ;
                if(board_game[k][l].getState() == Cell.ELECTRON_TAIL) result[k][l] = 2 ;
                if(board_game[k][l].getState() == Cell.CONDUCTOR) result[k][l] = 3 ;
            }
        }
        return result ;
    }

    public Color getCellState(int x , int y){
        return board_game[y][x].getState() ;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
