package spring.back.apirest.model.dao;

import org.springframework.data.repository.CrudRepository;

import spring.back.apirest.model.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long>{
	
	
	
}
