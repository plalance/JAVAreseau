package com.programme;

import com.programme.Beans.Joueur;
import com.programme.Controller.Controller;
import com.programme.Views.View;

/**
 * Created by Mol on 21/05/2017.
 */

public class Main {
    public static void main(String[] args) {
//        View vue = new View();
//        vue.init();

        Joueur joueur = new Joueur();
        joueur.setMessage("Je veux me connecter - JOUEUR 1");
        joueur.connexion();

//        Controller controller = new Controller(joueur,vue.getField());

//        vue.getButton().addActionListener(controller);
    }
}
