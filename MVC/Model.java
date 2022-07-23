package com.Task_09_08.MVC;

import com.Task_09_08.CPU.*;

public class Model {

    ProcessFlow procGenerator = new ProcessFlow(50,50);

    CPU cpu1, cpu2;

    public void runModel(){
        cpu1 = new CPU("CPU1", procGenerator, 10);
        cpu2 = new CPU("CPU2", procGenerator, 10);

        Thread  p1 = new Thread(procGenerator),
                c1 = new Thread(cpu1),
                c2 = new Thread(cpu2);

        p1.start();
        c1.start();
        c2.start();
        try {
            p1.join();
            c1.join();
            c2.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
