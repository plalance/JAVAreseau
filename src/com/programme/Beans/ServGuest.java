package com.programme.Beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

/**
 * Created by Thibault on 12/04/2017.
 */
public class ServGuest extends Thread {
    private final Socket socket;
    private PrintWriter reponse;
    private Joueur joueur;
    private Boolean etat;
    private Server server;

    public ServGuest(Socket socket, Server server) { //constructeur
        super();
        this.socket = socket;
        this.server = server;
    }

    public void run() {
        this.etat = true;
        BufferedReader reader;
        while(this.etat){
            try {
                reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    if(line.equals("deco")){
                        this.server.removeFromVector(this.joueur.getSocketRemoteAdress());
//                        disconnectRequest();
//                        System.out.println(this.server.getPort());
//                        System.out.println(this.getJoueur().getSocketRemoteAdress());
                        this.etat = false;
                    }else {
                        System.out.println(line);
                        PrintWriter writer = new PrintWriter(this.socket.getOutputStream());
                        writer.println("SERVEUR : Vous avez envoyé :"+line);
                        writer.flush();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Connexion terminée !");
    }

    public void excludeGamer() throws IOException {
        socket.close();
    }

    public Joueur getJoueur() {
        return joueur;
    }
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
//
//    public void disconnectRequest(){
//        this.server.removeFromVector(this.joueur.getSocket());
//    }


}
