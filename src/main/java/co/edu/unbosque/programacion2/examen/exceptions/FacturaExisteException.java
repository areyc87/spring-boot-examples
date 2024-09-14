package co.edu.unbosque.programacion2.examen.exceptions;

public class FacturaExisteException extends RuntimeException{
	public FacturaExisteException(String mensaje) {
		super(mensaje);
	}
}
