package br.ma.slz.pedroazevedo.mateus.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ma.slz.pedroazevedo.mateus.model.Produto;
import br.ma.slz.pedroazevedo.mateus.repository.ProdutoRepository;
import br.ma.slz.pedroazevedo.mateus.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired
	ProdutoRepository produtoRepository;

	@Override
	public List<Produto> findAll() {

		return produtoRepository.findAll();
	}

	@Override
	public Produto findById(long id) {

		return produtoRepository.findById(id).get();
	}

	@Override
	public Produto save(Produto produto) {

		return produtoRepository.save(produto);
	}

}
