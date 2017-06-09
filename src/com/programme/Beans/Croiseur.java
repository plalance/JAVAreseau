package com.programme.Beans;

/**
 * Created by Thibault on 09/06/2017.
 */
public class Croiseur extends Bateau {
    private String typeDefaut = "Croiseur";
    private Integer longueurDefaut = 3;

    public Croiseur (){
        super();
        this.setType(typeDefaut);
        this.setLongueur(longueurDefaut);
    }
}
