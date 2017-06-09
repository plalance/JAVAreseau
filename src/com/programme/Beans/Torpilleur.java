package com.programme.Beans;

/**
 * Created by Thibault on 09/06/2017.
 */
public class Torpilleur extends Bateau {
    private String typeDefaut = "Torpilleur";
    private Integer longeurDefaut = 2;


    public Torpilleur(){
        super();
        this.setType(typeDefaut);
        this.setLongueur(longeurDefaut);
    }
}
