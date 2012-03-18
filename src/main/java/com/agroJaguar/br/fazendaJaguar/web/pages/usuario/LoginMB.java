package com.agroJaguar.br.fazendaJaguar.web.pages.usuario;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import com.agroJaguar.br.fazendaJaguar.criptografia.CriptografiaSenha;
import com.agroJaguar.br.fazendaJaguar.persistencia.JaguarDelegate;
import com.agroJaguar.br.fazendaJaguar.persistencia.bean.UsuarioBean;
import com.agroJaguar.br.fazendaJaguar.util.JSFUtil;
import com.agroJaguar.br.fazendaJaguar.util.ValueUtils;
import com.agroJaguar.br.fazendaJaguar.web.pages.geral.JaguarMB;


@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB extends JaguarMB implements Serializable{
	
	private static final long serialVersionUID = -5419296629670513116L;
	public static final String LOGIN = "/publico/xhtml/login";
	public static final String INDEX_PORTAL = "/restrito/xhtml/index";
	public static final String CADASTRAR_FORNECEDOR = "/restrito/xhtml/fornecedor/cadastrarFornecedor";
	
	private String usuario;
	private String senha;
	
	public String exibir() {
		usuarioBean = new UsuarioBean();
		usuarioBean = buscaUsuario();
		return LOGIN;
	}
	
	/**
	 * Inserir um novo Ensaio
	 */
	public String entrar(){

		try {
			usuarioBean = new UsuarioBean();
			usuarioBean.setDscLogin(usuario);
			
			CriptografiaSenha criptoSenha = new CriptografiaSenha();
			String senhaCriptografada  = criptoSenha.criptografar(senha);
			usuarioBean.setDscSenha(senha);
			
			usuarioBean = JaguarDelegate.getInstancia().obterUsuario(usuarioBean);
			if (ValueUtils.isNotBlank(usuarioBean) && ValueUtils.isNotBlank(usuarioBean.getCodUsuario()) && usuarioBean.getIndAtivo()){
				limpar();
				JSFUtil.getSession().setAttribute(UsuarioBean.class.getSimpleName(), usuarioBean);
				//CriarTracoMB criarTracoMB = JSFUtil.getManagedBean("criarTracoMB", CriarTracoMB.class);
				//criarTracoMB.exibir();
				//JSFUtil.getResponse().sendRedirect(JSFUtil.getRequest().getContextPath() + "/index.jsf");
				return CADASTRAR_FORNECEDOR;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return LOGIN;
	}

	public void limpar(){
		usuario=null;
		senha=null;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
