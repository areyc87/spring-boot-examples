package co.edu.unbosque.programacion2.examen.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.edu.unbosque.programacion2.examen.exceptions.FacturaExisteException;
import co.edu.unbosque.programacion2.examen.exceptions.FacturaNoExisteException;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value=FacturaExisteException.class)
	protected ResponseEntity<Object> handleFacturaExisteException(RuntimeException ex,WebRequest request){
		String body = ex.getMessage();
		return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.ALREADY_REPORTED, request);
	}
	
	@ExceptionHandler(value=FacturaNoExisteException.class)
	protected ResponseEntity<Object> handleFacturaNoExisteException(RuntimeException ex,WebRequest request){
		String body = ex.getMessage();
		return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> constraintViolationException(RuntimeException ex,WebRequest request) {
		String body = ex.getMessage();
		return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
