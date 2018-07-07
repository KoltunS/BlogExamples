package com.sebastiankoltunblog.core;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class CommandHandler<CommandRequest, Response> implements Handler {

    public abstract Response handle(CommandRequest commandRequest);

    Type getCommandRequestType() {
        Type mySuperclass = this.getClass().getGenericSuperclass();
        return ((ParameterizedType) mySuperclass).getActualTypeArguments()[0];
    }

    Type getResponseType() {
        Type mySuperclass = this.getClass().getGenericSuperclass();
        return ((ParameterizedType) mySuperclass).getActualTypeArguments()[1];
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "<" +
                getCommandRequestType().getTypeName() + "," +
                getResponseType() + ">";
    }
}