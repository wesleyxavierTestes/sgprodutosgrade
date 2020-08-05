package com.sgprodutosgrade.core.entities.estoque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EstoqueSaidaTest {
    
    @Test
    @DisplayName("Valida se calculo descarta  quando valor negativo")
    public void testEstoqueConfigureNetivo() {
        EstoqueSaida estoque = new EstoqueSaida();
        
        estoque.setQuantidade(-50);

        estoque.configure();

        assertEquals(-50, estoque.getQuantidade());
    }

    @Test
    @DisplayName("Valida se calculo transforma em negativo quando valor positivo")
    public void testEstoqueConfigurePositivo() {
        EstoqueSaida estoque = new EstoqueSaida();
        
        estoque.setQuantidade(50);

        estoque.configure();

        assertEquals(-50, estoque.getQuantidade());
    }
}