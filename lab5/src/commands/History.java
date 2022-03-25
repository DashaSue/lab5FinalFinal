package commands;

import data.*;
import program.*;

import java.io.IOException;

public class History extends Command0Arg {

    public History() throws IOException {
        this.help = "вывести последние 9 команд";
    }

    @Override
    public void execute() {
        System.out.println("Последние 9 команд:");
        for(SpaceMarine spaceMarine : Main.collection) {
            for(String h : Main.commandHistory) {
                System.out.println("   " + h);
            }
        }
    }
}