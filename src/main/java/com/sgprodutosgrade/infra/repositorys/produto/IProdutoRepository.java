package com.sgprodutosgrade.infra.repositorys.produto;

import com.sgprodutosgrade.core.entities.produto.entitys.Produto;
import com.sgprodutosgrade.infra.repositorys.IBaseRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRepository extends IBaseRepository<Produto> {
    
}