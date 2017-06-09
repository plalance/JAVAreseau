package com.programme.Beans;

/**
 * Created by Thibault on 09/06/2017.
 */
public class Cuirasse extends Bateau {
    private String typeDefaut = "Cuirasse";
    private Integer longueurDefaut = 4;


    public Cuirasse (){
        super();
        this.setType(typeDefaut);
        this.setLongueur(longueurDefaut);
    }
}
