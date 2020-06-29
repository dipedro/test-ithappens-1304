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

import br.ma.slz.pedroazevedo.mateus.model.Filial;
import br.ma.slz.pedroazevedo.mateus.service.FilialService;

@Controller
public class FilialController {
	
	@Autowired
	FilialService filialService;
	
	@RequestMapping(value = "/filiais", method = RequestMethod.GET)
	public ModelAndView buscarFiliais() {
		ModelAndView mv = new ModelAndView("filiais");
		List<Filial> filiais = filialService.findAll();
		mv.addObject("filiais", filiais);
		return mv;
	}
	
	@RequestMapping(value = "/nova-filial", method = RequestMethod.GET)
	public String buscarFilialForm() {
		return "filialForm";
	}
	
	@RequestMapping(value = "/nova-filial", method = RequestMethod.POST)
	public String salvarFilial(@Valid Filial filial, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios estão preenchidos!");
			return "redirect:/nova-filial";
		}
		
		filialService.save(filial);
		return "redirect:/filiais";
	}

}
