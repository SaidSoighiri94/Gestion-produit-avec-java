package com.soighiri.produits;

import com.soighiri.produits.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProduitsApplication implements CommandLineRunner {
	@Autowired

	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args){
		SpringApplication.run(ProduitsApplication.class, args);
	}

	//Implementation de la mmethode permettant d'afficher les Ids des produit avec l'utilisation @RepositoryRestResource
	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Produit.class);
	}
}
