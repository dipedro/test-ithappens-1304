package br.ma.slz.pedroazevedo.mateus.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ma.slz.pedroazevedo.mateus.model.Usuario;
import br.ma.slz.pedroazevedo.mateus.repository.UsuarioRepository;
import br.ma.slz.pedroazevedo.mateus.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {

		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(long id) {

		return usuarioRepository.findById(id).get();
	}

	@Override
	public Usuario save(Usuario usuario) {

		return usuarioRepository.save(usuario);
	}

}
