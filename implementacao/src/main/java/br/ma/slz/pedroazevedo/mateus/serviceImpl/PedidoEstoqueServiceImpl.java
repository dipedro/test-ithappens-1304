package br.ma.slz.pedroazevedo.mateus.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ma.slz.pedroazevedo.mateus.model.PedidoEstoque;
import br.ma.slz.pedroazevedo.mateus.repository.PedidoEstoqueRepository;
import br.ma.slz.pedroazevedo.mateus.service.PedidoEstoqueService;

@Service
public class PedidoEstoqueServiceImpl implements PedidoEstoqueService{
	
	@Autowired
	PedidoEstoqueRepository pedidoEstoqueRepository;

	@Override
	public List<PedidoEstoque> findAll() {

		return pedidoEstoqueRepository.findAll();
	}

	@Override
	public PedidoEstoque findById(long id) {

		return pedidoEstoqueRepository.findById(id).get();
	}

	@Override
	public PedidoEstoque save(PedidoEstoque pedidoEstoque) {

		return pedidoEstoqueRepository.save(pedidoEstoque);
	}

}
