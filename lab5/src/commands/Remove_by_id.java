package commands;

import data.*;
import program.*;

import java.io.IOException;

public class Remove_by_id extends Command1Arg {

    public Remove_by_id() throws IOException {
        this.help = "удалить элемент из коллекции по его id";
    }

    @Override
    public void execute(Object id) {
        int count = 0;
        for(SpaceMarine spaceMarine : Main.collection) {
            if(spaceMarine.getId() == Long.parseLong(String.valueOf(id))) {
                Main.collection.remove(spaceMarine);
                count++;
            }
        }
    }
}