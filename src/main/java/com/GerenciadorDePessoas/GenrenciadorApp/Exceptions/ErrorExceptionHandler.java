package com.GerenciadorDePessoas.GenrenciadorApp.Exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<StandardErro> idNotFound(IdNotFoundException ex, HttpServletRequest request){
        StandardErro erro = new StandardErro();
        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setError("Requisição não encontrada");
        erro.setMessage(ex.getMessage());
        erro.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardErro> methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request){
        StandardErro erro = new StandardErro();
        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.BAD_REQUEST.value());
        erro.setError("Argumentos invalidos");
        erro.setMessage("Verifique os campos inseridos");
        erro.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
