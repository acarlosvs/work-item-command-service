package br.com.tasknow.workitemcommandservice.bus;

import br.com.tasknow.workitemcommandservice.commands.Command;
import br.com.tasknow.workitemcommandservice.handler.CommandHandler;
import ch.qos.logback.core.util.StringUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CommandBus {

    private final ApplicationContext context;

    public CommandBus(ApplicationContext context) {
        this.context = context;
    }

    public <C extends Command> void dispatch(C command) {
        String handlerName = StringUtil.lowercaseFirstLetter(command.getClass().getSimpleName() + "Handler");
        CommandHandler handler = (CommandHandler) context.getBean(handlerName);

        handler.handle(command);
    }
}
