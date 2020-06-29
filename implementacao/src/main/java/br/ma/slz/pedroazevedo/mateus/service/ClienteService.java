package br.ma.slz.pedroazevedo.mateus.service;

import java.util.List;

import br.ma.slz.pedroazevedo.mateus.model.Cliente;

public interface ClienteService {
	List<Cliente> findAll();
	Cliente findById(long id);
	Cliente save(Cliente usuario);
}
