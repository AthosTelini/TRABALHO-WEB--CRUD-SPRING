package br.edu.ifsuldeminas.mch.webii.crudmanager.repo;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}