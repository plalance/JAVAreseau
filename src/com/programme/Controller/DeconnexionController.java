package com.programme.Controller;

import com.programme.Beans.Joueur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mol on 21/05/2017.
 */
public class DeconnexionController implements ActionListener{

    Joueur joueur;

    public DeconnexionController(Joueur joueur, JTextField field){
        this.joueur = joueur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       this.joueur.deconnexion();
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}
