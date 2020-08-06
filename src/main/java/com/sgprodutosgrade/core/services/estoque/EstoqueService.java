package com.sgprodutosgrade.core.services.estoque;

import com.sgprodutosgrade.core.entities.estoque.AbstractEstoque;
import com.sgprodutosgrade.core.services.BaseService;
import com.sgprodutosgrade.infra.repositorys.estoque.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService extends BaseService<AbstractEstoque, IEstoqueRepository> {
	
    @Autowired
    public EstoqueService(final IEstoqueRepository repository) {
        super(repository);
    }
}