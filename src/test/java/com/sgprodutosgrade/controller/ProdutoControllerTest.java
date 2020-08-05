package com.sgprodutosgrade.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sgprodutosgrade.core.entities.produto.base.IProdutoItem;
import com.sgprodutosgrade.core.entities.produto.entitys.Produto;
import com.sgprodutosgrade.core.entities.produto.entitys.ProdutoItem;

import org.junit.jupiter.api.Test;
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

    @Test
    public void saveTest() {
        String url = urlStringFormat("produto", "save");

        Produto produto = new Produto();
        produto.setNome("Sandalha");
        produto.setValor(new BigDecimal("12.00"));

        List<ProdutoItem> itens = new ArrayList<>();
        itens.add(new ProdutoItem().setItensBase(produto.getNome(), new BigDecimal("12.00"), "Sandalha Verde", "123456"));
        itens.add(new ProdutoItem().setItensBase(produto.getNome(), new BigDecimal("12.00"), "Sandalha Azul", "32165"));

        produto.setItens(itens);

        HttpEntity<Produto> requestSave = new HttpEntity<>(produto, null);

        ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, requestSave,
        String.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}