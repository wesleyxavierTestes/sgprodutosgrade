package com.sgprodutosgrade.infra.repositorys.produto;

import java.util.UUID;

import com.sgprodutosgrade.core.entities.produto.entitys.ProdutoItem;
import com.sgprodutosgrade.infra.repositorys.IBaseRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoItemRepository extends IBaseRepository<ProdutoItem> {
    @Query(
        nativeQuery = true,
        value = "SELECT (i.*) "
            +"FROM public.produto_item i "
            +"WHERE i.id in ( "
            +"SELECT pi.itens_id "
            +"FROM public.produto_itens pi "
            +"where pi.produto_id = ?1)",
            countQuery = "SELECT (i.*) "
            +"FROM public.produto_item i "
            +"WHERE i.id in ( "
            +"SELECT pi.itens_id "
            +"FROM public.produto_itens pi "
            +"where pi.produto_id = ?1)"
    )
	Page<ProdutoItem> listItem(UUID id, PageRequest of);
    
}