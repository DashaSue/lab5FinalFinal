package program;

import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScriptCommandReader {

    public ScriptCommandReader() {}

    public void start() {
        Main.script = true;
        File scriptFile = new File(Main.scriptPath);
        Scanner scriptScanner = null;

        try {
            scriptScanner = new Scanner(scriptFile);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        if(scriptScanner != null) {
            while(scriptScanner.hasNextLine()) {
                Main.scriptLines.add(scriptScanner.nextLine());
            }
        }

        while(!Main.scriptLines.isEmpty()) {
            if(Main.scriptLines.peek().contains(" ")) {
                String[] scriptIn = Main.scriptLines.poll().split(" ");
                String command = scriptIn[0].substring(0, 1).toUpperCase() + scriptIn[0].substring(1);
                String argument = scriptIn[1];

                try {
                    Class<?> commandClass = Class.forName("commands." + command);
                    Object commandClassObject = commandClass.newInstance();
                    ((Command1Arg) Objects.requireNonNull(commandClassObject)).execute(argument);
                } catch (Exception e) {
                    System.out.println("\nКоманда не найдена");
                }
            }
            else {
                String command = Main.scriptLines.poll();
                command = command.substring(0, 1).toUpperCase() + command.substring(1);

                try {
                    Class<?> commandClass = Class.forName("commands." + command);
                    Object commandClassObject = commandClass.newInstance();
                    ((Command0Arg) Objects.requireNonNull(commandClassObject)).execute();
                } catch (Exception e) {
                    System.out.println("\nКоманда не найдена");
                }
            }
        }

        System.out.println();

        Main.scriptLines.clear();
        Main.script = false;
    }
}