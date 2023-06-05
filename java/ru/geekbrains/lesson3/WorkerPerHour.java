package ru.geekbrains.lesson3;

public class WorkerPerHour extends Human {

    public WorkerPerHour(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateSalary() {
        return 20.8 * 8 * getSalary();
    }


}
