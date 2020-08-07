package com.sgprodutosgrade.core.entities.medida;

import javax.persistence.Entity;

import com.sgprodutosgrade.core.entities.produto.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProdutoMedida extends BaseEntity {

    private String tipoMedida;
    private Float tamanho;
    private Float peso;
    private Float altura;
    private Float largura;    
}