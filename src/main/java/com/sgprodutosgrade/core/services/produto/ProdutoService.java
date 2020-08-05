package com.sgprodutosgrade.core.services.produto;

import com.sgprodutosgrade.core.entities.produto.entitys.Produto;
import com.sgprodutosgrade.core.services.BaseService;
import com.sgprodutosgrade.infra.repositorys.produto.IProdutoRepository;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends BaseService<Produto> {

    public ProdutoService(IProdutoRepository repository) {
        super(repository);
    }
    
}