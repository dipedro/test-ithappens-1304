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

import br.ma.slz.pedroazevedo.mateus.model.FormaPagamento;
import br.ma.slz.pedroazevedo.mateus.service.FormaPagamentoService;

@Controller
public class FormaPagamentoController {

	@Autowired
	FormaPagamentoService formaPagamentoService;
	
	@RequestMapping(value = "/formas-pagamento", method = RequestMethod.GET)
	public ModelAndView buscarFormasPagamento() {
		ModelAndView mv = new ModelAndView("formas-pagamento");
		List<FormaPagamento> formasPagamento = formaPagamentoService.findAll();
		mv.addObject("formasPagamento", formasPagamento);
		return mv;
	}
	
	@RequestMapping(value = "/nova-forma-pagamento", method = RequestMethod.GET)
	public String buscarFormaPagamentoForm() {
		return "formaPagamentoForm";
	}
	
	@RequestMapping(value = "/nova-forma-pagamento", method = RequestMethod.POST)
	public String salvarFormaPagamento(@Valid FormaPagamento formaPagamento, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios estão preenchidos!");
			return "redirect:/nova-forma-pagamento";
		}
		
		formaPagamentoService.save(formaPagamento);
		return "redirect:/formas-pagamento";
	}
}
