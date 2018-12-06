package examenCLOUD.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Productos" database table.
 * 
 */
@Entity
@Table(name="\"Productos\"")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"Codigo\"")
	private String codigo;

	private int cantidad;

	private String descripcion;

	private double precio;

	public Producto() {
	}
	
	public Producto(String codigo, int cantidad, String descripcion, double precio) {
		super();
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.precio = precio;
	}




	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}