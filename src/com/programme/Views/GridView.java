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
    GridCase buttons[] = new GridCase[100];

    public GridView() {
        super("Grille de jeu");
    }

    public void init() {
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

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
        setVisible(true);
    }
}
