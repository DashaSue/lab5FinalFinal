package commands;

import data.*;
import program.*;

import java.io.IOException;

public class Filter_starts_with_achievements extends Command1Arg {

    public Filter_starts_with_achievements() throws IOException {
        this.help = "вывести элементы, значение поля acievements которых начинается с заданной подстроки";
    }

    @Override
    public void execute(Object achievements) {
        for(SpaceMarine spaceMarine : Main.collection) {
            if(spaceMarine.getAchievements().startsWith(String.valueOf(achievements))) {
                System.out.println();
                System.out.println(spaceMarine);
            }
        }
    }
}