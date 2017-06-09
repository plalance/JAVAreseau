package com.programme.Beans;

/**
 * Created by Thibault on 09/06/2017.
 */
public class SousMarin extends Bateau {
    private String typeDefaut = "Sous-Marin";
    private Integer longueurDefaut = 1;

    public SousMarin(){
        super();
        this.setType(typeDefaut);
        this.setLongueur(longueurDefaut);
    }
}
