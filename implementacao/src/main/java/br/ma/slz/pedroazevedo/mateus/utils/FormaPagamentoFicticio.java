package br.ma.slz.pedroazevedo.mateus.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ma.slz.pedroazevedo.mateus.model.FormaPagamento;
import br.ma.slz.pedroazevedo.mateus.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoFicticio {
	
	@Autowired
	FormaPagamentoRepository formaPagamentoRepository;
	
	/** A anotação @PostConstruct executa automaticamente ao subir a aplicação. **/
	//@PostConstruct
	public void criarClientes() {
		List<FormaPagamento> listaFormasPagamento = new ArrayList<>();
		
		FormaPagamento forma1 = new FormaPagamento();
		forma1.setNome("A VISTA");
		
		FormaPagamento forma2 = new FormaPagamento();
		forma2.setNome("BOLETO");
		
		FormaPagamento forma3 = new FormaPagamento();
		forma3.setNome("CARTAO");
		
		
		listaFormasPagamento.add(forma1);
		listaFormasPagamento.add(forma2);
		listaFormasPagamento.add(forma3);
		
		for(FormaPagamento formaPagamento: listaFormasPagamento) {
			FormaPagamento formaPagamentoSalvo = formaPagamentoRepository.save(formaPagamento);
			System.out.println(formaPagamentoSalvo.getId() + " - " + formaPagamentoSalvo.getNome());
		}
	}

}
