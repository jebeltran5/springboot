package com.example.inventario.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	  protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	                .requestMatchers("/public/**").permitAll() // Permite acceso a rutas públicas
	                .anyRequest().authenticated() // Requiere autenticación para todas las demás rutas
	                .and()
	            .formLogin() // Habilita el formulario de inicio de sesión por defecto
	                .loginPage("/login") // Ruta personalizada para el formulario de inicio de sesión
	                .permitAll()
	                .and()
	            .logout() // Habilita el logout por defecto
	                .logoutSuccessUrl("/login?logout") // Ruta de redirección después del logout
	                .permitAll();
	    }
    
	public SecurityConfig() {
		// TODO Auto-generated constructor stub
	}

}
