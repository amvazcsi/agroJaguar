package com.agroJaguar.br.fazendaJaguar.web.pages.aditivo;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.agroJaguar.br.fazendaJaguar.persistencia.bean.FornecedorBean;
import com.agroJaguar.br.fazendaJaguar.web.pages.geral.JaguarMB;

@ManagedBean(name = "cadastrarFornecedorMB")
@SessionScoped
public class CadastrarFornecedorMB extends JaguarMB implements Serializable{
	
	private static final long serialVersionUID = 864097568580300589L;
	public static final String CADASTRAR_FORNECEDOR = "/restrito/xhtml/fornecedor/cadastrarFornecedor";
	private FornecedorBean fornecedorBean;
	private int page = 1;
	
	public String exibir() {
		fornecedorBean = new FornecedorBean();
		return CADASTRAR_FORNECEDOR;
	}
	
	public boolean validate() {
	    return true;
	}
	public FornecedorBean getFornecedorBean() {
		return fornecedorBean;
	}
	public void setFornecedorBean(FornecedorBean fornecedorBean) {
		this.fornecedorBean = fornecedorBean;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
}
