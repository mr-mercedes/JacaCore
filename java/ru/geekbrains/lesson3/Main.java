package ru.geekbrains.lesson3;


public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage(new Human[]{new WorkerPerHour("Maria", 3.3), new WorkerPerFix("Viktor",
                5000), new WorkerPerFix("Alex", 10000),
                new WorkerPerHour("Stanislav", 1.5), new WorkerPerHour("Albert", 2.0),
                new WorkerPerFix("Igor", 1000)});

        for (Human human : storage) {
            System.out.println(human);
        }
        System.out.println("---------------");

        storage.sortStorage();

        for (Human human : storage) {
            System.out.println(human);
        }
    }


}
