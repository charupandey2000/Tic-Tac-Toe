package dev.charu.Exceptions;

public class InvalidPlayerException extends RuntimeException{

    public InvalidPlayerException(String message){
        super(message);
    }
}
