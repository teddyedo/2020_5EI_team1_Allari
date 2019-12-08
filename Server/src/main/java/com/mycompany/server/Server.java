/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import PCP.services.PCPServer;
import java.io.IOException;
import java.net.InetAddress;

/**
 *
 * @author Allari Edoardo
 *
 */
public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        InetAddress address = InetAddress.getByName("127.0.0.1");
        PCPServer server = new PCPServer(address);
        server.acceptAndServe();
    }
}
