package com.GerenciadorDePessoas.GenrenciadorApp.Exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceprionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<StandardErro> idNotFound(IdNotFoundException ex, HttpServletRequest request){
        StandardErro erro = new StandardErro();
        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setError("resource not found");
        erro.setMessage(ex.getMessage());
        erro.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
