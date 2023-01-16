package spring.chat.websocket.controllers;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import spring.chat.websocket.models.documents.Mensaje;
import spring.chat.websocket.models.service.IChatService;

//ESTE CONTROLLER VA A MANEJAR LOS MENSAJES DEL BROKER.

@Controller
public class ChatController {
	
	
	@MessageMapping("/mensaje") 	//PARA INDICAR EL DESTINO DONDE LOS USUARIOS VAN A MANDAR LOS MENSAJES DE CHAT.
	@SendTo("/chat/mensaje")		//PARA ENVIAR A LOS DeMÁS CLIENTES Q ESTÁn SUSCRITOS AL EVENTO.
	public Mensaje recibeMensaje(Mensaje mensaje) {
		mensaje.setFecha(new Date().getTime());
		
		if(mensaje.getTipo().equals("NUEVO_USUARIO")) {
			mensaje.setColor(colores[new Random().nextInt(colores.length)]);		//SE LE PASA EL LARGO DEL ARREGLO.
			mensaje.setTexto("nuevo usuario");
		} else {
			chatService.guardar(mensaje);
		}
		
		return mensaje;
	}
	
	@MessageMapping("/escribiendo")				//NOTIFICA AL SERVIDOR Q ALGUIEN ESTÁ ESCRIBIENDO
	@SendTo("/chat/escribiendo")				//NOTIFICA A LOS USUARIOS Q ALGUIEN ESTÁ ESCRIBIENDO
	public String estaEscribiendo(String username) {
		return username.concat(" está escribiendo ...");
	}
	
	@MessageMapping("/historial")
	public void historial(String clienteId){
		//SE USA ESTA WEA PARA Q LOS 10 ULT MENSAJES DEL CHAT LE LLEGUEN AL CLIENTE Q SE ESTÁ CONECTANDO Y NO A TODOS LOS WEONES.
		//ESTA WEA HACE LO MISMO Q EL @SENDTO, PERO SE PUEDE PERSONALIZAR AL USUARIO.
		websocket.convertAndSend("/chat/historial/"+clienteId, chatService.obtenerUltimos10Mensajes());				
	}
	
	
	private String[]colores	= {"red","green","blue","magenta","purple","orange"};
	@Autowired
	private IChatService chatService;
	@Autowired//SE INYECTA UN TEMPLATE DE WEBSOCKET
	private SimpMessagingTemplate websocket;
	
	
}
