package com.Task_09_08.MVC;

public class Main {
    public static void main(String[] args) {

        Model model = new Model();
        Controller controller = new Controller(model);

        controller.processUser();
    }
}
