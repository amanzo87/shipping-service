package it.interno.shipping.exception;

import it.interno.shipping.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ShippingExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleGeneralException(Exception ex) {
        ResponseDto response = new ResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                null, ex.getMessage(), null);

        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(ShippingFallbackException.class)
    public ResponseEntity<ResponseDto> handleShippingFallbackException(ShippingFallbackException ex) {
        ResponseDto response = new ResponseDto(
                HttpStatus.BAD_REQUEST.value(),null, ex.getMessage(), null);

        return ResponseEntity.ok(response);
    }

}
