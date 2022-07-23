package com.Task_09_08.MVC;

public class Viewer {
    public static final String GENERATING_THREAD = "Генерирующий поток, запланировано создать процессов: ";
    public static final String SLEEP_BETWEEN_PROCESSES = "[WAITING] Ожидание генерации нового процесса ";
    public static final String PROCESS_CREATED = "[CREATED]Создан новый процесс ";
    public static final String PROCESS_DESTROYED = "[DESTROYED]Процессор занят. Уничтожается процесс ";
    public static final String CPU_WAITING = " ожидает, пока какой-либо процесс поступит на обработку.";
    public static final String HANDLING_PROCESS = "Процесс обрабатывается CPU в течение ";
    public static final String PROCESSED_REQUESTS = "Количество обработанных запросов составляет ";
    public static final String STOP_GENERATING = "Конец потока процессов.";
    public static final String STOP_CPU = "Конец работы процессора ";

    public static void printMessage(String msg) {
        System.out.println(msg);
    }

}
