package br.ma.slz.pedroazevedo.mateus.service;

import java.util.List;

import br.ma.slz.pedroazevedo.mateus.model.FormaPagamento;

public interface FormaPagamentoService {
	List<FormaPagamento> findAll();
	FormaPagamento findById(long id);
	FormaPagamento save(FormaPagamento formaPagamento);
}
