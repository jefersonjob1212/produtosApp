package br.com.nastek.enums;

public enum CategoriaEnum {
	
	ALIMENTOS("Alimentos"),
	BEBIDAS("Bebidas"),
	PERECIVEIS("Perecíveis"),
	HIGIENE("Higiene"),
	LIMPEZA("Limpeza"),
	SELECIONE("Selecione...");
	
	private String descricaoCategoria;
	
	CategoriaEnum(String descricaoCategoria) {
		// TODO Auto-generated constructor stub
		this.descricaoCategoria = descricaoCategoria;
	}
	
	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

}
