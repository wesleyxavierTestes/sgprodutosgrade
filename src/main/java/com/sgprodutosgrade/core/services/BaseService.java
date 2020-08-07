package com.sgprodutosgrade.core.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import com.sgprodutosgrade.application.exceptions.RegraBaseException;
import com.sgprodutosgrade.core.entities.produto.BaseEntity;
import com.sgprodutosgrade.infra.repositorys.IBaseRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseService<T extends BaseEntity, Y extends IBaseRepository<T>> {

    protected final Y _repository;

    public BaseService(Y repository) {
        _repository = repository;
    }
    public Page<T> list(int page) {
        return this._repository.findAll(PageRequest.of((page - 1), 10));
    }

    public T find(UUID id) {
        Optional<T> optional = this._repository.findById(id);
        if (!optional.isPresent())
            throw new RegraBaseException("Busca Inválida item inexistente");
            
        return optional.get();
    }

    @Transactional
    public T save(T entity) {

        entity.setAtivo(true);
        entity.setDataCadastro(LocalDateTime.now());
        entity.setId(UUID.randomUUID());
        
        this._repository.save(entity);

        return entity;
    }

    @Transactional
    public T update(T entity) {
        Optional<T> optional = this._repository.findById(entity.getId());
        if (!optional.isPresent()) {
            throw new RegraBaseException("Item inexistente");
        }

        this._repository.save(entity);
        return entity;
    }

    public T delete(UUID id) {
        Optional<T> optional = this._repository.findById(id);
        if (!optional.isPresent())
            throw new RegraBaseException("Item inexistente");

        this._repository.deleteById(id);
        return optional.get();
    }
}