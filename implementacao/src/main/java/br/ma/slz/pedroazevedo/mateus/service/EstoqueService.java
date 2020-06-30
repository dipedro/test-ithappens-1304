package br.ma.slz.pedroazevedo.mateus.service;

import java.util.List;

import br.ma.slz.pedroazevedo.mateus.model.Estoque;

public interface EstoqueService {
	List<Estoque> findAll();
	Estoque findById(long id);
	Estoque save(Estoque sstoque);
}
