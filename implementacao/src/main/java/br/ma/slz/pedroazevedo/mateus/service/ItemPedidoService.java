package br.ma.slz.pedroazevedo.mateus.service;

import java.util.List;

import br.ma.slz.pedroazevedo.mateus.model.ItemPedido;

public interface ItemPedidoService {
	List<ItemPedido> findAll();
	ItemPedido findById(long id);
	ItemPedido save(ItemPedido itemPedido);
	//List<ItemPedido> saveItemPedidos(List<ItemPedido> itensPedido);
}
