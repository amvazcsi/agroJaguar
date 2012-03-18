package com.agroJaguar.br.fazendaJaguar.web.pages.template;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.agroJaguar.br.fazendaJaguar.web.pages.geral.JaguarMB;


@ManagedBean(name = "templateMB")
@SessionScoped
public class TemplateMB extends JaguarMB implements Serializable{
	
	private static final long serialVersionUID = -5419296629670513116L;
	public static final String TEMPLATE = "template";
	
	private Boolean menuFornecedor=true;
	
	public TemplateMB() {
		super();
	}
	public Boolean getMenuFornecedor() {
		return menuFornecedor;
	}
	public void setMenuFornecedor(Boolean menuFornecedor) {
		this.menuFornecedor = menuFornecedor;
	}
	
}
