package ru.geekbrains.lesson2.service.impl;

import ru.geekbrains.lesson2.service.BotService;

import java.util.Random;

public class BotServiceImpl implements BotService {

    TableServiceImpl tableService = new TableServiceImpl();
    Random rd = new Random();
    @Override
    public void botTurn() {
        int x;
        do {
            System.out.print("Ход компьютера!");
            x = rd.nextInt(tableService.getMaxSection());
        } while (!tableService.isCellValid(x));
        tableService.setSymbol(TableServiceImpl.DOT_BOT, x);
    }
}
