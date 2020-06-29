package br.ma.slz.pedroazevedo.mateus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ma.slz.pedroazevedo.mateus.model.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Long>{

}
