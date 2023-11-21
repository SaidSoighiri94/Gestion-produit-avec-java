package com.soighiri.produits.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor  //Constructeur sans argument 
@AllArgsConstructor //Constructeur avec tout les argument
// Premiere chose : transformer cette classe en une entité
@Entity

public class Categorie {

	// Les attribut de ma classe 
	@Id  // pour signifier notre clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // pour la genration Id
	private Long idCat;
	
	private String nomCat;
	private String descriptionCat;
	
	@OneToMany(mappedBy ="categorie") // Association un a plusieur via le champs categorie entre produit et categorie
	@JsonIgnore
	private List<Produit> produits; // ceci veu dire que dans une categorie il y a une collection de produits
	
	// Creation d'un constructeru par defaut 
	// si on utilise pas lombok on mepas de constructeur 
	//public Categorie() {
		//super();
		
//	}

	
	// Nos attributs etant privés nous allons donc generer les getters et le setters
	/*//pour l'utilisation de lombok nous allons mettre en commentaite les geetters et setters pour qu il genere automatiquement 
	 * tout getters et setters ainsi que les autre methode
	 * comme toString
	 
	 * public Long getIdCat() {
	 
		return idCat;
	}
		public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	public String getDescriptionCat() {
		return descriptionCat;
	}
	public void setDescriptionCat(String descriptionCat) {
		this.descriptionCat = descriptionCat;
	}


	public List<Produit> getProduits() {
		return produits;
	}


	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
*/
}
