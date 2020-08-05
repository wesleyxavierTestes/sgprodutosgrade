package com.sgprodutosgrade.core.entities.estoque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EstoqueEntradaTest {
    
    @Test
    @DisplayName("Valida se calculo descarta  quando valor positivo")
    public void testEstoqueConfigureNetivo() {
        EstoqueEntrada estoque = new EstoqueEntrada();
        
        estoque.setQuantidade(50);

        estoque.configure();

        assertEquals(50, estoque.getQuantidade());
    }

    @Test
    @DisplayName("Valida se calculo transforma em positivo quando valor negativo")
    public void testEstoqueConfigurePositivo() {
        EstoqueEntrada estoque = new EstoqueEntrada();
        
        estoque.setQuantidade(-50);

        estoque.configure();

        assertEquals(50, estoque.getQuantidade());
    }
}