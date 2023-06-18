package ru.geekbrains.lesson5.excep;

import java.io.IOException;

public class CreateDirectoryException extends IOException {
    public CreateDirectoryException(String message) {
        super(message);
    }
}
