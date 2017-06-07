package com.programme.Beans;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    private JSONObject json;

    public ServGuest(Socket socket, Server server) { //constructeur
        super();
        this.socket = socket;
        this.server = server;
    }

    @SuppressWarnings("Duplicates")
    public void run() {
        this.etat = true;
        BufferedReader reader;
        while(this.etat){
            try {
                reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    JSONParser jsonParser = new JSONParser();
                    JSONObject jsonObject = (JSONObject) jsonParser.parse(line);
                    json = jsonObject;
                    decode();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Connexion terminée !");
    }

    public void decode() throws IOException {
        String action = (String) json.get("action");
        System.out.println("L'action est " + action);
        switch (action){
            case "deco":
                decoJoueurAction();
                break;
            case "causer":
                afficherMsgAction();
                break;
            case "sendLogin":
                afficherLoginAction();
                break;
            case "fire":
                fireAction();
                break;
        }
    }

    private void decoJoueurAction(){
        this.server.removeFromVector(this.joueur.getSocketRemoteAdress());
        System.out.println(this.server.getPort());
        System.out.println(this.getJoueur().getSocketRemoteAdress());
        this.etat = false;
    }

    private void afficherMsgAction() throws IOException {
        String contenu = (String) json.get("contenu");
        System.out.println(contenu);
        PrintWriter writer = new PrintWriter(this.socket.getOutputStream());
        writer.println("SERVEUR : Vous avez envoyé :"+contenu);
        writer.flush();
    }

    private void afficherLoginAction() throws IOException {
        String login = (String) json.get("login");
        System.out.println("Le login est "+login+"\n");
        PrintWriter writer = new PrintWriter(this.socket.getOutputStream());
        writer.println("SERVEUR : Bienvenue :"+login);
        writer.flush();
    }
    private void fireAction() {
        String tir = (String) json.get("tir");
        System.out.println("Les coordonées de tir sont : "+tir+"\n");
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
