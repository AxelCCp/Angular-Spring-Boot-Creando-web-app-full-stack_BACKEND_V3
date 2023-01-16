package spring.chat.websocket.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.chat.websocket.models.dao.ChatRepository;
import spring.chat.websocket.models.documents.Mensaje;

@Service
public class CharServiceImpl implements IChatService {

	@Override
	public List<Mensaje> obtenerUltimos10Mensajes() {
		// TODO Auto-generated method stub
		return chatRepo.findFirst10ByOrderByFechaDesc();
	}

	@Override
	public Mensaje guardar(Mensaje mensaje) {
		// TODO Auto-generated method stub
		return chatRepo.save(mensaje);
	}
	
	
	@Autowired
	private ChatRepository chatRepo;

}
