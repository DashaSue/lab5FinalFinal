package commands;

import program.*;

import java.io.FileWriter;
import java.io.IOException;

public class Save extends Command0Arg {

    protected FileWriter fileWriter = new FileWriter(Main.collectionPath, false);

    public Save() throws IOException {
        this.help = "сохранить коллекцию в файл";
    }

    @Override
    public void execute() throws IOException {
        fileWriter.write(gson.toJson(Main.collection));
        fileWriter.flush();
        System.out.println("\nКоллекция успешно сохранена");
    }
}