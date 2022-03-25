package commands;

import data.*;
import program.*;

import java.io.IOException;

public class Show extends Command0Arg {

    public Show() throws IOException {
        this.help = "вывести все элементы коллекции в строковом представлении";
    }

    @Override
    public void execute() {
        for(SpaceMarine spaceMarine : Main.collection) {
            System.out.println();
            System.out.println(spaceMarine.toString());
        }
    }
}