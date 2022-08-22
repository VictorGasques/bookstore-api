package com.victor.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.bookstore.domain.Categoria;
import com.victor.bookstore.domain.Livro;
import com.victor.bookstore.repositories.CategoriaRepository;
import com.victor.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados () {
		Categoria cat1 = new Categoria(null, "informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "ficção cientifica", "ficção cientifica");
		Categoria cat3 = new Categoria(null, "porno", "histórias eróticas");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "TI fodido", "Nat Willis", "esse autor so escreve merda", cat1);
		Livro l3 = new Livro(null, "sabedoria do saber", "algum cara ai", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "marcelinho e os contos eroticos", "marcelinho", "toma karen toma", cat3);
		Livro l5 = new Livro(null, "familia sacana", "Tufos", "Algum tarado ai criou essa merda", cat3);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3));
		cat3.getLivros().addAll(Arrays.asList(l4, l5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
