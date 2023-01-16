package spring.chat.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker				//HABILITA EL BROKER DE WEBSOCKET
public class WebSocketConfig  implements WebSocketMessageBrokerConfigurer{

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat-websocket")
		.setAllowedOrigins("http://localhost:4200")
		.withSockJS();  													//PERMITE CON SOCKJS USAR EL PROTOCOLO HTTP PARA CONECTAR CON EL SERVIDOR DE WEBSOCKET, O SEA EL BROKER.
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/chat/");								//SE HABILITA EL SIMPLE BROKER. EL PREFIJO CHAT ES PARA LOS NOMBRES DE EVENTOS.
		registry.setApplicationDestinationPrefixes("/app");					//ESTE ES EL PREFIJO DE LA DESTINACIÓN. CUANDO SE ENVIA UN MENSAJE, SE ENVÍA NUESTRO PAYLOAD AL BROKER, HACIA UN DESTINO. Y ESE DESTINO SE DEFINE CON MESSAGE MAPPING.  // app ES EL DESTINO DONDE SE VA A PUBLICAR.
	}

	
	
}
