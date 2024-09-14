package co.edu.unbosque.programacion2.examen.exceptions;

public class FacturaNoExisteException extends RuntimeException{
	public FacturaNoExisteException(String mensaje) {
		super(mensaje);
	}
}
