package com.sgprodutosgrade.infra.repositorys.produto;

import java.util.UUID;

import com.sgprodutosgrade.core.entities.produto.base.IProduto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseProdutoRepository<T extends IProduto> extends JpaRepository<T, UUID>{
    
}