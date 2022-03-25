package commands;

import program.*;

import java.io.IOException;

public class Print_ascending extends Command0Arg {

    public Print_ascending() throws IOException {
        this.help = "вывести элементы коллекции в порядке возрастания";
    }

    @Override
    public void execute() {
        for(int i = Main.collection.size() - 1; i >= 0; i--) {
            System.out.println(Main.collection.get(i));
        }
    }
}