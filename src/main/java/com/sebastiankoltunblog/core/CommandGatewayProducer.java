package com.sebastiankoltunblog.core;

import org.apache.log4j.Logger;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.Iterator;

public class CommandGatewayProducer {
    private static final Logger log = Logger.getLogger(CommandGatewayProducer.class);
    @Inject
    private Instance<Command> commands;
    @Inject
    private Instance<Handler> handlers;

    @Produces
    @Gateway
    public CommandGateway produce() {
        CommandGateway gateway = new CommandGateway();
        commands.forEach(command -> addToRegistry(gateway, command));
        return gateway;
    }

    private void addToRegistry(CommandGateway gateway, Command command) {
        CommandHandler handler = findHandler(command);
        gateway.registerHandler(((CommandRequest) command).getClass(), handler);
    }

    private CommandHandler findHandler(Command command) {
        Iterator<Handler> iterator = handlers.iterator();
        while (iterator.hasNext()) {
            CommandHandler handler = (CommandHandler) iterator.next();
            if (matches(handler, command)) {
                log.debug(handler);
                return handler;
            }
        }
        throw new IllegalStateException("Could not find handler for " + command.getClass().getName());
    }

    private boolean matches(CommandHandler handler, Command command) {
        return handler.getCommandRequestType().equals(command.getClass()) &&
                handler.getResponseType().equals(((CommandRequest) command).getResponseType());
    }

}
