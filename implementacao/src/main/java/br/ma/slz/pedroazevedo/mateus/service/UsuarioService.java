package br.ma.slz.pedroazevedo.mateus.service;

import java.util.List;

import br.ma.slz.pedroazevedo.mateus.model.Usuario;

public interface UsuarioService {
	List<Usuario> findAll();
	Usuario findById(long id);
	Usuario save(Usuario usuario);
}
