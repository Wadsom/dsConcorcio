package com.WpCorp.DsConcorcio.Config.ControllerHandler;

import com.WpCorp.DsConcorcio.Service.Exception.MotorPlateAlreadyExistsException;
import com.WpCorp.DsConcorcio.Service.Exception.StandardException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice

public class ControllerHandlerException {

    @ExceptionHandler(MotorPlateAlreadyExistsException.class)
    public ResponseEntity<StandardException> plateAlreadyExistsException
            (HttpServletRequest req, MotorPlateAlreadyExistsException ex) {
        StandardException std = StandardException.builder()
                .message(ex.getMessage()).path(req.getRequestURI()).status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(std);
    }


}
