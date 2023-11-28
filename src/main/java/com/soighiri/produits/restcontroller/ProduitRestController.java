package com.soighiri.produits.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.soighiri.produits.entities.Produit;
import com.soighiri.produits.service.ProduitService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin


public class ProduitRestController {
	@Autowired
	ProduitService produitService;
	
	//Pour creer un web service permettant d'afficher tous les produit 
	//Pour specifier la nature de la methode 
	@RequestMapping(method = RequestMethod.GET)
	//@GetMapping("/listProduit") on aurait pu ecrire ca 
	
	public List<Produit> getAllProduits(){
		return produitService.geAllProduits();
	}
	
	// Pour creer un web service permettant d'afficher un seul produit 
	@GetMapping("/{idProduit}")
	public Produit getProduitById(@PathVariable(name = "idProduit") Long idProduit) {
		return produitService.getProduit(idProduit);
	}
	//methode pour ajouter un produit 
	@PostMapping("/addProduit")
	public Produit creatProduit(@RequestBody Produit produit) {
		return produitService.saveProduit(produit);
	} 
	
	//Ajout de la methode qui permet de modifier un produit .
	@PutMapping( value="/updateProduit")
	//@RequestMapping(method = RequestMethod.PUT). on peut aussi ecrire comme ca 
	public Produit updateProduit(@RequestBody Produit produit) {
		return produitService.updateProduit(produit);
	}

	
	//Methode permettant la supresssion d'un Porduit
	//@PostMapping(value = "/delete/{idProduit}")on peut ecrire comme ca aussi.
	@RequestMapping(value = "/delete/{idProduit}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable(name ="idProduit") Long idProduit) {
		produitService.deleteProduitById(idProduit);
	}

	// Methode permettant d'afficher un produit selon sa categorie
	@RequestMapping(value = "/produitCat/{idCat}",method = RequestMethod.GET)
	public List<Produit> getProduitByCatId(@PathVariable(name = "idCat") Long idCat){
		return produitService.findByCategorieIdCat(idCat);
	}
}
