package com.programme;

import com.programme.Beans.Server;

public class MainServer {

    public static void main(String[] args){
        Server server = new Server(6969);
        server.serverStart();
    }
}
