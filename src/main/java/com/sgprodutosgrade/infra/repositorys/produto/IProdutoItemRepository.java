package com.sgprodutosgrade.infra.repositorys.produto;

import com.sgprodutosgrade.core.entities.produto.entitys.ProdutoItem;

import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoItemRepository extends IBaseProdutoRepository<ProdutoItem> {
    
}