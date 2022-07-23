package com.Task_09_08.CPU;

public class Process {

    private int time;    // время перед генерацией нового процесса
    private int name;    // имя/номер процесса

    // static incrementing int (нет локальной копии в потоках)
    static volatile int counter;

    public Process(int min, int max) {
        this.time = generateRandomNumber(min, max);
        name = counter++;
    }
    public Process(int min, int max, int name) {
        this.time = generateRandomNumber(min, max);
        this.name = name;
    }

    public int generateRandomNumber(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1)) * 10;
    }

    public int getName() {
        return name;
    }
    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Process{" +
                "name=" + name +
                '}';
    }

}
