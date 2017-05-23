package com.programme.Beans;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Mol on 23/05/2017.
 */
public class Server {
    private Integer port;
    private Integer nbJoueurs = 0;
    private Integer nbAmirals = 0;

    public Server(Integer port){
        this.port = port;
    }

    public void serverStart(){
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("-----SERVER READY-----");
            boolean estActif = true;


            // boucle sur les connexions et demarrage d'un Thread
            while(estActif){
                ServGuest serv;
                switch(this.nbJoueurs){
                    case 0:
                        new ServGuest(serverSocket.accept()).start();
                        this.nbJoueurs++;
                        break;

                    case 1:
                        // Demande d'équipe
                        serv = new ServGuest(serverSocket.accept());
                        serv.start();
                        serv.excludeGamer();

//                        this.nbJoueurs++;
                        break;

                    default:
                        // Demande d'équipe que matelos
                        new ServGuest(serverSocket.accept()).start();
                        this.nbJoueurs++;
                        break;
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
}
