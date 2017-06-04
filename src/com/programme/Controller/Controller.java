package com.programme.Controller;

import com.programme.Beans.Joueur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mol on 21/05/2017.
 */
public class Controller implements ActionListener{

    Joueur joueur;
    JTextField field;

    public Controller(Joueur joueur, JTextField field){
        this.joueur = joueur;
        this.field = field;
        this.joueur.createSocket();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.joueur.setMessage(field.getText());
        if (!this.joueur.getLogin().equals(null)){
            this.joueur.setLogin("Anonyme");
        }
        this.joueur.setLogin(field.getText());
        this.joueur.envoiPaquet("causer");
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public JTextField getField() {
        return field;
    }

    public void setField(JTextField field) {
        this.field = field;
    }
}
