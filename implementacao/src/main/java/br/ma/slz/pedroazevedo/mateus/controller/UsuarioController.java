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

import br.ma.slz.pedroazevedo.mateus.model.Usuario;
import br.ma.slz.pedroazevedo.mateus.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public ModelAndView buscarUsuarios() {
		ModelAndView mv = new ModelAndView("usuarios");
		List<Usuario> usuarios = usuarioService.findAll();
		mv.addObject("usuarios", usuarios);
		return mv;
	}
	
	@RequestMapping(value = "/novo-usuario", method = RequestMethod.GET)
	public String buscarUsuarioForm() {
		return "usuarioForm";
	}
	
	@RequestMapping(value = "/novo-usuario", method = RequestMethod.POST)
	public String salvarUsuario(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios estão preenchidos!");
			return "redirect:/novo-usuario";
		}
		
		usuarioService.save(usuario);
		return "redirect:/usuarios";
	}

}
