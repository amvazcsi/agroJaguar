package com.agroJaguar.br.fazendaJaguar.web.pages;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.agroJaguar.br.fazendaJaguar.web.pages.geral.JaguarMB;

@ManagedBean(name = "indexMB")
@SessionScoped
public class IndexMB extends JaguarMB implements Serializable {

    private static final long serialVersionUID = -2403138958014741653L;
	public static final String INDEX_PORTAL = "/restrito/xhtml/index";
	public static final String CADASTRAR_FORNECEDOR = "/restrito/xhtml/fornecedor/cadastrarForncedor";
	
	public IndexMB(){
		this.getUsuarioBean();
	}
	
    public String exibir() {
		return CADASTRAR_FORNECEDOR;
	}
    
}
