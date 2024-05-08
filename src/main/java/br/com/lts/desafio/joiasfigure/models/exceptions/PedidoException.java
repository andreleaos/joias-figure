package br.com.lts.desafio.joiasfigure.models.exceptions;

public class PedidoException extends Exception {

    public PedidoException(){
        super();
    }

    public PedidoException(String message){
        super(message);
    }

    public PedidoException(String message, Throwable cause){
        super(message, cause);
    }

    public PedidoException(Throwable cause){
        super(cause);
    }

}
