package ru.geekbrains.lesson3;


import java.util.Objects;

public abstract class Human implements Worker, Comparable<Human>{

    private String name;
    private double salary;

    public Human(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Double.compare(human.salary, salary) == 0 && Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    @Override
    public int compareTo(Human o) {
        if (this.equals(o)) {
            return 0;
        } else {
            if (this.getSalary() == o.getSalary()) {
                return this.getName().compareTo(o.getName());
            }
            return this.getSalary() > o.getSalary() ? 1 : -1;

        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
