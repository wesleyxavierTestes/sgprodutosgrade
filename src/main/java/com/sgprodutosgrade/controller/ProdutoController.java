package com.sgprodutosgrade.controller;

import java.util.Objects;

import javax.validation.Valid;

import com.sgprodutosgrade.application.exceptions.RegraBaseException;
import com.sgprodutosgrade.core.entities.produto.entitys.Produto;
import com.sgprodutosgrade.core.services.produto.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {

    private final ProdutoService _service;

    @Autowired
    public ProdutoController(ProdutoService service) {
        _service = service;
    }

    @ExceptionHandler(RegraBaseException.class)
    public ResponseEntity<String> error(RegraBaseException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @GetMapping("list")
    public ResponseEntity<Page<Produto>> list(@RequestParam(name = "page") int page) {

        Page<Produto> list = this._service.list(page);

        return ResponseEntity.ok(list);
    }

    @PostMapping("save")
    public ResponseEntity<Produto> save(@RequestBody Produto entity) {

        if (!Objects.nonNull(entity) || !Objects.nonNull(entity.getItens()) || entity.getItens().isEmpty())
            throw new RegraBaseException("Produto ou Itens inválido");

        entity = this._service.save(entity);

        return ResponseEntity.ok(entity);
    }
}