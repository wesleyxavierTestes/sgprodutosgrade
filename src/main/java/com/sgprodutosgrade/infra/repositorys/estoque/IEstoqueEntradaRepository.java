package com.sgprodutosgrade.infra.repositorys.estoque;

import com.sgprodutosgrade.core.entities.estoque.EstoqueEntrada;
import com.sgprodutosgrade.infra.repositorys.IBaseRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface IEstoqueEntradaRepository extends IBaseRepository<EstoqueEntrada>{
    
}