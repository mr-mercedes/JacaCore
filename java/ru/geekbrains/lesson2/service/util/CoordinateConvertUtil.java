package ru.geekbrains.lesson2.service.util;

import ru.geekbrains.lesson2.service.impl.TableServiceImpl;

public class CoordinateConvertUtil extends TableServiceImpl {

    public int[] getRowAndColFromSection(int section) {

        int col = TableServiceImpl.gameBoard.getGameBoard().length;
        int row = TableServiceImpl.gameBoard.getGameBoard()[0].length;

//        if (section % col - row < 0) {
//            System.out.println("Секции с таким номером не сужествует");
//            throw new RuntimeException();
//        }

        int count = 0;
        int[] coordinate = new int[2];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                count++;
                if (count == section){
                    coordinate[0] = i;
                    coordinate[1] = j;
                    return coordinate;
                }
            }
        }
        return new int[]{-1,-1};
    }

    public int getNumberOfSectionFromCoordinate(int row, int col) {
        if (row != 0){
            int length = getIndex();
            return length * row + col + 1;
        } else {
            return col + 1;
        }
    }

    private int getIndex(){
        return TableServiceImpl.gameBoard.getGameBoard()[0].length;
    }
}
