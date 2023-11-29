package com.soighiri.produits.dto;

import com.soighiri.produits.entities.Categorie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduitDto {
    private Long idProduit;
    private String nomProduit;
    private Double prixProduit;
    private Date dateCreation;

    // Si on veut simplement le nom de la categorie on fait
    private String nomCat;
    //private Categorie categorie;
}
