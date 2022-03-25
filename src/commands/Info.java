package commands;

import data.*;
import program.*;

import java.util.Iterator;
import java.io.IOException;

public class Info extends Command0Arg {

    public Info() throws IOException {
        this.help = "вывести информацию о коллекции";
    }

    @Override
    public void execute() {
        String collectionType = Main.collection.getClass().getName();
        collectionType = collectionType.substring(collectionType.lastIndexOf(".") + 1);

        String elementsType = "-";
        Iterator<SpaceMarine> iterator = Main.collection.iterator();
        if(iterator.hasNext()) {
            elementsType = iterator.next().getClass().getName();
            elementsType = elementsType.substring(elementsType.lastIndexOf(".") + 1);
        }

        System.out.println("\nИнформация о коллекции:\n" +
                "    Дата инициализации: " + Main.creationDate + "\n" +
                "    Тип: " + collectionType + "\n" +
                "    Тип элементов: " + elementsType + "\n" +
                "    Количество элементов: " + Main.collection.size() + "\n\n");
    }
}