package program;

import commands.*;
import data.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static LinkedList<SpaceMarine> collection = new LinkedList<>();
    public static LocalDate creationDate = LocalDate.now();

    public static String collectionPath = System.getenv("labCollection");
    public static String jsonCollection = "";

    public static Queue<String> commandHistory = new LinkedList<>();

    public static boolean script = false;
    public static String scriptPath = "";
    public static Queue<String> scriptLines = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        new Fill().execute();

        Thread commandReader = new Thread(() -> new ConsoleCommandReader().start());
        commandReader.start();
    }
}