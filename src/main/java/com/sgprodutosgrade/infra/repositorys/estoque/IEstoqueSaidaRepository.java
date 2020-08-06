package com.sgprodutosgrade.infra.repositorys.estoque;

import com.sgprodutosgrade.core.entities.estoque.EstoqueSaida;
import com.sgprodutosgrade.infra.repositorys.IBaseRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface IEstoqueSaidaRepository extends IBaseRepository<EstoqueSaida>{
    
}