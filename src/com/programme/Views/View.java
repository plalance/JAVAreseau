package com.programme.Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mol on 21/05/2017.
 */
public class View {
    JFrame frame;
    JTextField field;
    JTextField loginField;
    JButton button;
    JButton loginButton;
    JButton buttonDeconnexion;

    public JButton getButtonDeconnexion() {
        return buttonDeconnexion;
    }

    public JFrame getFrame() {
        return frame;
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

    public void init(){
        frame = new JFrame("Vue");
        field = new JTextField();
        field.setColumns(10);
        loginField = new JTextField();
        loginField.setColumns(10);
        button = new JButton("Envoyer");
        loginButton = new JButton("Envoyer mon login");
        buttonDeconnexion = new JButton("Se déconnecter");

        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(loginField);
        frame.getContentPane().add(loginButton);
        frame.getContentPane().add(field);
        frame.getContentPane().add(button);
        frame.getContentPane().add(buttonDeconnexion);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);
        frame.pack();
    }
}
