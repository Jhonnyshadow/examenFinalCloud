package examenCLOUD.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import examenCLOUD.model.ManagerProductos;
import examenCLOUD.model.entities.Producto;
import examenCLOUD.view.util.JSFUtil;

@ManagedBean
@SessionScoped
public class Controller {

	private String codigo;
	private String descripcion;
	private int cantidad;
	private double precio;
	private List<Producto> listadoproductos;
	private Producto producto;
	@EJB
	private ManagerProductos em;
	
	public String actionCargarProductos() {
		try {
			listadoproductos= em.getProductos();
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
		}
		return "";
	}
	
	
	
	
	
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<Producto> getListadoproductos() {
		return listadoproductos;
	}

	public void setListadoproductos(List<Producto> listadoproductos) {
		this.listadoproductos = listadoproductos;
	}
	
	
}
