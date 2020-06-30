package br.ma.slz.pedroazevedo.mateus.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ma.slz.pedroazevedo.mateus.model.Estoque;
import br.ma.slz.pedroazevedo.mateus.repository.EstoqueRepository;
import br.ma.slz.pedroazevedo.mateus.service.EstoqueService;

@Service
public class EstoqueServiceImpl implements EstoqueService{
	
	@Autowired
	EstoqueRepository estoqueRepository;

	@Override
	public List<Estoque> findAll() {

		return estoqueRepository.findAll();
	}

	@Override
	public Estoque findById(long id) {

		return estoqueRepository.findById(id).get();
	}

	@Override
	public Estoque save(Estoque estoque) {

		return estoqueRepository.save(estoque);
	}

}
