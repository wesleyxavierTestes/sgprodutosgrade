package com.sgprodutosgrade.infra.repositorys;

import java.util.UUID;

import com.sgprodutosgrade.core.entities.produto.BaseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<T extends BaseEntity> extends JpaRepository<T, UUID>{
    
}