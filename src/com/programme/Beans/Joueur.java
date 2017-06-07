package com.programme.Beans;

import org.json.simple.JSONObject;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Joueur{

    private String message;
    private Socket socket;
    private BufferedReader reponse;
    private String socketRemoteAdress;

    private String login;

    public void createSocket() {

        try {
            // IP Thibal Fever
            socket = new Socket("192.168.43.33", 6969);
            // Ip Thibal Maison
//            socket = new Socket("192.168.0.16", 6969);
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

    public void setMessage(String message) {
        this.message = message;
        System.out.println("Message a envoyer :"+message);
    }
    public String getMessage() {
        return message;
    }

    public void envoiPaquet(String action){
        try {
            JSONObject obj = new JSONObject();
            obj.put("action", action);
            obj.put("contenu", this.message);
            obj.put("login", this.login);
            StringWriter out = new StringWriter();
            obj.writeJSONString(out);
            String paquet = out.toString();
            System.out.println("Vous envoyez : "+paquet);

            PrintWriter writer = new PrintWriter(this.getSocket().getOutputStream());
            writer.println(paquet);
            writer.flush();

            this.reponse = new BufferedReader(
                    new InputStreamReader(this.getSocket().getInputStream()));
            System.out.println(this.reponse.readLine());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deconnexion(){
        try {
            envoiPaquet("deco");
            this.getSocket().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendLogin(){
        envoiPaquet("sendLogin");
    }

    public Socket getSocket() {
        return socket;
    }
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getSocketRemoteAdress() {
        return socketRemoteAdress;
    }
    public void setSocketRemoteAdress(String socketRemoteAdress) {
        this.socketRemoteAdress = socketRemoteAdress;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
}
