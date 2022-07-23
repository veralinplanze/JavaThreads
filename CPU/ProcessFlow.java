package com.Task_09_08.CPU;

import com.Task_09_08.MVC.Viewer;

public class ProcessFlow implements Runnable {

    private boolean creationDone;

    // буфер для созданного процесса
    public ProcessBuffer buffer = new ProcessBuffer();

    // Запланированное количество процессов
    private final int processNumber;

    // Конструктор
    public ProcessFlow(int min, int max){
        processNumber = generateRandomNumber(min, max);
    }

    public int getProcessNumber() {
        return processNumber;
    }

    public int generateRandomNumber(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }

    @Override
    public void run() {
        Viewer.printMessage(Viewer.GENERATING_THREAD + processNumber);
        int rand;
        Process process = null;
        for(int i = 0; i < processNumber; i++){
            rand = generateRandomNumber(1, 10);
            process = new Process(rand, 2 * rand);
            Viewer.printMessage(Viewer.PROCESS_CREATED + process);
            synchronized (this) { buffer.setNewProcess(process); }
            try {
                int sleepTime = process.getTime();
                Viewer.printMessage(Viewer.SLEEP_BETWEEN_PROCESSES + sleepTime);
                Thread.sleep(sleepTime);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        // Информируем все потоки о том, что генерирующий поток закончил создание процессов

        creationDone = true;
        synchronized (this) {
            notifyAll();
        }
        Viewer.printMessage(Viewer.STOP_GENERATING);
    }

    public ProcessBuffer getBuffer() {
        return buffer;
    }

    public boolean isCreationDone() {
        return creationDone;
    }
}
