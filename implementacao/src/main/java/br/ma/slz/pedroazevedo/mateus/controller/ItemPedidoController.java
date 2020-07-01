package br.ma.slz.pedroazevedo.mateus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ma.slz.pedroazevedo.mateus.model.Estoque;
import br.ma.slz.pedroazevedo.mateus.model.Filial;
import br.ma.slz.pedroazevedo.mateus.model.Produto;
import br.ma.slz.pedroazevedo.mateus.service.EstoqueService;
import br.ma.slz.pedroazevedo.mateus.service.FilialService;
import br.ma.slz.pedroazevedo.mateus.service.ItemPedidoService;
import br.ma.slz.pedroazevedo.mateus.service.PedidoEstoqueService;
import br.ma.slz.pedroazevedo.mateus.service.ProdutoService;

@Controller
public class ItemPedidoController {
	
	@Autowired
	ItemPedidoService itemPedidoService;
	
	@Autowired
	PedidoEstoqueService pedidoEstoqueService;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	EstoqueService estoqueService;
	
	@Autowired
	FilialService filialService;
	
	@RequestMapping(value="/adicionarProduto/{filial_id}", method = RequestMethod.POST)
	public String adicionarProdutoEstoque(Produto produto, @PathVariable("filial_id") Long filial_id, Estoque estoque, List<Produto> produtos) {
		/**System.out.println(filial_id);
		System.out.println(produto.getDescricao());
		System.out.println(estoque.getQuantidade());
		Produto produtoSalvo = produtoService.save(produto);
		
		Filial filial = new Filial();
		filial.setId(filial_id);
		
		estoque.setProduto(produtoSalvo);
		estoque.setFilial(filial);
		
		estoqueService.save(estoque);**/

		return "redirect:/detalhePedido/" + 4;
	}

}
