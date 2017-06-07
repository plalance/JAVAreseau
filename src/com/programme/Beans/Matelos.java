package com.programme.Beans;
import java.util.*;

/**
 * Created by Thibault on 07/06/2017.
 */
public class Matelos extends Joueur {
    private Amiral amiral;
    private ArrayList<Bateau> sesBateaux;

    public Amiral getAmiral() {
        return amiral;
    }

    public void setAmiral(Amiral amiral) {
        this.amiral = amiral;
    }

    public ArrayList<Bateau> getSesBateaux() {
        return sesBateaux;
    }

    public void setSesBateaux(ArrayList<Bateau> sesBateaux) {
        this.sesBateaux = sesBateaux;
    }

    public Matelos() {
        super();
    }

}
