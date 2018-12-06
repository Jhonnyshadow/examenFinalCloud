package examenCLOUD.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import examenCLOUD.model.entities.Producto;

/**
 * Session Bean implementation class ManagerProductos
 */
@Stateless
@LocalBean
public class ManagerProductos {

	@PersistenceContext(unitName="productosDS")
	private EntityManager em;
	
    public ManagerProductos() {
        
    }
    
    
    public List<Producto> getProductos() throws Exception{
    	try {
        	TypedQuery<Producto> tabla= em.createQuery("SELECT p FROM Producto p", Producto.class);
        	List<Producto> ListaProductos= tabla.getResultList();
        	return ListaProductos;	
    	}catch(Exception e) {
    		e.printStackTrace();
    		throw new Exception("Error en la extraida de datos");
    	}
    }
    public Producto getProducto(String codigo) throws Exception{
    	try {
        	Producto producto= em.find(Producto.class, codigo);
        	return producto;	
    	}catch(Exception e) {
    		throw new Exception("Error en la extraida de datos");
    	}
    }
    
    public boolean removeProducto(String codigo) throws Exception{
    	try {
    		Producto p= this.getProducto(codigo);
    		em.getTransaction().begin();
        	em.remove(p);
        	em.getTransaction().commit();
        	return true;
    	}catch(Exception e) {
    		throw new Exception("Error en la eliminacion de datos");
    	}
    }
    
    public boolean mergeProducto(String codigo, int cantidad) throws Exception{
    	try {
    		Producto p= this.getProducto(codigo);
    		p.setCantidad(cantidad);
    		em.getTransaction().begin();
        	em.merge(p);
        	em.getTransaction().commit();
        	return true;
    	}catch(Exception e) {
    		throw new Exception("Error en la actualizacion de datos");
    	}
    }
    public boolean mergeProducto(String codigo, double precio) throws Exception{
    	try {
    		Producto p= this.getProducto(codigo);
    		p.setPrecio(precio);
    		em.getTransaction().begin();
        	em.merge(p);
        	em.getTransaction().commit();
        	return true;
    	}catch(Exception e) {
    		throw new Exception("Error en la actualizacion de datos");
    	}
    }
    public boolean persistProducto(String codigo,int cantidad, String descripcion, double precio) throws Exception{
    	try {
    		Producto p=new Producto(codigo, cantidad, descripcion, precio);
    		em.getTransaction().begin();
        	em.persist(p);
        	em.getTransaction().commit();
        	return true;
    	}catch(Exception e) {
    		throw new Exception("Error en el insertado de datos");
    	}
    }

    

}
