package spring.back.apirest.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	//ESTE MISMO MÉTODO ESTA EN  SpringSecurityConfig
	//ESTO ES POR EL LADO DE OAUTH
	//METODO QUE PERMITE IMPLEMENTAR LAS REGLAS DE SEGURIDAD DE LAS RUTAS DE LA APLICACION.
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()																	//ESTE ES EL PATH PARA LAS IMAGENES DE LOS CLIENTES EN LA LISTA DEL FRONT
		.antMatchers(HttpMethod.GET,"/api/clientes", "/api/clientes/page/**", "/api/uploads/img/**", "/images/**").permitAll()
		//.antMatchers("/api/clientes/{id}").permitAll()
		//.antMatchers("/api/facturas/**").permitAll()
		/*
		.antMatchers(HttpMethod.GET, "/api/clientes/{id}").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST, "/api/clientes/upload").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")
		.antMatchers("/api/clientes/**").hasRole("ADMIN")
		*/
		.anyRequest().authenticated()
		.and()
		.cors().configurationSource(corsConfigurationSource());
	}
	
	//140 CONFIGURACIÓN DEL CORS
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration(); 
		//config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));					//ESTE LO USO EN LOCAL.
		config.setAllowedOriginPatterns(Arrays.asList("http://localhost:4200","*"));				//ESTE LO USO EN EL DEPLOY. EL "*" ES PARA Q TOME CUALQUIER NOMBRE DE SERVIDOR EXTERNO.
		config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-type","Authorization"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);//"/**" : PARA TODAS LAS RUTAS DEL BACKEND.
		return source;	
	}
	
	//140 CONFIGURACIÓN DE UN FILTRO
	@Bean
	public FilterRegistrationBean<CorsFilter>corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
	
	
}
