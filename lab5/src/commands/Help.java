package commands;

import program.*;

import java.util.Objects;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;

public class Help extends Command0Arg {

    public Help() throws IOException {
        help = "вывести справку по доступным командам";
    }

    @Override
    public void execute() throws IOException {
        ArrayList<String[]> help_out = new ArrayList<>();
        File directory = new File("src/commands");
        String[] commandClasses = directory.list();

        for (String filename : Objects.requireNonNull(commandClasses)) {
            if(filename.endsWith(".java")) {

                String[] com_help = new String[2];
                com_help[0] = filename.replace(".java", "").substring(0, 1).toLowerCase()
                        + filename.replace(".java", "").substring(1);

                try {
                    Class<?> cls = Class.forName("commands." + filename.replace(".java", ""));
                    Object commandClassObject = Objects.requireNonNull(cls).newInstance();
                    com_help[1] = ((Command) (Objects.requireNonNull(commandClassObject))).getHelp();
                } catch (Exception ignored) {}

                help_out.add(com_help);
            }
        }

        System.out.println("\nДоступные команды:");
        for(String[] comhelp : help_out) {
            System.out.println("   " + comhelp[0] + " : " + comhelp[1]);
        }
        System.out.println();

        try {
            fileWriter.write(Main.jsonCollection);
            fileWriter.flush();
        } catch (IOException ignored) {}
    }
}