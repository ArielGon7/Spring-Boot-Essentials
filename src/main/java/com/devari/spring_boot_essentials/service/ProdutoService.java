package com.devari.spring_boot_essentials.service;

import com.devari.spring_boot_essentials.database.model.ProdutoEntity;
import com.devari.spring_boot_essentials.dto.ProdutoDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProdutoService {

    public List<ProdutoEntity> PRODUTOS = new ArrayList<>();

    static {

        ProdutoEntity.builder().
                id(1).
                name("PC").
                preco(new BigDecimal(2100)).
                quantidade(1).
                build();

        ProdutoEntity.builder().
                id(2).
                name("Teclado").
                preco(new BigDecimal(124)).
                quantidade(1).
                build();

        ProdutoEntity.builder().
                id(2).
                name("Mouse").
                preco(new BigDecimal(50)).
                quantidade(1).
                build();
    }



    public List<ProdutoEntity> findAll() {
        return PRODUTOS;
    }

    Integer indentificador = PRODUTOS.stream().mapToInt(ProdutoEntity::getId).max().orElse(0) + 1;

    public ProdutoEntity create(ProdutoDto produtoDto){
        ProdutoEntity newProduto = ProdutoEntity.builder().
                id(indentificador).
                name(produtoDto.getName()).
                preco(produtoDto.getPreco()).
                quantidade(produtoDto.getQuantidade()).build();

        PRODUTOS.add(newProduto);
        return newProduto;
    }
}
