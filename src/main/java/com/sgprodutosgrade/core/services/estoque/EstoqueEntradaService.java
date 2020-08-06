package com.sgprodutosgrade.core.services.estoque;

import com.sgprodutosgrade.core.entities.estoque.EstoqueEntrada;
import com.sgprodutosgrade.core.services.BaseService;
import com.sgprodutosgrade.infra.repositorys.estoque.IEstoqueEntradaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueEntradaService extends BaseService<EstoqueEntrada, IEstoqueEntradaRepository> {
	
    @Autowired
    public EstoqueEntradaService(final IEstoqueEntradaRepository repository) {
        super(repository);
    }
}