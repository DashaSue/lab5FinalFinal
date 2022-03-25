package commands;

import data.*;
import program.*;

import java.io.IOException;

public class Remove_any_by_health extends Command1Arg {

    public Remove_any_by_health() throws IOException {
        this.help = "удалить из коллекции один элемент, значение поля health которого эквивалентно заданному";
    }

    @Override
    public void execute(Object health) {
        int count = 0;
        while(count == 0) {
            for (SpaceMarine spaceMarine : Main.collection) {
                if (spaceMarine.getHealth() == Long.parseLong(String.valueOf(health))) {
                    Main.collection.remove(spaceMarine);
                    count++;
                }
            }
        }

        if(count == 1) System.out.println("\nЭлемент удалён");
        else System.out.println("\nНет элементов, удовлетворяющих условию");
    }
}