package br.ma.slz.pedroazevedo.mateus.service;

import java.util.List;

import br.ma.slz.pedroazevedo.mateus.model.PedidoEstoque;

public interface PedidoEstoqueService {
	List<PedidoEstoque> findAll();
	PedidoEstoque findById(long id);
	PedidoEstoque save(PedidoEstoque pedidoEstoque);
}
