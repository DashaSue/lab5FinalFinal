package commands;

import program.*;

import java.io.IOException;

public class Execute_script extends Command1Arg {

    public Execute_script() throws IOException {
        this.help = "считать и исполнить скрипт из указанного файла";
    }

    @Override
    public void execute(Object filepath) {
        Main.scriptPath = String.valueOf(filepath);
        try {
            new ScriptCommandReader().start();
        } catch (Exception e) {
            System.out.println("Неверный формат скрипта");
        }
    }
}