package ru.geekbrains.lesson2.service.impl;

import ru.geekbrains.lesson2.model.Table;
import ru.geekbrains.lesson2.service.TableService;
import ru.geekbrains.lesson2.service.util.CoordinateConvertUtil;


import java.util.Arrays;
import java.util.Scanner;

public class TableServiceImpl implements TableService {
    protected static Table gameBoard;

    protected static final char DOT_EMPTY = '*';
    protected static final char DOT_PLAYER = 'X';
    protected static final char DOT_BOT = 'O';
    private final Scanner SCANNER = new Scanner(System.in);

    public TableServiceImpl() {
    }

    @Override
    public void setSymbol(char symbol, int section) {
        CoordinateConvertUtil convertUtil = new CoordinateConvertUtil();
        int x = convertUtil.getRowAndColFromSection(section)[0];
        int y = convertUtil.getRowAndColFromSection(section)[1];
        gameBoard.getGameBoard()[x][y] = symbol;
    }

    public boolean isCellValid(int section) {
        CoordinateConvertUtil convertUtil = new CoordinateConvertUtil();
        int x = convertUtil.getRowAndColFromSection(section)[0];
        int y = convertUtil.getRowAndColFromSection(section)[1];
        if (x < 0 || x > gameBoard.getGameBoard().length - 1 || y < 0 || y > gameBoard.getGameBoard().length - 1) {
            System.out.println("Вы ввели некорректный номер клетки!");
            return false;
        }
        if (gameBoard.getGameBoard()[x][y] == DOT_EMPTY) {
            return true;
        } else {
            System.out.println("Вы ввели координаты занятой клетки!");
        }

        return false;
    }

    @Override
    public void createBoard() {
        String[] gameBoardArg = getSizeBoard();
        int col = 0;
        int row = 0;
        try {
            col = Math.abs(Integer.parseInt(gameBoardArg[0]));
            row = Math.abs(Integer.parseInt(gameBoardArg[1]));
            gameBoard = new Table(col, row);
            fillGameBoard();
        } catch (NumberFormatException ex) {
            System.out.println("Ошибка ввода размера игрового поля");
            System.out.println(ex.getMessage());
            createBoard();
        }
    }

    @Override
    public void printTable() {
        int col = gameBoard.getGameBoard().length;
        int row = gameBoard.getGameBoard()[0].length;

        System.out.println();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.printf("| %c ", gameBoard.getGameBoard()[i][j]);
            }
            System.out.println("| ");
        }
        System.out.println();
    }


    private void fillGameBoard() {
        for (int i = 0; i < gameBoard.getGameBoard().length; i++) {
            Arrays.fill(gameBoard.getGameBoard()[i], DOT_EMPTY);
        }
    }

    private String[] getSizeBoard() {
        String[] gameBoardSizeArgument = new String[2];
        System.out.println("Введите размер игрового поля.");
        System.out.print("Введите количество строк -> ");
        gameBoardSizeArgument[0] = SCANNER.next();
        System.out.print("Введите количество столбцов -> ");
        gameBoardSizeArgument[1] = SCANNER.next();
        return gameBoardSizeArgument;
    }

    public boolean checkWin(char playerSymbol) {
        if (isDraw()) {
            System.out.println("Ничья");
            return true;
        }

        boolean checkLine, checkColumns, checkDiagonalA, checkDiagonalB;
        for (int i = 0; i < gameBoard.getGameBoard().length; i++) {
            checkLine = true;
            checkColumns = true;
            checkDiagonalA = true;
            checkDiagonalB = true;
            for (int j = 0; j < gameBoard.getGameBoard().length; j++) {
                checkLine &= (gameBoard.getGameBoard()[i][j] == playerSymbol);
                checkColumns &= (gameBoard.getGameBoard()[j][i] == playerSymbol);
                checkDiagonalA &= (gameBoard.getGameBoard()[j][j] == playerSymbol);
                checkDiagonalB &= (gameBoard.getGameBoard()[gameBoard.getGameBoard().length - 1 - j][j] == playerSymbol);
            }
            if (checkLine || checkColumns || checkDiagonalA || checkDiagonalB) return true;
        }
        return false;
    }
    public boolean isDraw(){
        for (int i = 0; i < gameBoard.getGameBoard().length; i++) {
            for (int j = 0; j < gameBoard.getGameBoard()[0].length; j++) {
                if (gameBoard.getGameBoard()[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean isGameOver() {
        if (checkWin('X')){
            System.out.println("Вы победили");
            return true;
        }
        if (checkWin('O')){
            System.out.println("Компьютер победил");
            return true;
        }
        if (isDraw()){
            System.out.println("Ничья");
            return true;
        }
        return false;
    }


    public int getMaxSection(){
        return gameBoard.getGameBoard().length * gameBoard.getGameBoard()[0].length;
    }
}
