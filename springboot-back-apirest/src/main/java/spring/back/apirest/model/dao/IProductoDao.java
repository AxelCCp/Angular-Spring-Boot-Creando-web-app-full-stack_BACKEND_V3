package spring.back.apirest.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import spring.back.apirest.model.entity.Producto;

//181 .......... https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

public interface IProductoDao extends CrudRepository<Producto,Long> {

	//METODO QUE BUSQUE Y FILTRE A LOS PRODUCTOS, PARA DESPUES USARLO AL AGREGAR PRODUCTOS A UNA FACTURA.
	
	// like ?1% : BUSCA EL STRING PASADO POR PARÁMETRO AL COMIENZO DE LA CADENA.
	// like %?1% :	VA A BUSCAR EL PARÁMETRO INGRESADO EN CUALQUIER PARTE DE LA CADENA.
	
	
	@Query("select p from Producto p where p.nombre like ?1%")
	public List<Producto>findByNombre(String term);
	
	//                      =
	
	public List<Producto>findByNombreContainingIgnoreCase(String term);
	
	
	public List<Producto>findByNombreStartingWithIgnoreCase(String term);
	
}
