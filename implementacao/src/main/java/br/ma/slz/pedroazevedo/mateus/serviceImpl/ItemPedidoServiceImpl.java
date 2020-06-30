package br.ma.slz.pedroazevedo.mateus.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ma.slz.pedroazevedo.mateus.model.ItemPedido;
import br.ma.slz.pedroazevedo.mateus.repository.ItemPedidoRepository;
import br.ma.slz.pedroazevedo.mateus.service.ItemPedidoService;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService{
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	@Override
	public List<ItemPedido> findAll() {

		return itemPedidoRepository.findAll();
	}

	@Override
	public ItemPedido findById(long id) {

		return itemPedidoRepository.findById(id).get();
	}

	@Override
	public ItemPedido save(ItemPedido itemPedido) {

		return itemPedidoRepository.save(itemPedido);
	}

}
