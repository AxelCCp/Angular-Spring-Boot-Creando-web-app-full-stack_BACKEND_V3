package spring.chat.websocket.models.service;

import java.util.List;

import spring.chat.websocket.models.documents.Mensaje;

public interface IChatService {

	
	public List<Mensaje>obtenerUltimos10Mensajes();
	public Mensaje guardar(Mensaje mensaje); 
	
	
}
