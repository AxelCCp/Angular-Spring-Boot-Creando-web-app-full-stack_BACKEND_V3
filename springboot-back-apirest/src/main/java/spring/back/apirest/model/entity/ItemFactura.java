package spring.back.apirest.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="facturas_items")
public class ItemFactura implements Serializable{

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	// *
	public Double getImporte() {
		return cantidad.doubleValue() * producto.getPrecio();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer cantidad;
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})		//168 MIN 6 ... PARA EVITAR EL ERROR DE HIBERNATE DE CONTENIDO BASURA. 
	@ManyToOne(fetch = FetchType.LAZY) //MUCHOS ITEMS Y CADA ITEM CONTIENE UN SOLO TIPO DE PRODUCTO.		//, cascade = CascadeType.ALL
	private Producto producto;
	private static final long serialVersionUID = 2725110807196447241L;

	
	
}
