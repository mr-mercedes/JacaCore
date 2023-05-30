package ru.geekbrains.lesson2.model;

public class Table {
    private char[][]gameBoard;

    public Table(int col, int row) {
        this.gameBoard = new char[col][row];
    }

    public char[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(char[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
}
