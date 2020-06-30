package br.ma.slz.pedroazevedo.mateus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.ma.slz.pedroazevedo.mateus.model.Cliente;
import br.ma.slz.pedroazevedo.mateus.model.Estoque;
import br.ma.slz.pedroazevedo.mateus.model.Filial;
import br.ma.slz.pedroazevedo.mateus.model.PedidoEstoque;
import br.ma.slz.pedroazevedo.mateus.model.Produto;
import br.ma.slz.pedroazevedo.mateus.model.Usuario;
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
	
	@RequestMapping(value = "/fazer-pedido", method = RequestMethod.GET)
	public ModelAndView fazerPedidoForm() {
		ModelAndView mv = new ModelAndView("pedidoForm");
		
		List<Cliente> listaClientes = clienteService.findAll();
		
		List<Usuario> listaUsuarios = usuarioService.findAll();
		
		List<Filial> listaFiliais = filialService.findAll();
		
		mv.addObject("clientes", listaClientes);
		mv.addObject("usuarios", listaUsuarios);
		mv.addObject("filiais", listaFiliais);
		mv.addObject("pedidoEstoque", new PedidoEstoque());
		
		return mv;
	}
	
	@RequestMapping(value="/fazer-pedido", method = RequestMethod.POST)
	public String fazerPedidoForm(PedidoEstoque pedidoEstoque) {
		PedidoEstoque pedidoSalvo = pedidoEstoqueService.save(pedidoEstoque);
		return "redirect:/detalhePedido/" + pedidoSalvo.getId();
	}
	
	@RequestMapping(value = "/detalhePedido/{id}", method = RequestMethod.GET)
	public ModelAndView detalhePedidoForm(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("detalhePedido");
		
		PedidoEstoque pedidoEstoque = pedidoEstoqueService.findById(id);
		
		mv.addObject("pedidoEstoque", pedidoEstoque);
		mv.addObject("produto", new Produto());
		mv.addObject("estoque", new Estoque());
		return mv;
	}
}
