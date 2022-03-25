package commands;

import data.*;
import program.*;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;

public class Fill extends Command0Arg {

    public Fill() throws IOException {
        help = "заполнить коллекцию значениями из файла";
    }

    @Override
    public void execute() throws IOException {
        BufferedReader fileBuffer = new BufferedReader(fileReader);
        Main.jsonCollection = String.valueOf(fileBuffer.readLine());
        Type dataType = new TypeToken<LinkedList<SpaceMarine>>() {}.getType();
        Main.collection = gson.fromJson(Main.jsonCollection, dataType);
    }
}