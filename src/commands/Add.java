package commands;

import data.*;
import program.*;

import java.util.Collections;
import java.io.IOException;

public class Add extends Command0Arg {

    public Add() throws IOException {
        this.help = "добавить новый элемент в коллекцию";
    }

    @Override
    public void execute() {
        Main.collection.add(SpaceMarine.create());
        Main.collection.sort(new SpaceMarine.healthComparator());
        Main.collection.sort(Collections.reverseOrder());
        System.out.println("\nЭлемент успешно добавлен");
    }
}