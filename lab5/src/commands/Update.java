package commands;

import data.*;
import program.*;

import java.io.IOException;

public class Update extends Command1Arg {

    public Update() throws IOException {
        this.help = "обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public void execute(Object id) throws IOException {
        new Remove_by_id().execute(Long.parseLong(String.valueOf(id)));
        Main.collection.add(SpaceMarine.create());
        System.out.println("\nЭлемент (id: " + Long.parseLong(String.valueOf(id)) + ") успешно обновлён");
    }
}