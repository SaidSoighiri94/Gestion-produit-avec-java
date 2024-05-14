package com.soighiri.produits.restcontroller;

import java.util.List;

import com.soighiri.produits.dto.ProduitDto;
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
	// @RequestMapping(method = RequestMethod.GET) on aurait pu ecrire ca, ancienne version
	@GetMapping("/listProduit") 
	
	public List<ProduitDto> getAllProduits(){
		return produitService.geAllProduits();
	}
	
	// Pour creer un web service permettant d'afficher un seul produit 
	@GetMapping("/{idProduit}")
	public ProduitDto getProduitById(@PathVariable(name = "idProduit") Long idProduit) {
		return produitService.getProduit(idProduit);
	}
	//methode pour ajouter un produit 
	@PostMapping("/addProduit")
	//@RequestMapping( method = RequestMethod.POST)
	public ProduitDto creatProduit(@RequestBody ProduitDto produitDto) {
		return produitService.saveProduit(produitDto);
	} 
	
	//Ajout de la methode qui permet de modifier un produit .
	@PutMapping( value="/updateProduit")
	//@RequestMapping( value = "/updateProduit",method = RequestMethod.PUT). on peut aussi ecrire comme ca
	public ProduitDto updateProduit(@RequestBody ProduitDto produitDto) {
		return produitService.updateProduit(produitDto);
	}

	
	//Methode permettant la supresssion d'un Porduit
	@DeleteMapping(value = "/delete/{idProduit}") //on peut ecrire comme ca aussi.
	//@RequestMapping(value = "/delete/{idProduit}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable(name ="idProduit") Long idProduit) {
		produitService.deleteProduitById(idProduit);
	}

	// Methode permettant d'afficher un produit selon sa categorie
	@RequestMapping(value = "/produitCat/{idCat}",method = RequestMethod.GET)
	public List<Produit> getProduitByCatId(@PathVariable(name = "idCat") Long idCat){
		return produitService.findByCategorieIdCat(idCat);
	}
	
	//Methode permettant de chercher un produit par son nom
	@GetMapping(value = "/produitByName/{nomProduit}")
	public List<Produit> findByNomProduitContaints(@PathVariable("nomProduit") String nomProduit){
		return produitService.findByNomProduitContains(nomProduit);
	}
}
