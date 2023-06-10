package ru.geekbrains.lesson4;

import ru.geekbrains.lesson4.util.ArrayUtil;

import java.io.IOException;

public class Main {
    private static final ArrayUtil ARRAY_UTIL = new ArrayUtil();

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        boolean flag = true;
        while (flag) {
            try {
                flag = ARRAY_UTIL.menu();
            } catch (IOException ex) {
                System.out.println(ex.getMessage() + "\nFatal error with data reading");
            }
        }
    }
}
