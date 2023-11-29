package com.soighiri.produits.dto;

import com.soighiri.produits.entities.Produit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieDto {
    private Long idCat;
    private String nomCat;
    private String descriptionCat;
    private List<Produit>produitList;

}
