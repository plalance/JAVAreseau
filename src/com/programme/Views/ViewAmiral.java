package com.programme.Views;

import com.programme.Beans.GridCase;

import javax.swing.*;
import java.awt.*;

/**
 * Created by corentin on 07/06/2017.
 */

public class ViewAmiral extends JFrame {
    JPanel panel = new JPanel();
    JPanel grilleDef = new JPanel();
    GridCase buttons[] = new GridCase[100];

    public ViewAmiral(){

        this.setTitle("VueAmiral");
        this.setSize(1600, 900);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Object[] bateau = {
                "truc",
                "machin",
                "muche"
        };

        Object[][] data = {
                {"riri", new JComboBox(new String[]{"attaquant", "défenseur"}),new JComboBox(bateau)},
                {"fifi", new JComboBox(new String[]{"attaquant", "défenseur"}),new JComboBox(bateau)},
                {"loulou", new JComboBox(new String[]{"attaquant", "défenseur"}),new JComboBox(bateau)},
                {"donald", new JComboBox(new String[]{"attaquant", "défenseur"}),new JComboBox(bateau)}
        };

        String  title[] = {"Pseudo", "fonction","affectation"};
        JTable tableau = new JTable(data, title);




        grilleDef.setLayout(new GridLayout(10, 10));
        grilleDef.setSize(400, 400);
        grilleDef.setLocation(this.getWidth()/2-600,(this.getHeight()/2)-200);

        for (int line = 1; line < 11; line++) {
            for (int col = 1; col < 11; col++) {
                buttons[line*col-1] = new GridCase();
                buttons[line*col-1].setPositionY(line);
                buttons[line*col-1].setPositionX(col);
                grilleDef.add(buttons[line*col-1]);
            }
        }



        this.add(new JScrollPane(tableau), BorderLayout.EAST);
        this.add(grilleDef);
        this.add(panel);
        this.setVisible(true);

    }
}
