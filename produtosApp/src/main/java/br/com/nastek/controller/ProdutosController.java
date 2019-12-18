package br.com.nastek.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.nastek.enums.CategoriaEnum;
import br.com.nastek.model.Produto;
import br.com.nastek.service.ProdutoService;

@Controller
@RequestMapping("/Produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoService service;
	
	private ModelAndView mv;
	
	private static final String DIR_PROD = "/Produtos/";
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("produtoFiltro") Produto produtoFiltro) {
		List<Produto> produtos = service.filtrar(produtoFiltro);
		this.mv = new ModelAndView(DIR_PROD.concat("Listar"));
		this.mv.addObject("produtos", produtos);
		return this.mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		this.mv = new ModelAndView(DIR_PROD.concat("Novo"));
		this.mv.addObject(new Produto());
		return this.mv;
	}
	
	@RequestMapping("{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		this.mv = new ModelAndView(DIR_PROD.concat("Novo"));
		this.mv.addObject(service.filtrarPorId(id));
		return this.mv;
	}
	
	@RequestMapping("/remove/{id}")
	public ModelAndView confirmaExclusao(@PathVariable("id") Long id) {
		this.mv = new ModelAndView(DIR_PROD.concat("ConfirmaExclusao"));
		this.mv.addObject(service.filtrarPorId(id));
		return this.mv;
	}
	
	@PostMapping
	public String salvar(Produto produto) {
		service.salvar(produto);
		return "redirect:".concat(DIR_PROD);
	}
	
	@PostMapping(value="/remove")
	public String remove(Produto produto) {
		service.excluir(produto.getId());
		return "redirect:".concat(DIR_PROD);
	}

	@ModelAttribute("categorias")
	public List<CategoriaEnum> categorias(){
		List<CategoriaEnum> list = Arrays.asList(CategoriaEnum.values());
		return list;
	}
}
