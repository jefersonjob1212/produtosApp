package br.com.nastek.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nastek.enums.CategoriaEnum;
import br.com.nastek.model.Produto;
import br.com.nastek.repository.ProdutoRepository;
import br.com.nastek.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;

	@Override
	public void salvar(Produto produto) {
		repository.save(produto);
	}

	@Override
	public void excluir(Long id) {
		Produto p = repository.getOne(id);
		repository.delete(p);
	}

	@Override
	public List<Produto> filtrar(Produto produto) {
		// TODO Auto-generated method stub
		List<Produto> lista = new ArrayList<>();
		if(produto.getCategoria() != null && 
				produto.getCategoria().compareTo(CategoriaEnum.SELECIONE) != 0) {
			lista = repository.findByCategoria(produto.getCategoria());
		} else if(produto.isMaxAndMin()) { 
			Integer minimo = repository.getMinQuantidade();
			Integer maximo = repository.getMaxQuantidade();
			Produto produtoMinimo = repository.findFirstByQuantidade(minimo);
			Produto produtoMaximo = repository.findFirstByQuantidade(maximo);
			lista.add(produtoMinimo);
			lista.add(produtoMaximo);
		}else {
			lista = repository.findAll();
		}
		return lista;
	}

	@Override
	public Produto filtrarPorId(Long id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id).get();
	}

}
