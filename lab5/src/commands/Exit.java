package commands;

import program.*;

import java.io.IOException;

public class Exit extends Command0Arg {

    public Exit() throws IOException {
        this.help = "завершить программу без сохранения";
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}