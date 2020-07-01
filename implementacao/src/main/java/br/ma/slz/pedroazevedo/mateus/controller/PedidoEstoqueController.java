package br.ma.slz.pedroazevedo.mateus.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.ma.slz.pedroazevedo.mateus.model.Estoque;
import br.ma.slz.pedroazevedo.mateus.model.PedidoEstoque;
import br.ma.slz.pedroazevedo.mateus.model.Produto;
import br.ma.slz.pedroazevedo.mateus.service.ClienteService;
import br.ma.slz.pedroazevedo.mateus.service.FilialService;
import br.ma.slz.pedroazevedo.mateus.service.UsuarioService;
import br.ma.slz.pedroazevedo.mateus.service.PedidoEstoqueService;

@Controller
public class PedidoEstoqueController {
	
	@Autowired
	PedidoEstoqueService pedidoEstoqueService;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	FilialService filialService;
	
	List<Estoque> listaEstoque = new ArrayList<>();
	
	@RequestMapping(value = "/fazer-pedido", method = RequestMethod.GET)
	public ModelAndView fazerPedidoForm() {
		ModelAndView mv = new ModelAndView("pedidoForm");
		
	
		PedidoEstoque pedidoEstoque = new PedidoEstoque();
		pedidoEstoque.setObservacao("Nota Fiscal 111");
		
		mv.addObject("clientes", clienteService.findAll());
		mv.addObject("usuarios", usuarioService.findAll());
		mv.addObject("filiais", filialService.findAll());
		mv.addObject("pedidoEstoque", pedidoEstoque);
		
		return mv;
	}
	
	@RequestMapping(value="/fazer-pedido", method = RequestMethod.POST)
	public ModelAndView fazerPedidoForm(PedidoEstoque pedidoEstoque) {

		pedidoEstoque.setCliente(clienteService.findById(pedidoEstoque.getCliente().getId()));
		pedidoEstoque.setUsuario(usuarioService.findById(pedidoEstoque.getUsuario().getId()));
		pedidoEstoque.setFilial(filialService.findById(pedidoEstoque.getFilial().getId()));
		
		ModelAndView mv = new ModelAndView("detalhePedido");
		mv.addObject("pedidoEstoque", pedidoEstoque);
		mv.addObject("estoque", new Estoque());
		return mv;
		
		//PedidoEstoque pedidoSalvo = pedidoEstoqueService.save(pedidoEstoque);
		//return "redirect:/detalhePedido/" + pedidoSalvo.getId();
	}
	
	@RequestMapping(value = "/detalhePedido", method = RequestMethod.GET)
	public void detalhePedidoForm(Model model) {
		model.addAttribute("listaEstoque", this.listaEstoque);
	}

	@RequestMapping(value = "/adicionarProduto", method = RequestMethod.POST)
	public String adicionarProduto(Estoque estoque) {
		
		this.listaEstoque.add(estoque);
		return "redirect:/detalhePedido";
	}
}
