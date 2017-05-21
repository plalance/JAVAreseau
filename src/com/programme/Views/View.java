package com.programme.Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mol on 21/05/2017.
 */
public class View {
    JFrame frame;
    JTextField field;
    JButton button;

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getField() {
        return field;
    }

    public JButton getButton() {
        return button;
    }

    public void init(){
        frame = new JFrame("Vue");
        field = new JTextField();
        field.setColumns(10);
        button = new JButton("Envoyer");

        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(field);
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);
        frame.pack();
    }
}
