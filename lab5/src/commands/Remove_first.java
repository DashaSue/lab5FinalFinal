package commands;

import program.*;

import java.io.IOException;

public class Remove_first extends Command0Arg {

    public Remove_first() throws IOException {
        this.help = "удалить первый элемент из коллекции";
    }

    @Override
    public void execute() {
        Main.collection.remove(0);
        System.out.println("\nЭлемент был удалён");
    }
}