package br.ma.slz.pedroazevedo.mateus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ma.slz.pedroazevedo.mateus.model.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long>{

}
