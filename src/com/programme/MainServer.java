package com.programme;

import com.programme.Beans.Handler;
import com.programme.Beans.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class MainServer {

    public static void main(String[] args){
        Server server = new Server(6969);
        server.serverStart();
    }
}
