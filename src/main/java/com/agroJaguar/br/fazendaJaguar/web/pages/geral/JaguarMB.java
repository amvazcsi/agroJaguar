package com.agroJaguar.br.fazendaJaguar.web.pages.geral;

import java.util.List;

import javax.faces.model.SelectItem;

import com.agroJaguar.br.fazendaJaguar.persistencia.bean.UsuarioBean;
import com.agroJaguar.br.fazendaJaguar.util.JSFUtil;

public class JaguarMB{
	
	private static final long serialVersionUID = 4329741374890959553L;
	
	private List<SelectItem> listaAditivo;
	
	public UsuarioBean usuarioBean;
	
	public UsuarioBean buscaUsuario(){
		return getUsuarioBean();
	}
	
	public UsuarioBean getUsuarioBean() {
		usuarioBean = (UsuarioBean) JSFUtil.getSession().getAttribute(UsuarioBean.class.getSimpleName());
		return usuarioBean;
	}
	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}
	
	public void inicializar() {
	}
	
}
