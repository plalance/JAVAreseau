package com.programme;

import com.programme.Beans.Handler;

import java.io.IOException;
import java.net.ServerSocket;

public class MainServer {

    public static void main(String[] args){
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(6969);
            System.out.println("ServeurMultiThread pret");
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

    public MainServer(){}

}
