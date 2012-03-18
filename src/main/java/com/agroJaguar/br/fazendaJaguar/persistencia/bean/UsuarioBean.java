package com.agroJaguar.br.fazendaJaguar.persistencia.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "usuario")
public class UsuarioBean implements Serializable{


	private static final long serialVersionUID = 2204198097489788127L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "COD_USUARIO", nullable = false)
	private Integer codUsuario;
	
	@Column(name = "NOME_USUARIO")
    private String nomeUsuario;
	
	@Column(name = "DSC_LOGIN")
    private String dscLogin;
	
	@Column(name = "DSC_SENHA")
    private String dscSenha;

	@Column(name = "IND_ATIVO")
	private Boolean indAtivo;
	
	public Integer getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getDscLogin() {
		return dscLogin;
	}
	public void setDscLogin(String dscLogin) {
		this.dscLogin = dscLogin;
	}
	public String getDscSenha() {
		return dscSenha;
	}
	public void setDscSenha(String dscSenha) {
		this.dscSenha = dscSenha;
	}
	public Boolean getIndAtivo() {
		return indAtivo;
	}
	public void setIndAtivo(Boolean indAtivo) {
		this.indAtivo = indAtivo;
	}
}
