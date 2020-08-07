package com.sgprodutosgrade.core.services.produto;

import java.util.UUID;

import com.sgprodutosgrade.core.entities.produto.entitys.Produto;
import com.sgprodutosgrade.core.entities.produto.entitys.ProdutoItem;
import com.sgprodutosgrade.core.services.BaseService;
import com.sgprodutosgrade.infra.repositorys.produto.IProdutoItemRepository;
import com.sgprodutosgrade.infra.repositorys.produto.IProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends BaseService<Produto, IProdutoRepository> {

    @Autowired
    private IProdutoItemRepository _repository;

    @Autowired
    public ProdutoService(IProdutoRepository repository) {
        super(repository);
    }

	public Page<ProdutoItem> listItem(UUID id, int page) {
        return _repository.listItem(id, PageRequest.of((page - 1), 10));
	}
    
}