package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.CategoriaProdutos;
import com.example.ac1.models.Produto;
import com.example.ac1.repository.CategoriaProdutoRepository;
import com.example.ac1.repository.ProdutoRepository;

@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(
			@Autowired ProdutoRepository produtoRepository,
			@Autowired CategoriaProdutoRepository categoriaProdutoRepository) {
		return args -> {
			produtoRepository.save(
					new Produto((long) 0, "Notebook", 2000));
			produtoRepository.save(
					new Produto((long) 0, "Teclado", 10));
			List<Produto> listaProdutos = produtoRepository.findAll();
			listaProdutos.forEach(System.out::println);

			System.out.println("** Obter por nome **");
			listaProdutos = produtoRepository.findByNomeLike("%Teclado%");
			listaProdutos.forEach(System.out::println);

			System.out.println("** INSERIR UMA CATEGORIA **");
			CategoriaProdutos p1 = new CategoriaProdutos(0, "Tecnologia");
			categoriaProdutoRepository.inserir(p1);

			System.out.println("** EXCLUIR UM PRODUTO **");
			listaProdutos.get(0).setCategoriaProduto(p1);
			produtoRepository.delete(listaProdutos.get(0));
			listaProdutos.forEach(System.out::println);

			System.out.println("** SELECIONAR TODOS OS PRODUTO **");
			listaProdutos.get(0).setCategoriaProduto(p1);
			produtoRepository.findAll();
			listaProdutos.forEach(System.out::println);

			System.out.println("** PROCURAR POR ID **");
			listaProdutos = produtoRepository.findByIdLike(0);
			listaProdutos.forEach(System.out::println);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);

	}

}
