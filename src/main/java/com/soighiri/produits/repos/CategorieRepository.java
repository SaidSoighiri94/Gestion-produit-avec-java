package com.soighiri.produits.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.soighiri.produits.entities.Categorie;


@RepositoryRestResource(path="cat")     // Utilisation du SpringDataRest 
@CrossOrigin("htt://localhost:4200/")   //Pour autoriser angular a acceder cette resource 
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
