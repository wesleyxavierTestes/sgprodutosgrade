package com.sgprodutosgrade.infra.repositorys.estoque;

import com.sgprodutosgrade.core.entities.estoque.AbstractEstoque;
import com.sgprodutosgrade.infra.repositorys.IBaseRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface IEstoqueRepository extends IBaseRepository<AbstractEstoque>{
    
}