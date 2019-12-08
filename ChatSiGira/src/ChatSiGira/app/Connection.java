/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.app;

import ChatSiGira.functions.UserInfo;
import ChatSiGira.functions.Reader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import ChatSiGira.functions.Actions;
import ChatSiGira.interpreter.Interpreter;

/**
 *
 * @author Allari Edoardo supported by Jonathan Pollinari
 *
 *
 */
public class Connection {

    protected static Socket client;

    public static DataInputStream is;
    public static DataOutputStream os;

    public static Interpreter interpreter = new Interpreter();

    public static void main(String[] args) throws IOException, InterruptedException {

        client = new Socket("127.0.0.1", 53101);

        is = new DataInputStream(client.getInputStream());
        os = new DataOutputStream(client.getOutputStream());

        Actions.registration(UserInfo.alias);
        Reader reader = new Reader();
    }

}
