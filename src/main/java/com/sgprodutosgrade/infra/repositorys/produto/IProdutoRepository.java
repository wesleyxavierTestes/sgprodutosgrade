package com.sgprodutosgrade.infra.repositorys.produto;

import com.sgprodutosgrade.core.entities.produto.entitys.Produto;

import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRepository extends IBaseProdutoRepository<Produto> {
    
}