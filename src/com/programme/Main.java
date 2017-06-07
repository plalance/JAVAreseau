package com.programme;

import com.programme.Beans.Joueur;
import com.programme.Controller.Controller;
import com.programme.Controller.DeconnexionController;
import com.programme.Controller.LoginController;
import com.programme.Views.GridView;
import com.programme.Views.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mol on 21/05/2017.
 */

public class Main{
    public static void main(String[] args) {
        Joueur joueur = new Joueur();

        GridView vue = new GridView();
//        View vue = new View();
        vue.init();
        Controller controller = new Controller(joueur,vue);
        DeconnexionController decoController = new DeconnexionController(joueur,vue.getField());
        LoginController loginController = new LoginController(joueur, vue.getLoginField());

        vue.getButton().addActionListener(controller);
        vue.getLoginButton().addActionListener(loginController);
        vue.getButtonDeconnexion().addActionListener(decoController);

        vue.getBoutonA().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent args0) {
                joueur.setTeam("A");
                joueur.choseTeam();
            }
        });

        vue.getBoutonB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent args0) {
                joueur.setTeam("B");
                joueur.choseTeam();
            }
        });
    }
}