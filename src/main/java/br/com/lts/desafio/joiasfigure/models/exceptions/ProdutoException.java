package br.com.lts.desafio.joiasfigure.models.exceptions;

public class ProdutoException extends Exception {

    public ProdutoException(){
        super();
    }

    public ProdutoException(String message){
        super(message);
    }

    public ProdutoException(String message, Throwable cause){
        super(message, cause);
    }

    public ProdutoException(Throwable cause){
        super(cause);
    }

}
