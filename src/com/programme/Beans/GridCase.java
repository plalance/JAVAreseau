package com.programme.Beans;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created by Mol on 01/06/2017.
 */
public class GridCase extends JButton implements ActionListener{
    ImageIcon water,boat,hit;
    byte value=0;
    int positionX;
    int positionY;
    /*
    0 = water
    1 = bateau
    2 = touché
    */

    public GridCase(){
        water = new ImageIcon(this.getClass().getResource("/Assets/water.png"));
        boat = new ImageIcon(this.getClass().getResource("/Assets/boat.png"));
        hit = new ImageIcon(this.getClass().getResource("/Assets/hit.png"));

        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("Je suis une case et voila ma position : Ligne "+this.positionY+", Colonne "+this.positionX);

        value++;
        // If more than 3.. --> go back to zero
        value%=3;
        switch (value){
            case 0:
                setIcon(water);
                break;
            case 1:
                setIcon(boat);
                break;
            case 2:
                setIcon(hit);
                break;
        }
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
