package ru.geekbrains.lesson3;

public class WorkerPerFix extends Human {

    public WorkerPerFix(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateSalary() {
        return getSalary();
    }
}
