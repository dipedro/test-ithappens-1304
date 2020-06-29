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
		cliente1.setNome("Cliente 1");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Cliente 2");
		
		Cliente cliente3 = new Cliente();
		cliente2.setNome("Cliente 3");
		
		
		listaClientes.add(cliente1);
		listaClientes.add(cliente2);
		listaClientes.add(cliente3);
		
		for(Cliente cliente: listaClientes) {
			Cliente clienteSalvo = clienteRepository.save(cliente);
			System.out.println(clienteSalvo.getId() + " - " + clienteSalvo.getNome());
		}
	}

}
