package com.soighiri.produits.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.soighiri.produits.entities.Categorie;
import com.soighiri.produits.entities.Produit;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "rest")
public interface ProduitRepository extends JpaRepository<Produit, Long> {

	// Methode pour les produit qui va retourner une liste de produit 
	// Cette methode sert a chercher un produit par son nom
	List<Produit> findByNomProduit(String nom);
	
	//Methode qui sert a afficher le nom qui contient un tel lettre 
	List<Produit> findByNomProduitContains(String nom);
	
	//Methode qui affiche le nom d'un produit et son prix'findByNomPrix en utilisant le jpQl @Query
	/*@Query("select p from Produit p where p.nomProduit  like %?1 and p.prixProduit > ?2")
	List<Produit> findByNomPrix(String nom, Double prix);
	*/
	// on peut ce pendant utiliser la methode des @Param au lieu de ? pour la lisibilité du code 
	
	@Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
	List<Produit> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);
	
	//Ecrire des requette jpql en passant des entités en parametre 
	//Methode permettant d'afficher un produit selon sa categorie
	@Query("select p from Produit p where p.categorie =?1")
	List<Produit> findByCategorie(Categorie categorie);
	
	//Afficher un produit par l'Id de sa categorie 
	List<Produit> findByCategorieIdCat(Long idCat);
	
	// Methode permettant de trier les produit par rapport a leurs noms dansl'ordre ascendant 
	List<Produit> findByOrderByNomProduitAsc();
	
	// Methode pour trier les produit grace leur nom et leur produits en utilisant le langage JPQL
	@Query("Select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
	List<Produit> trierProduistNomsPrix();
	
}
