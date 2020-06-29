package br.ma.slz.pedroazevedo.mateus.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ma.slz.pedroazevedo.mateus.model.Filial;
import br.ma.slz.pedroazevedo.mateus.repository.FilialRepository;
import br.ma.slz.pedroazevedo.mateus.service.FilialService;

@Service
public class FilialServiceImpl implements FilialService{
	
	@Autowired
	FilialRepository filialRepository;

	@Override
	public List<Filial> findAll() {

		return filialRepository.findAll();
	}

	@Override
	public Filial findById(long id) {

		return filialRepository.findById(id).get();
	}

	@Override
	public Filial save(Filial filial) {

		return filialRepository.save(filial);
	}

}
