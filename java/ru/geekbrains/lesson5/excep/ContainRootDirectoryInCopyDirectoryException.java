package ru.geekbrains.lesson5.excep;

public class ContainRootDirectoryInCopyDirectoryException extends RuntimeException{
    public ContainRootDirectoryInCopyDirectoryException(String message) {
        super(message);
    }
}
