package com.ProyectoWeb;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")
                .roles("ADMIN")
                .and()
                .withUser("cliente")
                .password("{noop}1122")
                .roles("CLIENTE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                        "/categoria/nuevo", "/categoria/guardar",
                        "/categoria/modificar/**", "/categoria/eliminar/**",
                        "/cliente/nuevo", "/cliente/guardar",
                        "/cliente/modificar/**", "/cliente/eliminar/**",
                        "/usuario/nuevo", "/usuario/guardar",
                        "/usuario/modificar/**", "/usaurio/eliminar/**",
                        "/combo/nuevo", "/combo/guardar",
                        "/combo/modificar/**", "/combo/eliminar/**",
                        "/notificacion/nuevo",     
                        "/notificacion/modificar/**",      "/notificacion/eliminar/**",
                       "/factura/nuevo" 
                      , "/factura/eliminar/**")
                    .hasRole("ADMIN")
                .antMatchers(
                 "/notificacion/guardar","/factura/guardar" ,  "/factura/modificar/**")
                .hasRole("CLIENTE")
                .antMatchers("/")
                .hasAnyRole("ADMIN", "CLIENTE")
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");
    }
}
