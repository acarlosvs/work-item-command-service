package br.com.tasknow.workitemcommandservice.handler;

import br.com.tasknow.workitemcommandservice.commands.Command;

public interface CommandHandler<C extends Command> {
    void handle(C command);
}
