package com.programme.Beans;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Joueur{

    private String message;
    private Socket socket;

    public void createSocket() {

        try {
            socket = new Socket("192.168.1.47", 6969);
            socket.setKeepAlive(true);
            // simulation d'attente
//            socket.setKeepAlive(true);
            this.setSocket(socket);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void deconnexion(){
//        try {
//            socket.close();
//            System.out.print("Je suis déconnecté...");
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void setMessage(String message) {
        this.message = message;
        System.out.println("Message a envoyer :"+message);
    }
    public String getMessage() {
        return message;
    }

    public void causer(String message){
        try {
            PrintWriter writer = new PrintWriter(this.getSocket().getOutputStream());
            writer.print(message+"\n");
            writer.flush();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deconnexion(){
        try {
            this.getSocket().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
