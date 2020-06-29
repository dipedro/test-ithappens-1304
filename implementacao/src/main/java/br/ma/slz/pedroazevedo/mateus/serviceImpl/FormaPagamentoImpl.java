package br.ma.slz.pedroazevedo.mateus.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ma.slz.pedroazevedo.mateus.model.FormaPagamento;
import br.ma.slz.pedroazevedo.mateus.repository.FormaPagamentoRepository;
import br.ma.slz.pedroazevedo.mateus.service.FormaPagamentoService;

@Service
public class FormaPagamentoImpl implements FormaPagamentoService{
	
	@Autowired
	FormaPagamentoRepository formaPagamentoRepository;

	@Override
	public List<FormaPagamento> findAll() {
		return formaPagamentoRepository.findAll();
	}

	@Override
	public FormaPagamento findById(long id) {
		return formaPagamentoRepository.findById(id).get();
	}

	@Override
	public FormaPagamento save(FormaPagamento formaPagamento) {
		return formaPagamentoRepository.save(formaPagamento);
	}

}
