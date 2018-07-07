package com.sebastiankoltunblog.core;

import javax.ejb.Stateless;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class CommandGateway {
    private Map<Class<? extends CommandRequest>, CommandHandler> registry;

    CommandGateway() {
        registry = new HashMap<>();
    }

    public <R> R execute(CommandRequest<R> command) {
        CommandHandler<CommandRequest<R>, R> handler = getHandler(command);
        return handler.handle(command);
    }

    void registerHandler(Class<? extends CommandRequest> commandClass, CommandHandler handler) {
        registry.put(commandClass, handler);
    }

    private <R> CommandHandler<CommandRequest<R>, R> getHandler(CommandRequest<R> command) {
        CommandHandler handler = registry.get(command.getClass());
        validateConfiguration(command, handler);
        return handler;
    }

    private boolean validateConfiguration(CommandRequest request, CommandHandler handler) {
        Type responseType = request.getResponseType();
        boolean valid = handler != null
                && handler.getCommandRequestType().equals(request.getClass())
                && responseType.equals(handler.getResponseType());
        if (!valid) {
            throw new IllegalArgumentException(request.getClass().getName() + " has no matching handler");
        }
        return true;
    }
}
