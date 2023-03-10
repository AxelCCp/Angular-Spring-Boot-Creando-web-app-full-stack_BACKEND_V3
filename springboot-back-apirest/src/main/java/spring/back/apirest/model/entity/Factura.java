package spring.back.apirest.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="facturas")
public class Factura implements Serializable {
	
	public Factura() {
		this.items = new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	//PARA ASIGNAR LA FECHA DE LA FACTURA CUANDO ESTA SE CREA
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
	public List<ItemFactura> getItems() {
		return items;
	}
	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
	
	
	public Double getTotal() {
			Double total = 0.00;
			for(ItemFactura item : items) {
				total += item.getImporte();
			}
			return total;
	}

	private static final long serialVersionUID = 5506635831638202622L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	private String observacion;
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;                                                         //allowSetters : ESTO ES PARA Q NO D?? ERROR DE RECURSIVIDAD CUANDO SE CREA UNA FACTURA Y LUEGO SE ACTUALIZA EL CLIENTE.                                 
	@JsonIgnoreProperties(value={"facturas", "hibernateLazyInitializer", "handler"}, allowSetters=true) //POR CADA CLIENTE SE IGNORA LA RELACI??N INVERSA QUE SER??A "FACTURAS" ... SE USA PARA Q NO SE CREE UN LOOP INFINITO ENTRE CLIENTE Y FACTURA, AL LLAMAR AL REST ... EN LA CONTRAPARTE CLIENTE SE HACE LO MISMO.
	@ManyToOne(fetch = FetchType.LAZY)	//MUCHAS FACTURAS A UN SOLO CLIENTE.
	private Cliente cliente;
	
	@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})		//168 MIN 6 ... PARA EVITAR EL ERROR DE HIBERNATE DE CONTENIDO BASURA. 
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)		//ELIMINA LA FACTURA Y DESPU??S SE ELIMINAN LOS ITEMS. ... CREA LA FACTURA Y LUEGO SE A??ADEN LOS ITEMS.
	@JoinColumn(name="factura_id")// "factura_id" : SE ESPECIFICA EL NOMBRE DE MANERA EXPLICITA  //ES NECESARIO INDICAR E JOINCOLUMN, YA QUE LA RELACI??N ES SOLO DE FACTURA A ITEMFACTURA.  SI HUBIESE UNA RELACI??N INVERSA EN ESTE EJEMPLO, CON UN ATRIBUTO FACTURA EN LA CLASE ITEMFACTURA, BASTAR??A. PERO PARA ESTE EJEPLO, LA RELACION ES SOLO FACTURA --> ITEMFACTURA.  
	private List<ItemFactura> items;
	
}

