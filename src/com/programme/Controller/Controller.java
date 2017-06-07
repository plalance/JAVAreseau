package com.programme.Controller;

import com.programme.Beans.Joueur;
import com.programme.Views.GridView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mol on 21/05/2017.
 */
public class Controller implements ActionListener{

    Joueur joueur;
    JTextField field;
    GridView vue;

    public Controller(Joueur joueur, GridView vue){
        this.joueur = joueur;
        this.field = vue.getField();
        this.joueur.createSocket();
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.joueur.setMessage(field.getText());
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
