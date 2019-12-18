package br.com.nastek.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import br.com.nastek.enums.CategoriaEnum;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	private Integer quantidade;
	
	@Enumerated(EnumType.STRING)
	private CategoriaEnum categoria;
	
	@Transient
	private boolean isMaxAndMin;
	
	public CategoriaEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEnum categoria) {
		this.categoria = categoria;
	}

	public Produto() {
		this.categoria = CategoriaEnum.SELECIONE;
	}
	
	public Produto(String descricao, Integer quantidade) {
		this.descricao = descricao;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public boolean isMaxAndMin() {
		return isMaxAndMin;
	}

	public void setMaxAndMin(boolean isMaxAndMin) {
		this.isMaxAndMin = isMaxAndMin;
	}
}
