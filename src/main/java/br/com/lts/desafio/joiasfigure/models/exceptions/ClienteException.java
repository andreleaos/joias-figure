package br.com.lts.desafio.joiasfigure.models.exceptions;

public class ClienteException extends Exception {

    public ClienteException(){
        super();
    }

    public ClienteException(String message){
        super(message);
    }

    public ClienteException(String message, Throwable cause){
        super(message, cause);
    }

    public ClienteException(Throwable cause){
        super(cause);
    }

}
