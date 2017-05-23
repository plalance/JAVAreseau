package com.programme.Beans;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Mol on 23/05/2017.
 */
public class Server {
    protected Integer port;



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
                new Handler(serverSocket.accept()).start();
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
}
