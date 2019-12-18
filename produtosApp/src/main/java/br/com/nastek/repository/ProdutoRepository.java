package br.com.nastek.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.nastek.enums.CategoriaEnum;
import br.com.nastek.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByCategoria(CategoriaEnum categoria);
	
	@Query("SELECT max(p.quantidade) as quantidade FROM Produto p")
	Integer getMaxQuantidade();
	
	@Query("SELECT min(p.quantidade) as quantidade FROM Produto p")
	Integer getMinQuantidade();
	
	Produto findFirstByQuantidade(Integer quantidade);
}
