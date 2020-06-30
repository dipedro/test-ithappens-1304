package br.ma.slz.pedroazevedo.mateus.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ma.slz.pedroazevedo.mateus.model.Filial;
import br.ma.slz.pedroazevedo.mateus.repository.FilialRepository;

@Component
public class FilialFicticio {
	
	@Autowired
	FilialRepository filialRepository;
	
	/** A anotação @PostConstruct executa automaticamente ao subir a aplicação. **/
	//@PostConstruct
	public void criarClientes() {
		List<Filial> listaFiliais = new ArrayList<>();
		
		Filial filial1 = new Filial();
		filial1.setNome("Mateus Cohama");
		
		Filial filial2 = new Filial();
		filial2.setNome("Mateus Cohab");
		
		Filial filial3 = new Filial();
		filial3.setNome("Mateus Renascença");
		
		
		listaFiliais.add(filial1);
		listaFiliais.add(filial2);
		listaFiliais.add(filial3);
		
		for(Filial filial: listaFiliais) {
			Filial filialSalvo = filialRepository.save(filial);
			System.out.println(filialSalvo.getId() + " - " + filialSalvo.getNome());
		}
	}

}
