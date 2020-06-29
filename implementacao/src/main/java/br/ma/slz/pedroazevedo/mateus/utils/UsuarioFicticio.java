package br.ma.slz.pedroazevedo.mateus.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ma.slz.pedroazevedo.mateus.model.Usuario;
import br.ma.slz.pedroazevedo.mateus.repository.UsuarioRepository;

@Component
public class UsuarioFicticio {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	/** A anotação @PostConstruct executa automaticamente ao subir a aplicação. **/
	//@PostConstruct
	public void criarUsuarios() {
		List<Usuario> listaUsuarios = new ArrayList<>();
		
		Usuario usuario1 = new Usuario();
		usuario1.setCpf("05289665374");
		usuario1.setNome("Pedro da Silva Azevedo");
		usuario1.setSenha("123456");
		
		Usuario usuario2 = new Usuario();
		usuario2.setCpf("99999999999");
		usuario2.setNome("Usuario 2");
		usuario2.setSenha("123456");
		
		Usuario usuario3 = new Usuario();
		usuario3.setCpf("00000000000");
		usuario3.setNome("Usuario 3");
		usuario3.setSenha("123456");
		
		listaUsuarios.add(usuario1);
		listaUsuarios.add(usuario2);
		listaUsuarios.add(usuario3);
		
		for(Usuario usuario: listaUsuarios) {
			Usuario usuarioSalvo = usuarioRepository.save(usuario);
			System.out.println(usuarioSalvo.getId() + " - " + usuarioSalvo.getNome());
		}
	}

}
