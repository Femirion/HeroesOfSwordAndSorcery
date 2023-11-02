package ru.infernia.exception;

public class GameException extends RuntimeException{
    public GameException(String msg) {
        super(msg);
    }

    public GameException(String msg, Exception ex) {
        super(msg, ex);
    }
}
