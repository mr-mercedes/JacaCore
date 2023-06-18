package ru.geekbrains.lesson5;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SimpleTicTacToe {

    public void writeDesk() {
        try (OutputStream os = new BufferedOutputStream(new FileOutputStream("ticTacToeBoard.txt"))) {
            byte AByte = 123;
            for (int i = 0; i < 3; i++) {
                os.write(AByte);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
