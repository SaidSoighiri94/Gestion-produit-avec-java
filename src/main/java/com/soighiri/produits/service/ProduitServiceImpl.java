package com.soighiri.produits.service;

import java.util.List;
import java.util.stream.Collectors;

import com.soighiri.produits.dto.ProduitDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soighiri.produits.entities.Categorie;
import com.soighiri.produits.entities.Produit;
import com.soighiri.produits.repos.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {
	@Autowired
	ProduitRepository produitRepository;

	@Autowired
	ModelMapper modelMapper;




	@Override
	public ProduitDto saveProduit(ProduitDto produitDto) {
		return convertEntityToDto(produitRepository.save(convertDtoToEntity(produitDto)));
	}

	@Override
	public ProduitDto updateProduit(ProduitDto produitDto) {
		return convertEntityToDto(produitRepository.save(convertDtoToEntity(produitDto)));
	}

	@Override
	public void deleteProduit(Produit p) {
		produitRepository.delete(p);
		
	}

	@Override
	public void deleteProduitById(Long idProduit) {
		produitRepository.deleteById(idProduit);
		
	}

	@Override
	public ProduitDto getProduit(Long idProduit) {
		return convertEntityToDto(produitRepository.findById(idProduit).get());
	}

	@Override
	//Pour cette Methode nous allons utiliser les Stream pour la conversion en DTO
	public List<ProduitDto> geAllProduits() {
		
		return produitRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Produit> findByNomProduit(String nom) {
		return produitRepository.findByNomProduit(nom);
	}

	@Override
	public List<Produit> findByNomProduitContains(String nom) {
		return produitRepository.findByNomProduitContains(nom);
	}

	@Override
	public List<Produit> findByNomPrix(String nom, Double prix) {
		return produitRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Produit> findByCategorie(Categorie categorie) {
		return produitRepository.findByCategorie(categorie);
	}

	@Override
	public List<Produit> findByOrderByNomProduitAsc() {
		return produitRepository.findByOrderByNomProduitAsc();
	}

	@Override
	public List<Produit> findByCategorieIdCat(Long idCat) {
		return produitRepository.findByCategorieIdCat(idCat);
	}

	@Override
	public List<Produit> trierProduistNomsPrix() {
	
		return produitRepository.trierProduistNomsPrix();
	}

	@Override
	//Premiere methode
	public ProduitDto convertEntityToDto(Produit p) {
		/* ProduitDto produitDto = new ProduitDto();
		produitDto.setIdProduit(p.getIdProduit());
		produitDto.setNomProduit(p.getNomProduit());
		produitDto.setPrixProduit(p.getPrixProduit());
		produitDto.setCategorie(p.getCategorie());

		return produitDto;*/

		// 2eme methode avec l'utilisation de Builder
		/*return ProduitDto.builder()
				.idProduit(p.getIdProduit())
				.nomProduit(p.getNomProduit())
				.prixProduit(p.getPrixProduit())
				.dateCreation(p.getDateCreation())
				.categorie(p.getCategorie())

				// Pareil ici aussi
				//.nomCat(p.getCategorie().getNomCat())
				.build();*/
		// utilisatin de modelMapper

		//Dire a modelmapper d'aller cher un peu plus loin dans la categorie le nomCat
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProduitDto produitDto = modelMapper.map(p, ProduitDto.class);
		return produitDto;
	}

	@Override
	//2eme methode
	public Produit convertDtoToEntity(ProduitDto produitDto) {
		//Utilisation de modelMapper
		Produit produit = new Produit();
		produit = modelMapper.map(produitDto, Produit.class);
		return produit;

		// Ancien Methode
		/*Produit produit =new Produit();
		produit.setIdProduit(produitDto.getIdProduit());
		produit.setNomProduit(produitDto.getNomProduit());
		produit.setPrixProduit(produitDto.getPrixProduit());
		produit.setDateCreation(produitDto.getDateCreation());
		produit.setCategorie(produitDto.getCategorie());
		return produit;

		 */

	}


}
