package com.GerenciadorDePessoas.GenrenciadorApp.Exceptions;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(String msg){
        super(msg);
    }
}
