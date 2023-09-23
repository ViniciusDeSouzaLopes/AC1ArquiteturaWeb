package com.example.ac1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.CategoriaProdutos;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaProdutoRepository {
     @Autowired
    private EntityManager entityManager;

    @Transactional
    public CategoriaProdutos inserir(CategoriaProdutos categoriaProdutos) {
    entityManager.persist(categoriaProdutos);
    return categoriaProdutos;
    }

    public List<CategoriaProdutos> obterTodos() {
    return entityManager
    .createQuery("from CategoriaProdutos",
    CategoriaProdutos.class)
    .getResultList();
    }
}
