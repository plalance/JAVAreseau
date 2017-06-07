package com.programme.Views;

import com.programme.Beans.GridCase;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;

/**
 * Created by Mol on 01/06/2017.
 */
public class GridView extends JFrame {
    JPanel p = new JPanel();
    JPanel underPanel = new JPanel();
    GridCase buttons[] = new GridCase[100];

    JTextField field;
    JTextField loginField;
    JButton button;
    JButton loginButton;
    JButton buttonDeconnexion;

    public GridView() {
        super("Grille de jeu");
    }

    public void init() {
        setSize(800, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));

        p.setLayout(new GridLayout(10, 10));
        for (int line = 1; line < 11; line++) {
            for (int col = 1; col < 11; col++) {
                buttons[line*col-1] = new GridCase();
                buttons[line*col-1].setPositionY(line);
                buttons[line*col-1].setPositionX(col);
                p.add(buttons[line*col-1]);
            }
        }
        add(p);


        underPanel.setLayout(new GridLayout(5,2));
        field = new JTextField();
        field.setColumns(10);
        loginField = new JTextField();
        loginField.setColumns(10);
        button = new JButton("Envoyer");
        loginButton = new JButton("Envoyer mon login");
        buttonDeconnexion = new JButton("Se déconnecter");

        underPanel.add(loginField);
        underPanel.add(loginButton);
        underPanel.add(field);
        underPanel.add(button);
        underPanel.add(buttonDeconnexion);
        add(underPanel);
        setVisible(true);
    }


    public JButton getButtonDeconnexion() {
        return buttonDeconnexion;
    }

    public JTextField getField() {
        return field;
    }

    public JButton getButton() {
        return button;
    }

    public JTextField getLoginField() {
        return loginField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}
