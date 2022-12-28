package spring.back.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import spring.back.apirest.model.entity.Factura;
import spring.back.apirest.model.service.IClienteService;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class FacturaRestController {

	@GetMapping("/facturas/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Factura facturaPorId(@PathVariable Long id) {
		return clienteService.findFacturaById(id);
	}
	
	
	@Autowired
	private IClienteService clienteService;
	
}
