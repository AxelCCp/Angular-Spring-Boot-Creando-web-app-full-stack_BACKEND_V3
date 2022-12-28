package spring.back.apirest.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
	
	public Cliente() {
		this.facturas = new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	/*
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	*/
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
	
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}



	private static final long serialVersionUID = -7109603343817773768L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message="no puede estar vacío.")
	@Size(min=2,max=12, message="el tamaño debe ser entre 2 y 12 caracteres.")
	@Column(nullable=false)
	private String nombre;
	@NotEmpty(message="no puede estar vacío.")
	private String apellido;
	@NotEmpty(message="no puede estar vacío.")
	@Email(message="no está bien la direccion de email.")
	@Column(nullable=false, unique=true)
	private String email;
	@NotNull(message="no puede estar vacío.")
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	private String foto;
	
	@NotNull(message="la region no puede ser vacía")
	@ManyToOne(fetch = FetchType.LAZY) //MUCHOS CLIENTES PUEDEN VIVIR EN UNA SOLA REGIÓN
	@JoinColumn(name="region_id") 	//LA LLAVE FORANEA.
							//168 MIN 6 ... PARA EVITAR EL ERROR DE HIBERNATE DE CONTENIDO BASURA
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) //CLASE 113, MIN 8:30 ::: SI NO SE IGNORAN ESTOS ATRIBUTOS, VA A LANZAR UN ERROR.ESTOS OBJ'S SON DE HIBERNETE, QUE ESTÁ RELACIONADO AL OBJ REGION.
	private Region region;
									 //168 MIN 6 ... PARA EVITAR EL ERROR DE HIBERNATE DE CONTENIDO BASURA
	@JsonIgnoreProperties({"cliente","hibernateLazyInitializer","handler"}) //POR CADA FACTURA SE IGNORA LA RELACIÓN INVERSA QUE SERÍA "CLIENTE" ... SE USA PARA Q NO SE CREE UN LOOP INFINITO ENTRE CLIENTE Y FACTURA, AL LLAMAR AL REST ... EN LA CONTRAPARTE FACTURA SE HACE LO MISMO.
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL) //mappedBy = "cliente" : MAPEADO POR EL ATRIBUTO CLIENTE DE LA CLASE FACTURA. // ELIMINA CLIENTE --> SE ELIMINAN FACTURAS .... CREA CLIENTE ---> Y DESPUÉS SE REGISTRAN SUS FACTURAS.
	private List<Factura>facturas;
}
