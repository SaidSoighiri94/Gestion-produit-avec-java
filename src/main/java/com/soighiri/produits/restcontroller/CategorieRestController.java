package com.soighiri.produits.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soighiri.produits.entities.Categorie;
import com.soighiri.produits.repos.CategorieRepository;

@RestController 
@RequestMapping("/api/categorie")
@CrossOrigin
public class CategorieRestController {
	@Autowired
	CategorieRepository categorieRepository;
	
	// Lister tous les categories
	@GetMapping(value ="/listCategories")
	public List<Categorie> getAllCategories(){
		return categorieRepository.findAll();
	}
	
	//Consulter une categorie par son Id
	@GetMapping(value = "/{idCat}")
	 public Categorie getCategorieById(@PathVariable("idCat") Long idCat) {
		return categorieRepository.findById(idCat).get();
	}

}
