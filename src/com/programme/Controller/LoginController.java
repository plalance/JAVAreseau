package com.programme.Controller;

import com.programme.Beans.Joueur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mol on 21/05/2017.
 */
public class LoginController implements ActionListener{

    Joueur joueur;
    JTextField field;

    public LoginController(Joueur joueur, JTextField field){
        this.joueur = joueur;
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.joueur.setLogin(field.getText());
        this.joueur.setMessage("Je me connecte...");
        this.joueur.sendLogin();
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
