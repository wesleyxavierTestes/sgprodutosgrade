package com.sgprodutosgrade.controller;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.sgprodutosgrade.application.exceptions.RegraBaseException;
import com.sgprodutosgrade.core.entities.estoque.AbstractEstoque;
import com.sgprodutosgrade.core.entities.estoque.EstoqueEntrada;
import com.sgprodutosgrade.core.entities.estoque.EstoqueSaida;
import com.sgprodutosgrade.core.entities.estoque.IEstoque;
import com.sgprodutosgrade.core.services.estoque.EstoqueEntradaService;
import com.sgprodutosgrade.core.services.estoque.EstoqueSaidaService;
import com.sgprodutosgrade.core.services.estoque.EstoqueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/estoque")
public class EstoqueController {

    private final EstoqueService _service;
    private final EstoqueSaidaService _serviceSaida;
    private final EstoqueEntradaService _serviceEntrada;

    @Autowired
    public EstoqueController(
        EstoqueService service,
        EstoqueSaidaService serviceSaida,
        EstoqueEntradaService serviceEntrada
        ) {
        _service = service;
        _serviceSaida = serviceSaida;
        _serviceEntrada = serviceEntrada;
    }

    @ExceptionHandler(RegraBaseException.class)
    public ResponseEntity<String> error(RegraBaseException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @GetMapping("list")
    public ResponseEntity<Page<AbstractEstoque>> list(@RequestParam(name = "page") int page) {

        Page<AbstractEstoque> list = this._service.list(page);

        return ResponseEntity.ok(list);
    }

    @GetMapping("list/entrada")
    public ResponseEntity<Page<EstoqueEntrada>> listEntrada(@RequestParam(name = "page") int page) {

        Page<EstoqueEntrada> list = this._serviceEntrada.list(page);

        return ResponseEntity.ok(list);
    }

    @GetMapping("list/saida")
    public ResponseEntity<Page<EstoqueSaida>> listSaida(@RequestParam(name = "page") int page) {

        Page<EstoqueSaida> list = this._serviceSaida.list(page);

        return ResponseEntity.ok(list);
    }

    @GetMapping("find")
    public ResponseEntity<AbstractEstoque> find(@RequestParam(name = "id") String id) {

        AbstractEstoque entity = this._service.find(UUID.fromString(id));

        return ResponseEntity.ok(entity);
    }

    @PostMapping("save")
    public ResponseEntity<AbstractEstoque> save(@RequestBody EstoqueEntrada entity) {

        IEstoque estoque = null;
        for (int y = 0; y < 2; y++) {
            for (int i = 0; i < 50; i++) {
                if (y == 0) {
                    estoque = new EstoqueSaida();
                } else {
                    estoque = new EstoqueEntrada();
                }
                estoque.setQuantidade(i++);
                estoque.configure();
                this._service.save((AbstractEstoque)estoque);
            }
        }

        return ResponseEntity.ok(entity);
    }

    @PutMapping("update")
    public ResponseEntity<AbstractEstoque> update(@RequestBody AbstractEstoque entity) {

        entity = this._service.update(entity);

        return ResponseEntity.ok(entity);
    }
}