package com.Task_09_08.CPU;

import com.Task_09_08.MVC.Viewer;

public class ProcessBuffer {

    private volatile Process current;

    public ProcessBuffer(){
        current = null;
    }

    // Созданный процесс помещается в буфер
    public synchronized void setNewProcess(Process process){
        if (current != null )
            Viewer.printMessage(Viewer.PROCESS_DESTROYED + current.getName());
        current = process;
    }

    // Процесс из буфера взят на обработку
    public synchronized Process removeFromBuffer() {
        Process removed = current;
        current = null;
        return removed;
    }

    public boolean isEmpty(){
        return current == null;
    }

    @Override
    public String toString() { return current.toString(); }

}
