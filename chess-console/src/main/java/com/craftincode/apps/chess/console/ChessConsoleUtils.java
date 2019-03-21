package com.craftincode.apps.chess.console;

// pionki: https://en.wikipedia.org/wiki/Chess_symbols_in_Unicode
// bloki: jasny: 2591, ciemny: 2591
public class ChessConsoleUtils {
    public static void main(String[] args) {
        char[][] sampleBoard = new char[8][8];
        // uzupelnic sensownie szachownice pionkami
        sampleBoard[3][4] = '\u265E';
        // nie umieszczaj bloków w tym boardzie, tylko pionki
        printBoard(sampleBoard);
    }
    public static void printBoard(char[][] board){
        for(char[] row:board){
            for(char position:row){
                System.out.print((position == 0 ? "_" :
                        position) + "|");
            }
            System.out.println();
        }
    }
}
