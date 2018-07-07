package com.sebastiankoltunblog.core;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class CommandRequest<Response> implements Command {
    Type getResponseType() {
        Type mySuperclass = this.getClass().getGenericSuperclass();
        return ((ParameterizedType) mySuperclass).getActualTypeArguments()[0];
    }
}
