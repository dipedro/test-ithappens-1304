package br.ma.slz.pedroazevedo.mateus.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ma.slz.pedroazevedo.mateus.model.Cliente;
import br.ma.slz.pedroazevedo.mateus.repository.ClienteRepository;

@Component
public class ClienteFicticio {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	/** A anotação @PostConstruct executa automaticamente ao subir a aplicação. **/
	//@PostConstruct
	public void criarClientes() {
		List<Cliente> listaClientes = new ArrayList<>();
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Brenda Emmylly");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Pedro Azevedo");
		
		Cliente cliente3 = new Cliente();
		cliente3.setNome("Julliana RH");
		
		
		listaClientes.add(cliente1);
		listaClientes.add(cliente2);
		listaClientes.add(cliente3);
		
		for(Cliente cliente: listaClientes) {
			Cliente clienteSalvo = clienteRepository.save(cliente);
			System.out.println(clienteSalvo.getId() + " - " + clienteSalvo.getNome());
		}
	}

}
