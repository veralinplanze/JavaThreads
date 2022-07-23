package com.Task_09_08.MVC;

public class Controller {

    private Model model;

    public Controller(Model model){ this.model = model; }

    public void processUser() {

        model.runModel();

        int first = model.cpu1.getWorkedProcesses();
        int second = model.cpu2.getWorkedProcesses();

        Viewer.printMessage(model.cpu1.getName() + Viewer.PROCESSED_REQUESTS + first);
        Viewer.printMessage(model.cpu2.getName() + Viewer.PROCESSED_REQUESTS + second);

        Viewer.printMessage("Процент уничтоженных процессов: " +
                100*(1f - (float)(first + second) / model.procGenerator.getProcessNumber()));
    }
}
