package ru.geekbrains.lesson4;

import ru.geekbrains.lesson4.exeption.MyArraySizeException;

import java.util.*;

public class ArrayFabric {
    private String[][] array;

    public ArrayFabric(int col, int row) {
        array = new String[col][row];
    }

    public String[][] getArray() {
        return array;
    }

    public void fillArrayStringDigits() throws MyArraySizeException {
        if ((array.length % 2 != 0 || array[0].length % 2 != 0) || array.length != array[0].length) {
            throw new MyArraySizeException(String.format("Wrong size array. Yours array has size %s * %s.\n", array.length, array[0].length));
        }

        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = String.valueOf(rd.nextInt(50));
            }
        }
    }

    public void fillArrayRandom() throws MyArraySizeException {
        if ((array.length % 2 != 0 || array[0].length % 2 != 0) || array.length != array[0].length) {
            throw new MyArraySizeException(String.format("Wrong size array. Yours array has size %s * %s.\n", array.length, array[0].length));
        }

        List<String> arr = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "+", "-", "*", "/", "a", "b", "c", "d", "e"));
        Collections.shuffle(arr);
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = arr.get(rd.nextInt(arr.size()));
            }
        }
    }

}
