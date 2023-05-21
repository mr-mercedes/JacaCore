package ru.geekbrains.lesson1.sample;

import ru.geekbrains.lesson1.regular.Decorator;
import ru.geekbrains.lesson1.regular.Operations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        int a = 0;
        int b = 0;

        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("Введите первое число -> ");
            a = Integer.parseInt(scanner.next());
            System.out.print("Введите второе число -> ");
            b = Integer.parseInt(scanner.next());

            Operations operations = new Operations();
            Decorator decorator = new Decorator();

            System.out.printf("Сумма чисел %d и %d = %d\n", a, b, operations.add(a, b));
            decorator.decorate(operations.add(a, b));
            System.out.printf("Разница чисел %d и %d = %d\n", a, b, operations.sub(a, b));
            decorator.decorate(operations.sub(a, b));
            System.out.printf("Произведение чисел %d и %d = %d\n", a, b, operations.mul(a, b));
            decorator.decorate(operations.mul(a, b));
            System.out.printf("Частное чисел %d и %d = %d\n", a, b, operations.div(a, b));
            decorator.decorate(operations.div(a, b));
        }
    }
}
