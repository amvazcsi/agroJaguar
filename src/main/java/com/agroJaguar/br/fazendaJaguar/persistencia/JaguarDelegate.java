package com.agroJaguar.br.fazendaJaguar.persistencia;

import com.agroJaguar.br.fazendaJaguar.persistencia.bean.UsuarioBean;

public class JaguarDelegate {

	private static JaguarDelegate instancia = new JaguarDelegate();
	  
	private JaguarDelegate(){}
	
	public static JaguarDelegate getInstancia(){return instancia;}
	   	

	//Obter dados do usuario
	public UsuarioBean obterUsuario(UsuarioBean usuarioBean) throws Exception {
		return JaguarFacade.getInstancia().obterUsuario(usuarioBean); 
    }
}
