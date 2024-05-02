package com.soighiri.produits.controller;

import com.soighiri.produits.dto.ProduitDto;
import com.soighiri.produits.entities.Produit;
import com.soighiri.produits.service.ProduitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class ProduitController {
    private ProduitService produitService;
    //private CategorieService categorieService;
    @Autowired

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    //Por afficher tous les produits
    @GetMapping(value = "produit/listProduits")
    public String index(Model model){
        List<ProduitDto> produitDtos = produitService.geAllProduits();
        model.addAttribute("lesProduit",produitDtos);
        return "admin/produit/listeProduit";
    }

    /** Pour ajouter un produit*
     *
     * @param model
     * @return createProduit.html
     */

    @GetMapping(value = "/produit/createProduit")
    public String create(Model model){
        //ProduitDto produitDto = produitService.saveProduit(produitDto);
        model.addAttribute("produitDto",new ProduitDto());
        return "admin/produit/createProduit";
    }

    @PostMapping(value = "/produit/createProduit")
    public String store(@ModelAttribute("produitDto") @Valid  ProduitDto produitDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "admin/produit/createProduit";
        }
        produitService.saveProduit(produitDto);
        return "redirect:/admin/produit/listProduits";
    }

    // Modifier un produit
    @GetMapping(value ="/produit/edit/{idProduit}")
    public String edit(@PathVariable Long idProduit, Model model){
        // Récupérer le produit par son ID
        ProduitDto produitDto = produitService.getProduit(idProduit);
        if(produitDto ==null){
            return "error/notFound";
        }
        // Ajout du produitDto au modèle
        model.addAttribute("produitDto", produitDto);

        // Retourner la vue d'édition
        return "admin/produit/editProduit";
    }

    @PostMapping(value = "/produit/edit")
    public String update(@PathVariable Long idProduit,@ModelAttribute("produitDto") @Valid ProduitDto produitDto,BindingResult bindingResult ){
        if(bindingResult.hasErrors()) {

        }
        // Mise à jour du produit
        produitDto.setIdProduit(idProduit);
        produitService.updateProduit(produitDto);

        // Redirection vers la liste des produit aprés mis a jours
        return "redirect:/admin/produit/litsproduits";
    }
    //methode pour la suppresion d'un produit
    @PostMapping(value = "/produit/delete")
    public String delete(@PathVariable Long idProduit){
        produitService.deleteProduitById(idProduit);
        if(idProduit == null) {
            return "error/notFound";
        }
        return "redirect:/admin/produit/lstProduits";
    }

    //Methode pour afficher un seul produit

    @GetMapping(value ="/produit/details/{idProduit}")
    public String showDetails(@PathVariable Long idProduit, Model model){
        ProduitDto produitDto = produitService.getProduit(idProduit);
        if(idProduit==null){
            return"error/notFound";
        }
        model.addAttribute("produitDto",produitDto);
        return"admin/produit/showProduit";
    }
}
