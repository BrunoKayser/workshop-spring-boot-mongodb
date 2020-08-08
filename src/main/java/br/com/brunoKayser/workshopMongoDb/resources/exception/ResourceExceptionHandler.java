package br.com.brunoKayser.workshopMongoDb.resources.exception;


import br.com.brunoKayser.workshopMongoDb.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler (ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest httpServletRequest){

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError error = new StandartError(System.currentTimeMillis(), status.value(),
                "Não encontrado", e.getMessage(), httpServletRequest.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }
}
