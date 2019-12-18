package br.com.nastek.viewmodel;

import br.com.nastek.enums.CategoriaEnum;

public class ProdutoViewModel {
	
private String descricao;
	
	private Integer quantidade;

	private CategoriaEnum categoria;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public CategoriaEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEnum categoria) {
		this.categoria = categoria;
	}

}
