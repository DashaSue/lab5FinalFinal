package program;

import java.util.Objects;
import java.util.Scanner;

public class ConsoleCommandReader {

    public ConsoleCommandReader() {}

    public void start() {
        Main.script = false;
        Scanner consoleScanner = new Scanner(System.in);

        while(true) {
            System.out.println("\nДля просмотра доступных команд введите help");
            System.out.println("Введите команду:");

            String consoleLine = consoleScanner.nextLine();

            if(consoleLine.isEmpty()) {
                continue;
            }
            else {
                if(consoleLine.contains(" ")) {
                    String[] consoleIn = consoleLine.split(" ");
                    String command = consoleIn[0].substring(0, 1).toUpperCase() + consoleIn[0].substring(1);
                    String argument = consoleIn[1];

                    try {
                        Class<?> commandClass = Class.forName("commands." + command);
                        Object commandClassObject = commandClass.newInstance();
                        ((Command1Arg) Objects.requireNonNull(commandClassObject)).execute(argument);
                    } catch (Exception e) {
                        System.out.println("\nКоманда не найдена");
                        continue;
                    }

                    if(Main.commandHistory.size() == 9) {
                        Main.commandHistory.remove();
                        Main.commandHistory.add(command);
                    }
                    else {
                        Main.commandHistory.add(command);
                    }
                }
                else {
                    String command = consoleLine.substring(0, 1).toUpperCase() + consoleLine.substring(1);

                    try {
                        Class<?> commandClass = Class.forName("commands." + command);
                        Object commandClassObject = commandClass.newInstance();
                        ((Command0Arg) commandClassObject).execute();
                    } catch (Exception e) {
                        System.out.println("\nКоманда не найдена");
                        continue;
                    }

                    if(Main.commandHistory.size() == 9) {
                        Main.commandHistory.remove();
                        Main.commandHistory.add(command);
                    }
                    else {
                        Main.commandHistory.add(command);
                    }
                }
            }

            System.out.println();
        }
    }
}