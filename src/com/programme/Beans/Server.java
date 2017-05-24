package com.programme.Beans;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * Created by Mol on 23/05/2017.
 */
public class Server {
    private Integer port;
    private Integer nbJoueurs = 0;
    private Integer nbAmirals = 0;
    private Vector<Socket> socketsClient;

    static Server server;


    public Server(Integer port){
        this.port = port;
    }

    public void serverStart(){
        ServerSocket serverSocket;
        socketsClient = new Vector<>();
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("-----SERVER READY-----");
            boolean estActif = true;


            // boucle sur les connexions et demarrage d'un Thread
            while(estActif){
                ServGuest servGuest;
                Socket socketClient;
                Joueur joueur;

                switch(this.nbJoueurs){
                    case 0:
                        socketClient = serverSocket.accept();
                        joueur = new Joueur();
                        joueur.setSocketRemoteAdress(socketClient.getRemoteSocketAddress().toString());

                        servGuest = new ServGuest(socketClient);
                        servGuest.setJoueur(joueur);
                        servGuest.start();

                        this.socketsClient.add(socketClient);
                        System.out.println("Nouveau Client, adresse :"+joueur.getSocketRemoteAdress());
                        this.nbJoueurs++;
                        break;
//
//                    case 1:
//                        // Demande d'équipe
//                        serv = new ServGuest(serverSocket.accept());
//                        serv.start();
//                        serv.excludeGamer();
//
////                        this.nbJoueurs++;
//                        break;

                    default:
                        // Demande d'équipe que matelos
                        socketClient = serverSocket.accept();
                        new ServGuest(socketClient).start();
                        this.socketsClient.add(socketClient);
                        System.out.println("Nouveau Client :"+socketClient.getRemoteSocketAddress());
                        this.nbJoueurs++;
                }
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    
    public Integer getPort() {
        return port;
    }
    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getNbJoueurs() {
        return nbJoueurs;
    }
    public void setNbJoueurs(Integer nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }

    public Integer getNbAmirals() {
        return nbAmirals;
    }
    public void setNbAmirals(Integer nbAmirals) {
        this.nbAmirals = nbAmirals;
    }

    public Vector<Socket> getSocketsClient() {
        return socketsClient;
    }

    public void removeFromVector(Socket socketaretirer){
        this.socketsClient.remove(socketaretirer);
    }


}
