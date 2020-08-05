package com.sgprodutosgrade.core.entities.produto.entitys;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.sgprodutosgrade.core.entities.medida.ProdutoMedida;
import com.sgprodutosgrade.core.entities.produto.base.AbstractProduto;
import com.sgprodutosgrade.core.entities.produto.base.IProdutoItem;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProdutoItem extends AbstractProduto implements IProdutoItem {
    
    public ProdutoItem setItensBase(String nome, BigDecimal valor, String detalhes, String codigoBarras) {
        setNome(nome);
        setValor(valor);
        setDetalhes(detalhes);
        setCodigoBarras(codigoBarras);

        return this;
    }

    public ProdutoItem setMedidaBuild(ProdutoMedida medida) {
        setMedida(medida);
        return this;
    }

    @Column(unique = true)
    private String codigoBarras;

    @Column(unique = true)
    private String detalhes;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @Cascade( { org.hibernate.annotations.CascadeType.SAVE_UPDATE })
    private ProdutoMedida medida;
}