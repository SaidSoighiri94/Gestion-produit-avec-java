package com.soighiri.produits.dto;

import com.soighiri.produits.entities.Categorie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduitDto {
    private Long idProduit;
    private String nomProduit;
    private Double prixProduit;
    private Date dateCreation;
    private Categorie categorie;
}
