package co.edu.unbosque.programacion2.examen.model;

import java.io.Serializable;

public class FacturaDTO implements Serializable {
	private int idFactura;
	private String nombreCliente;
	private String producto;
	private int cantidad;
	private double valorUnidad;
	private double totalProductos;
	
	public FacturaDTO() {}

	public FacturaDTO(int idFactura, String nombreCliente, String producto, int cantidad, double valorUnidad,
			double totalProductos) {
		this.idFactura = idFactura;
		this.nombreCliente = nombreCliente;
		this.producto = producto;
		this.cantidad = cantidad;
		this.valorUnidad = valorUnidad;
		this.totalProductos = totalProductos;
	}
	
	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getValorUnidad() {
		return valorUnidad;
	}

	public void setValorUnidad(double valorUnidad) {
		this.valorUnidad = valorUnidad;
	}

	public double getTotalProductos() {
		return totalProductos;
	}

	public void setTotalProductos(double totalProductos) {
		this.totalProductos = totalProductos;
	}	
}
