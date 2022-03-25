package program;

import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;

public abstract class Command {
    protected File collectionFile = new File(Main.collectionPath);
    protected InputStreamReader fileReader = new InputStreamReader(new FileInputStream(collectionFile), StandardCharsets.UTF_8);
    protected FileWriter fileWriter = new FileWriter(Main.collectionPath, true);
    protected Gson gson = new Gson();

    protected String help;

    public Command() throws IOException {
        this.help = "";
    }

    public String getHelp() {
        return help;
    }
}