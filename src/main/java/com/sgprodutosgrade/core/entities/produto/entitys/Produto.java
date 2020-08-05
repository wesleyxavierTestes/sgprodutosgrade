package com.sgprodutosgrade.core.entities.produto.entitys;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.sgprodutosgrade.core.entities.produto.base.AbstractProduto;
import com.sgprodutosgrade.core.entities.produto.base.IProduto;
import com.sgprodutosgrade.core.entities.produto.base.IProdutoItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto extends AbstractProduto implements IProduto {
 
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL , targetEntity = AbstractProduto.class)
    private List<ProdutoItem> itens = new ArrayList<>();
}