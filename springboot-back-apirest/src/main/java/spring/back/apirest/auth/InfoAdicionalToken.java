package spring.back.apirest.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import spring.back.apirest.model.entity.Usuario;
import spring.back.apirest.model.service.IUsuarioService;


@Component
public class InfoAdicionalToken implements TokenEnhancer{

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		Map<String,Object>info = new HashMap<>();
		info.put("info_adicional", "Hola que tal! ".concat(authentication.getName()));

		info.put("nombre ", usuario.getNombre());
		info.put("apellido ", usuario.getApellido());
		info.put("email ", usuario.getEmail());
		
		
		((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(info);
		return accessToken;
	}

	
	@Autowired
	private IUsuarioService usuarioService;
	
}
