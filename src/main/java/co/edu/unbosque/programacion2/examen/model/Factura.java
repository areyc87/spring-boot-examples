package co.edu.unbosque.programacion2.examen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Factura")
public class Factura {
	@Id
	@Column(name="id_factura")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFactura;
	@Column(name="cliente")
	private String nombreCliente;
	@Column(name="item")
	private String producto;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="valor_unitario")
	private double valorUnidad;
	@Column(name="valor_total_producto")
	private double totalProductos;
	
	public Factura() {}				

	public Factura(int idFactura, String nombreCliente, String producto, int cantidad, double valorUnidad,
			double totalProductos) {
		super();
		this.idFactura = idFactura;
		this.nombreCliente = nombreCliente;
		this.producto = producto;
		this.cantidad = cantidad;
		this.valorUnidad = valorUnidad;
		this.totalProductos = totalProductos;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}	

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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
