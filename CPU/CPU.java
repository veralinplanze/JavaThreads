package com.Task_09_08.CPU;

import com.Task_09_08.MVC.Viewer;

public class CPU implements Runnable {

    private ProcessFlow flow;
    private int operatingTime;
    private String name;
    private int servicedProcesses;

    public CPU(String name, ProcessFlow flow, int operatingTime){
        this.name = name;
        this.flow = flow;
        this.operatingTime = operatingTime;
    }

    public CPU(String name, ProcessFlow flow){
        this.name = name;
        this.flow = flow;
        this.operatingTime = 500;
    }

    public String getName() {
        return name;
    }

    public int getWorkedProcesses() { return servicedProcesses; }

    public int generateTime(int min, int max){
     return (int) (min + Math.random()*(max - min + 1)) * 100;
    }


    public void operateProcessFlow() {
        ProcessBuffer buffer = flow.getBuffer();
        while (!flow.isCreationDone()) {

            if(buffer.isEmpty())
                waiting();
            else
                operating(buffer);
        }
        Viewer.printMessage(Viewer.STOP_CPU + getName());
    }

    public void operating(ProcessBuffer buffer) {
        try {
            synchronized (this){
                Viewer.printMessage(getName() + "\t" + Viewer.HANDLING_PROCESS +
                        operatingTime + "\t" + buffer.removeFromBuffer());
            }
            servicedProcesses++;
            Thread.sleep(operatingTime);
        } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void waiting(){
        try{
            //Viewer.printMessage(getName() + Viewer.CPU_WAITING);
            Thread.sleep(10);
        }
        catch(InterruptedException e){

        }
    }



    @Override
    public void run() {
        operateProcessFlow();
    }

    @Override
    public String toString() {
        return "CPU{" +
                "name='" + name + '\'' +
                '}';
    }
}
