package com.agroJaguar.br.fazendaJaguar.persistencia.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class FornecedorBean implements java.io.Serializable {

	private static final long serialVersionUID = -819522446257942909L;
	
	private Integer codFornecedor;
	private String descricao;
	
	public Integer getCodFornecedor() {
		return codFornecedor;
	}
	public void setCodFornecedor(Integer codFornecedor) {
		this.codFornecedor = codFornecedor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
