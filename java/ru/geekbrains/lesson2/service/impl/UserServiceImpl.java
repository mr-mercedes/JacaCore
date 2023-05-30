package ru.geekbrains.lesson2.service.impl;

import ru.geekbrains.lesson2.service.UserService;


import java.util.Scanner;

public class UserServiceImpl implements UserService {

    private final Scanner SCANNER = new Scanner(System.in);
    TableServiceImpl tableService = new TableServiceImpl();
    @Override
    public void userTurn() {
        int x;
        do {
            System.out.print("Ваш ход! Введите номер клетки ->");
            x = Integer.parseInt(SCANNER.next());
        } while (!tableService.isCellValid(x));
        tableService.setSymbol(TableServiceImpl.DOT_PLAYER, x);
    }
}
