package com.sgprodutosgrade.core.entities.produto.base;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.sgprodutosgrade.core.entities.produto.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractProduto extends BaseEntity implements IProduto {

    @Column(nullable = false)
    protected String nome;

    @Column(nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    protected BigDecimal valor;

    // @JsonGetter("valor")
    // public void getJsonValor(String valor) {
    //     this.valor = new BigDecimal(valor);
    // }

    // @JsonSetter("valor")
    // public String getJsonValor() {
    //     return this.valor.toString();
    // }
}