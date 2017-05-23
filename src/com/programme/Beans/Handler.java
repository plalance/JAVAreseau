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
public class Handler extends Thread {
    private final Socket socket;
    private PrintWriter reponse;

    public Handler(Socket socket) { //constructeur
        super();
        this.socket = socket;
    }

    public void run() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                PrintWriter writer = new PrintWriter(this.socket.getOutputStream());
                writer.println("SERVEUR : Vous avez envoyé :"+line);
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Connexion terminée !");
    }
}
