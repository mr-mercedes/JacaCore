package ru.geekbrains.lesson1.regular;

public class Operations {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        if (a == 0 || b == 0) throw new ArithmeticException();
        return a / b;

    }
}
