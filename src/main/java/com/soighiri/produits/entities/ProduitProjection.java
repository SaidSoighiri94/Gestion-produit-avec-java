package com.soighiri.produits.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomProd",types = {Produit.class}) //Annotation permettant de dire a Spring que cette interface est une projection

public interface ProduitProjection {
    //Pour consulter un attribut on met les getters des attributs qu'on veut consulter
    public String getNomProduit();
}
