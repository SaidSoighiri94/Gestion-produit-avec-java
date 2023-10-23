package com.soighiri.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.soighiri.produits.entities.Categorie;
import com.soighiri.produits.entities.Produit;
import com.soighiri.produits.repos.ProduitRepository;

@SpringBootTest 
class ProduitsApplicationTests {
	@Autowired
	
	//Declarer un objet repository de type ProduitRepository
	private ProduitRepository produitRepository;
	
	// Methode pour ajouter un nouveau produit
	@Test
	public void testCreateProduit() {
		Produit prod = new Produit("Iprimante Casio",600.300,new Date());
		produitRepository.save(prod);
	}
	
	// Methode pour lister un produit par son Id
	@Test
	public void testFindProduit()
	{
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p);
	}
	
	//Methode pour modifier un produit 
	@Test
	public void testUpdateProduit() {
		Produit p = produitRepository.findById(6L).get();
		p.setNomProduit("PC Toshiba");
		p.setPrixProduit(2300.400);
		produitRepository.save(p);
		
		System.out.println(p);
	}
	
	// Methode pour supprimer un produit
	@Test
	public void testDeleteProduit() {
		produitRepository.deleteById(9L);
	}
	
	
	//Methode pour lister tous les produits
	@Test
	public void testFindAllProduit() {
		
		// On va declarer une liste des produit 
		List<Produit> prods = produitRepository.findAll();
		
		// on fait une boucle pour afficher les produits
		for(Produit p:prods) {
			System.out.println(p);
		}
	}
	
	// on va tester la methode findByNomProduit()
	@Test 
	public void testFindProduitByNom() {
		List<Produit> prods = produitRepository.findByNomProduit("PC Asus");
		
		// on fait une petite boucle de foreach
		for(Produit p:prods) {
			//on affiche p
			System.out.println(p);
		}
	}
	
	// Cette methode sert à chercher le nom qui cotient la lettre P;
	@Test 
	public void testFindProduitByNomContains() {
		List<Produit> prods = produitRepository.findByNomProduitContains("P");
		for(Produit p:prods) {
			System.out.println(p);
		}
		
	}
	
	/*** 
	 *  Cette methode sert a afficher un produit par son nom et son prix;
	 * Pour utiliser cette methode il faut declarer les requettes jpql @Query dans le fichier ProduitRepository
	 */
		@Test 
		public void testfindProduitByNomPrix() {
			List<Produit> prods = produitRepository.findByNomPrix("PC Dell",1000.0);
			for(Produit p:prods) {
				System.out.println(p);
			}
			
		}
		
		//Methode permettant d'afficher un produit selon sa categorie 
		@Test 
		public void testFindByCategorie() {
			
			// On cree un objet categorie 
			Categorie cat = new Categorie();
			
			// On l'affecte l'idCat a 2L car c est un long 
			cat.setIdCat(2L);
			
			//on fait une liste de produit en appelant la methode findByCategorie et on lui passe en parametre cat
			List<Produit> prods = produitRepository.findByCategorie(cat);
			
			// Puis on fait une boucle foreach sur prods
			for(Produit p : prods) {
				System.out.println(p);
			}
		}
		
		//Cette methode permet de tester l'affchage d'un  produit selon l'id de sa categorie 
		@Test
		public void testFindByCategorieIdCategorie() {
			
			//on fait une liste de produit en appelant la methode findByCategorieIdCat et on lui passe en parametre idCat
			List<Produit> prods = produitRepository.findByCategorieIdCat(3L);
			
			// Puis on fait une boucle foreach sur les produit
			for(Produit p : prods) {
				System.out.println(p);
			}
		}
			
		// Methode permettant de tester le tri des donner par leur nom
		@Test
		public void testFindByOrderByNomProduitAsc() {
		 List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		 for(Produit p : prods) {
			 System.out.println(p);
		 }
		}
		
		// Methode qui permet de tester le tri de des produit par nom et prix en ordre decroissant
		@Test
		public void testTrierProduitsNomsPrix() {
			List<Produit> prods = produitRepository.trierProduistNomsPrix();
			for(Produit p : prods) {
				System.out.println(p);
			}
			
		}
		
		
}
