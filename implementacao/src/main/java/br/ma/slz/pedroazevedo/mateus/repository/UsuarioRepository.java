package br.ma.slz.pedroazevedo.mateus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ma.slz.pedroazevedo.mateus.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{

}
