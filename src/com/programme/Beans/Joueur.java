package com.programme.Beans;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Joueur{

    private String message;
    private Socket sock;

    public void connexion() {
        try {
            this.sock = new Socket("192.168.1.47", 6969);
            // simulation d'attente
            PrintWriter writer = new PrintWriter(sock.getOutputStream());
            writer.print(message);
            writer.flush();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deconnexion(){
        try {
            sock.close();
            System.out.print("Je suis déconnecté...");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMessage(String message) {
        this.message = message;
        System.out.println("Message a envoyer :"+message);
    }
    public String getMessage() {
        return message;
    }
}
