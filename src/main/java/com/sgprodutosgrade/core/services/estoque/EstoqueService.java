package com.sgprodutosgrade.core.services.estoque;

import com.sgprodutosgrade.core.entities.estoque.AbstractEstoque;
import com.sgprodutosgrade.core.entities.estoque.EstoqueEntrada;
import com.sgprodutosgrade.core.entities.estoque.EstoqueSaida;
import com.sgprodutosgrade.core.services.BaseService;
import com.sgprodutosgrade.infra.repositorys.estoque.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService extends BaseService<AbstractEstoque> {

	private IEstoqueRepository repository;
	
    @Autowired
    public EstoqueService(final IEstoqueRepository repository) {
        super(repository);
    }

	public Page<EstoqueEntrada> listEntrada(int page) {
		return null;
	}

	public Page<EstoqueSaida> listSaida(int page) {
		return null;
	}
}