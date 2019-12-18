package br.com.nastek.service;

import java.util.List;

import br.com.nastek.model.Produto;

public interface ProdutoService {

	void salvar(Produto produto);
	
	void excluir(Long id);
	
	List<Produto> filtrar(Produto produto);

	Produto filtrarPorId(Long id);
	
}
