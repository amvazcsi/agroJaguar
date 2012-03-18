package com.agroJaguar.br.fazendaJaguar.web.geral;

import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;


/**
 * Executa configura��es iniciais do sistema. 
 * Qualquer incializa��o que seja necess�rio realizar no momento que aplica��o subir
 * deve ser colocado nessa classe.
 */
public class InicializadorSistema implements ServletContextListener {

	private static Logger log = Logger.getLogger(InicializadorSistema.class);
	
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
	
		ServletContext servletContext = servletContextEvent.getServletContext();
		
		log.info("Inicializando Sistema...");
		
		Locale.setDefault(new Locale("pt", "BR"));
		log.info("Setado locale: pt BR");
		//servletContext.setAttribute("contextoWeb", servletContext.getContextPath());
		log.info("Finalizada inicializacao do Sistema.");
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}	
}
