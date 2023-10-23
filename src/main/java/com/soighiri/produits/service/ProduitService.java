package com.soighiri.produits.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.soighiri.produits.entities.Categorie;
import com.soighiri.produits.entities.Produit;

public interface ProduitService {
	
	// Dans cette interface on colle les methodes du crud puis on les import 
	
	// Ajouter un methode
	Produit saveProduit(Produit p);
	 
	 // Modifier un produit
	 Produit updateProduit(Produit p);
	 
	 // supression d'un produit
	 void deleteProduit(Produit p);
	 void  deleteProduitById(Long id);  // Par son id 
	 
	 // Afficher un produit par son id
	 Produit getProduit(Long id);
	 
	 // Lister tous les produits
	 List<Produit> geAllProduits();
	 
	// Cette methode sert a chercher un produit par son nom
	List<Produit> findByNomProduit(String nom);
		
	//Methode qui sert a afficher le nom qui contient un tel lettre 
	List<Produit> findByNomProduitContains(String nom);
	List<Produit> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);
	List<Produit> findByCategorie(Categorie categorie);
	
	// Methode permettant de trier les produit par rapport a leurs noms dansl'ordre ascendant 
	List<Produit> findByOrderByNomProduitAsc();
	
	//Afficher un produit par l'Id de sa categorie 
	List<Produit> findByCategorieIdCat(Long idCat);
	
	List<Produit> trierProduistNomsPrix();


		
}
