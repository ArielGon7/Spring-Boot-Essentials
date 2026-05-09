package com.devari.spring_boot_essentials.service;

import com.devari.spring_boot_essentials.database.model.ProdutoEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    public List<ProdutoEntity> PRODUTOS = List.of(
            ProdutoEntity.builder().
            id(1).
            name("PC").
            preco(new BigDecimal(2100)).
            quantidade(1).
            build(),

            ProdutoEntity.builder().
                    id(2).
                    name("Teclado").
                    preco(new BigDecimal(124)).
                    quantidade(1).
                    build(),

            ProdutoEntity.builder().
                    id(2).
                    name("Mouse").
                    preco(new BigDecimal(50)).
                    quantidade(1).
                    build()

    );

    public List<ProdutoEntity> findAll() {
        return PRODUTOS;
    }
}
