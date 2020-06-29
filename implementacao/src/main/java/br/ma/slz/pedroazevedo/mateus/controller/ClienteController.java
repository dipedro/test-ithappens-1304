package br.ma.slz.pedroazevedo.mateus.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ma.slz.pedroazevedo.mateus.model.Cliente;
import br.ma.slz.pedroazevedo.mateus.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public ModelAndView buscarClientes() {
		ModelAndView mv = new ModelAndView("clientes");
		List<Cliente> clientes = clienteService.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}
	
	@RequestMapping(value = "/novo-cliente", method = RequestMethod.GET)
	public String buscarClienteForm() {
		return "clienteForm";
	}
	
	@RequestMapping(value = "/novo-cliente", method = RequestMethod.POST)
	public String salvarCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios estão preenchidos!");
			return "redirect:/novo-cliente";
		}
		
		clienteService.save(cliente);
		return "redirect:/clientes";
	}

}
