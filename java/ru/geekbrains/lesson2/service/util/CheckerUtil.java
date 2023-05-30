package ru.geekbrains.lesson2.service.util;

import ru.geekbrains.lesson2.service.impl.TableServiceImpl;

public class CheckerUtil extends TableServiceImpl {
    CoordinateConvertUtil convertUtil = new CoordinateConvertUtil();

    public boolean checkWin(char c, int pointToWin) {
        // Проверка по трем горизонталям
        int col = TableServiceImpl.gameBoard.getGameBoard().length;
        int row = TableServiceImpl.gameBoard.getGameBoard()[0].length;

        while (true) {
            int marker = 1;
            int count = 1;
            int[] rowAndColFromSection = convertUtil.getRowAndColFromSection(marker);
            if (marker - 1 + pointToWin < TableServiceImpl.gameBoard.getGameBoard()[0].length) {
                for (int i = 0; i < col; i++) {
                    for (int j = 0; j < row; j++) {
                        if (horizontalCheck(j, pointToWin)) return true;
                        if (verticalCheck(i, j, pointToWin,row)) return true;
                    }
                }
            }
        }
    }

    private boolean horizontalCheck(int startIndex, int pointToWin) {
        char[] chars = TableServiceImpl.gameBoard.getGameBoard()[startIndex];
        int count = 1;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[i + 1]) {
                return false;
            } else {
                count++;
            }
        }
        return count == pointToWin;

    }

    private boolean verticalCheck(int startIndexRow, int startIndexCol, int pointToWin, int endIndex) {
        int count = 1;

        for (int i = startIndexRow; i < endIndex; i++) {
            if (TableServiceImpl.gameBoard.getGameBoard()[startIndexCol][startIndexRow] != TableServiceImpl.gameBoard.getGameBoard()[i][startIndexCol]) {
                return false;
            } else {
                count++;
            }
        }
        return count == pointToWin;
    }

    public boolean checkDraw() {
        for (int x = 0; x < TableServiceImpl.gameBoard.getGameBoard().length; x++) {
            for (int y = 0; y < TableServiceImpl.gameBoard.getGameBoard()[0].length; y++)
                if (isCellEmpty(x, y)) return false;
        }
        return true;
    }

    public boolean isCellEmpty(int x, int y) {
        return TableServiceImpl.gameBoard.getGameBoard()[x][y] == TableServiceImpl.DOT_EMPTY;
    }


}
