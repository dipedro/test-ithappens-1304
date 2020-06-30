package br.ma.slz.pedroazevedo.mateus.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ma.slz.pedroazevedo.mateus.enums.eTipoPedido;
import br.ma.slz.pedroazevedo.mateus.model.Cliente;
import br.ma.slz.pedroazevedo.mateus.model.Filial;
import br.ma.slz.pedroazevedo.mateus.model.PedidoEstoque;
import br.ma.slz.pedroazevedo.mateus.model.Usuario;
import br.ma.slz.pedroazevedo.mateus.repository.ClienteRepository;
import br.ma.slz.pedroazevedo.mateus.repository.FilialRepository;
import br.ma.slz.pedroazevedo.mateus.repository.PedidoEstoqueRepository;
import br.ma.slz.pedroazevedo.mateus.repository.UsuarioRepository;

@Component
public class PedidoEstoqueFicticio {
	
	@Autowired
	PedidoEstoqueRepository pedidoEstoqueRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	FilialRepository filialRepository;
	
	/** A anotação @PostConstruct executa automaticamente ao subir a aplicação. **/
	//@PostConstruct
	public void criarPedidoEstoque() {
		PedidoEstoque pedidoEstoque = new PedidoEstoque();
		
		pedidoEstoque.setObservacao("Entregar no condominio ipem angelim.");
		pedidoEstoque.setTipo(eTipoPedido.ENTRADA);
		
		List<Cliente> listaClientes = clienteRepository.findAll();
		
		List<Usuario> listaUsuarios = usuarioRepository.findAll();
		
		List<Filial> listaFiliais = filialRepository.findAll();
		
		pedidoEstoque.setCliente(listaClientes.get(0));
		pedidoEstoque.setUsuario(listaUsuarios.get(0));
		pedidoEstoque.setFilial(listaFiliais.get(0));
		
		PedidoEstoque pedidoEstoqueSalvo = pedidoEstoqueRepository.save(pedidoEstoque);
		
		System.out.println(pedidoEstoqueSalvo.toString());
		
		/**for(Cliente cliente: listaClientes) {
			Cliente clienteSalvo = clienteRepository.save(cliente);
			System.out.println(clienteSalvo.getId() + " - " + clienteSalvo.getNome());
		}**/
	}

}
