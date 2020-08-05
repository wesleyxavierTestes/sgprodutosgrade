package com.sgprodutosgrade.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sgprodutosgrade.core.entities.medida.ProdutoMedida;
import com.sgprodutosgrade.core.entities.produto.entitys.Produto;
import com.sgprodutosgrade.core.entities.produto.entitys.ProdutoItem;
import com.sgprodutosgrade.core.services.produto.ProdutoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProdutoControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private ProdutoService service;

    private String urlStringFormat(String nameEntity, String action, int paginacao) {
        return String.format("http://localhost:%s/api/%s/%s/?page=%s", port, nameEntity, action, paginacao);
    }

    private String urlStringFormat(String nameEntity, String action) {
        return String.format("http://localhost:%s/api/%s/%s", port, nameEntity, action);
    }

    @Test
    public void listTest() {
        String url = urlStringFormat("produto", "list", 1);

        ResponseEntity<String> response = template.getForEntity(url, String.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void saveInalidoTest() {
        String url = urlStringFormat("produto", "save", 1);

        ResponseEntity<String> response = template.postForEntity(url, new Produto(), String.class);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Produto ou Itens inválido", response.getBody());
    }

    @ParameterizedTest
    @ValueSource(strings = { "testeSave"} )
    public void saveTest(String parametro) {
        String url = urlStringFormat("produto", "save");

        Produto produto = new Produto();
        produto.setDataCadastro(LocalDateTime.now());
        produto.setNome("Sandalha"+parametro);
        produto.setValor(new BigDecimal("12.00"));

        List<ProdutoItem> itens = new ArrayList<>();
        itens.add(
            new ProdutoItem()
            .setItensBase(produto.getNome(), new BigDecimal("12.00"), "Verde"+parametro, "123456"+parametro)
        );
        itens.add(
            new ProdutoItem()
            .setItensBase(produto.getNome(), new BigDecimal("12.00"), "Azul"+parametro, "32165"+parametro)
            .setMedidaBuild(new ProdutoMedida())
        );

        produto.setItens(itens);

        HttpEntity<Produto> requestSave = new HttpEntity<>(produto, null);

        ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, requestSave,
        String.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @ParameterizedTest
    @ValueSource(strings = { "testeUpdte"} )
    public void updateTest(String parametro) {
        saveTest(parametro);

        String url = urlStringFormat("produto", "update");

        Produto produto = service.list(1).stream().findFirst().get();

        List<ProdutoItem> itens = produto.getItens();
        itens.add(
            new ProdutoItem()
            .setItensBase(produto.getNome(), new BigDecimal("13.00"), "Amarela", "142954")
            .setMedidaBuild(new ProdutoMedida())
        );
        itens.add(
            new ProdutoItem()
            .setItensBase(produto.getNome(), new BigDecimal("15.00"), "Rosa", "9517533")
            .setMedidaBuild(new ProdutoMedida())
        );
        itens.add(
            new ProdutoItem()
            .setItensBase(produto.getNome(), new BigDecimal("25.00"), "Rosada", "8817533")
            .setMedidaBuild(new ProdutoMedida())
        );
        itens.add(
            new ProdutoItem()
            .setItensBase(produto.getNome(), new BigDecimal("25.00"), "Pink", "8117533")
            .setMedidaBuild(new ProdutoMedida())
        );
        itens.add(
            new ProdutoItem()
            .setItensBase(produto.getNome(), new BigDecimal("5.00"), "Sandalha Rosada", "1245273")
            .setMedidaBuild(new ProdutoMedida())
        );

        produto.setItens(itens);

        HttpEntity<Produto> requestSave = new HttpEntity<>(produto, null);

        ResponseEntity<String> response = template.exchange(url, HttpMethod.PUT, requestSave,
        String.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}