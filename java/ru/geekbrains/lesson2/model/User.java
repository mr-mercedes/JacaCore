package ru.geekbrains.lesson2.model;

public class User {
    private int userChose;
    private static final char DOT_USER = 'X';

    public int getUserChose() {
        return userChose;
    }

    public void setUserChose(int userChose) {
        this.userChose = userChose;
    }
}
