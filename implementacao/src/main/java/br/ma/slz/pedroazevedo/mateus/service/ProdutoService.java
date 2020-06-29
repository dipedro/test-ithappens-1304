package br.ma.slz.pedroazevedo.mateus.service;

import java.util.List;

import br.ma.slz.pedroazevedo.mateus.model.Produto;

public interface ProdutoService {
	List<Produto> findAll();
	Produto findById(long id);
	Produto save(Produto produto);
}
