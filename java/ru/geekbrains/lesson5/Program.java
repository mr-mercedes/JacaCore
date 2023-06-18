package ru.geekbrains.lesson5;

import java.io.*;

public class Program {
    public static void main(String[] args) {
        BackupDirectory backupDirectory = new BackupDirectory("./backup");
        try {
            backupDirectory.copyDir("src");
        } catch (IOException | RuntimeException exception){
            System.out.println(exception.getMessage());
        }

        Tree tree = new Tree();
        tree.print(new File("src"), "", true);

    }
}
