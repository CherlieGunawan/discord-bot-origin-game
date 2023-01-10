package com.cherlie.game.Global;

public class GlobalFunction {
    public static boolean isOfException(Throwable exception, String exceptionName) {
        if(exception.getCause() == null)
            return false;
        else if(exception.getCause().getClass().getSimpleName().equals(exceptionName))
            return true;
        else {
            return isOfException(exception.getCause(), exceptionName);
        }
    }
}
