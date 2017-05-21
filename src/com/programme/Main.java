package com.programme;

import com.programme.Beans.Joueur;
import com.programme.Controller.Controller;
import com.programme.Controller.DeconnexionController;
import com.programme.Views.View;

/**
 * Created by Mol on 21/05/2017.
 */

public class Main {
    public static void main(String[] args) {
        Joueur joueur = new Joueur();

        View vue = new View();
        vue.init();
        Controller controller = new Controller(joueur,vue.getField());
        DeconnexionController decoController = new DeconnexionController(joueur,vue.getField());

        vue.getButton().addActionListener(controller);
        vue.getButtonDeconnexion().addActionListener(decoController);
    }
}