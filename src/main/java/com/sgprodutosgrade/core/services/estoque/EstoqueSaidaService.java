package com.sgprodutosgrade.core.services.estoque;

import com.sgprodutosgrade.core.entities.estoque.EstoqueSaida;
import com.sgprodutosgrade.core.services.BaseService;
import com.sgprodutosgrade.infra.repositorys.estoque.IEstoqueSaidaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueSaidaService extends BaseService<EstoqueSaida, IEstoqueSaidaRepository> {
	
    @Autowired
    public EstoqueSaidaService(final IEstoqueSaidaRepository repository) {
        super(repository);
    }
}