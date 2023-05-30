package ru.geekbrains.lesson2;

import ru.geekbrains.lesson2.controller.GameController;

public class Game {
    static GameController gameController = new GameController();

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        try {
            gameController.startGame();
        } catch (RuntimeException ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
    }
}
