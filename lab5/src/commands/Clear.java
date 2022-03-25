package commands;

import program.*;

import java.io.FileWriter;
import java.io.IOException;

public class Clear extends Command0Arg {

    protected FileWriter fileWriter = new FileWriter(Main.collectionPath, false);

    public Clear() throws IOException {
        this.help = "очистить коллекцию";
    }

    @Override
    public void execute() {
        Main.collection.clear();
        System.out.println("\nКоллекция очищена");
    }
}