package ru.geekbrains.lesson2.controller;

import ru.geekbrains.lesson2.service.impl.BotServiceImpl;
import ru.geekbrains.lesson2.service.impl.TableServiceImpl;
import ru.geekbrains.lesson2.service.impl.UserServiceImpl;

public class GameController {

    private final TableServiceImpl tableService = new TableServiceImpl();
    private final UserServiceImpl userService = new UserServiceImpl();
    private final BotServiceImpl botService = new BotServiceImpl();



    public void startGame() {
        initialize();
        while (true){
            userService.userTurn();
            tableService.printTable();
            tableService.checkWin('X');
            if (tableService.isGameOver()) break;
            botService.botTurn();
            tableService.printTable();
            tableService.checkWin('O');
            if (tableService.isGameOver()) break;
        }
    }

    private void initialize(){
        tableService.createBoard();
        tableService.printTable();
    }

}
