package ru.geekbrains.lesson4.util;

import ru.geekbrains.lesson4.ArrayFabric;
import ru.geekbrains.lesson4.exeption.MyArrayDataException;
import ru.geekbrains.lesson4.exeption.MyArraySizeException;

import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayUtil {

    public boolean menu() throws IOException {
        int choose = 0;
        int exit = 0;
        try  {
            Scanner sc = new Scanner(System.in);
            System.out.println("Hello! It's program for testing array." +
                    "\nPlease choose version of program");

            System.out.println("\"Right\" array press 1 || \"Wrong\" array press 2");
            choose = sc.nextInt();

            int[] size = getSize();
            switch (choose) {
                case 1 -> rightTestArray(size, true);
                case 2 -> wrongTestArray(size, false);
            }

            System.out.println("If you want continue press any number || If you want exit press 11");
            exit = sc.nextInt();
            if (exit == 11) {
                return false;
            }
        } catch (NoSuchElementException exception){
            System.out.println("Again exception");
        }
        return true;
    }

    private int[] getSize() {
        Scanner sc = new Scanner(System.in);
        int[] size = new int[2];
        System.out.println("Enter size of array.");
        for (int i = 0; i < size.length; i++) {
            System.out.print(i % 2 == 0 ? "Enter col ->" : "Enter row ->");
            size[i] = sc.nextInt();
        }
        return size;
    }

    public void printArray(String[][] arr) {
        for (String[] items : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(items[j] + "\t");
            }
            System.out.println();
        }
    }

    public int sumOfElementsInArray(int[][] array) {
        return Stream.of(array).map(Arrays::stream).mapToInt(IntStream::sum).sum();
    }

    public int[][] converterArrayFromStringToInt(String[][] array) throws MyArrayDataException {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (!Character.isDigit(array[i][j].charAt(0))) {
                    throw new MyArrayDataException(String.format("Critical ERROR. Error format items of array on col->%s and row->%s.\n", i, j));
                }
            }
        }

        return Stream.of(array).map(e -> Stream.of(e)
                .mapToInt(Integer::parseInt)
                .toArray()).toArray(int[][]::new);
    }


    private void rightTestArray(int[] size, boolean flag) {
        ArrayFabric arrayFabric = new ArrayFabric(size[0], size[1]);
        int sum = 0;
        try {
            if (flag) {
                arrayFabric.fillArrayStringDigits();
                printArray(arrayFabric.getArray());
                int[][] rightArray = converterArrayFromStringToInt(arrayFabric.getArray());
                sum = sumOfElementsInArray(rightArray);
            } else {
                arrayFabric.fillArrayRandom();
                printArray(arrayFabric.getArray());
                int[][] wrongArray = converterArrayFromStringToInt(arrayFabric.getArray());
                sum = sumOfElementsInArray(wrongArray);
            }
        } catch (MyArraySizeException ex) {
            System.out.println(ex.getMessage() + "Enter right size of array");
        } catch (MyArrayDataException ex2) {
            System.out.println(ex2.getMessage() + "Create new array with right values");
        } finally {
            System.out.printf("Sum of all elements of array = %d\n", sum);
        }
    }

    private void wrongTestArray(int[] size, boolean flag) {
        rightTestArray(size, flag);
    }
}
