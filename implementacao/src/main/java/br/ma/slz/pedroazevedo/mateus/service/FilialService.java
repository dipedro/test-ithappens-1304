package br.ma.slz.pedroazevedo.mateus.service;

import java.util.List;

import br.ma.slz.pedroazevedo.mateus.model.Filial;

public interface FilialService {
	List<Filial> findAll();
	Filial findById(long id);
	Filial save(Filial filial);
}
