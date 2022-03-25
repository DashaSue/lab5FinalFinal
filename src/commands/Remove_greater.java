package commands;

import program.*;
import data.*;

import java.io.IOException;

public class Remove_greater extends Command0Arg {

    public Remove_greater() throws IOException {
        this.help = "удалить из коллекции все элементы, превышающие заданный";
    }

    @Override
    public void execute() {
        int count = 0;
        SpaceMarine sm2 = SpaceMarine.create();
        for(SpaceMarine sm1 : Main.collection) {
            if(sm1.compareTo(sm2) > 0) {
                Main.collection.remove(sm1);
                count++;
            }
        }
        System.out.println("\nПодходящие элементы (" + count + ") были удалены");
    }
}