package ru.geekbrains.lesson5.excep;

import java.io.IOException;

public class CopyFileException extends IOException {
    public CopyFileException(String message) {
        super(message);
    }
}
