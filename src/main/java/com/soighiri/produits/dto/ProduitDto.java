package com.soighiri.produits.dto;

import com.soighiri.produits.entities.Categorie;
import jakarta.validation.constraints.*;
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
    @NotBlank(message = "Nom du produit requis")
    @Size(max = 125, min = 3, message = "Le doit avoir entre 3 a 125 caractere")
    private String nomProduit;
    @NotNull( message = "Veuillez renseigner un prix")
    @Positive(message = "Le prix doit etre un nombre positif")
    private Double prixProduit;
    @Past(message="La date doit etre au passé")
    private Date dateCreation;
    private String nomCat;
    private Categorie categorie;
}
