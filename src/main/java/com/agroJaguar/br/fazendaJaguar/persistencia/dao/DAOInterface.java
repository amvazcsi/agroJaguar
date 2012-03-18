package com.agroJaguar.br.fazendaJaguar.persistencia.dao;



public abstract interface DAOInterface {

	
	public Object obterObjeto(String query,Class<?> classe) throws Exception;


	@SuppressWarnings("unchecked")
	public java.util.List obterObjetos(String query,Class<?> classe) throws Exception;
	  
}
