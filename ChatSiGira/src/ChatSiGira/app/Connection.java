/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import ChatSiGira.interpreter.Interpreter;
import ChatSiGira.graphicinterface.*;
import ChatSiGira.functions.Reader;

/**
 *
 * @author Allari Edoardo
 *
 *
 */
public class Connection {

    public static Socket client;
    
    public static Reader reader;

    public static LoginInterface loginInterface = new LoginInterface();
    public static MainInterface mainInterface = new MainInterface();

    public static DataInputStream is;
    public static DataOutputStream os;

    public static Interpreter interpreter = new Interpreter();

    public static void main(String[] args) throws IOException, InterruptedException {

        client = new Socket("127.0.0.1", 53101);
        is = new DataInputStream(client.getInputStream());
        os = new DataOutputStream(client.getOutputStream());
        loginInterface.setVisible(true);

  

        reader = new Reader();
    }

}
