/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import ChatSiGira.pacchettipackage.*;
import ChatSiGira.interpreter.Interpreter;


/**
 *
 * @author Allari Edoardo supported by Jonathan Pollinari
 * 
 * 
 */

public class Connection {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        Socket client = new Socket("127.0.0.1", 53101);
        
        DataInputStream is = new DataInputStream(client.getInputStream());
        DataOutputStream os = new DataOutputStream(client.getOutputStream());
        
        String alias = "GinoGino";
        String topic = "BELLLOOOOOOO";
        
        Interpreter i = new Interpreter();
        
        RegistrationPacket r = new RegistrationPacket(alias, topic);
        
        os.write(r.toBytes());
        System.out.println("Ho Scritto");
        
        Thread.sleep(3);
        int len = is.readInt();
        
        System.out.println(len);

        
        byte[] data = new byte[len];
        
        is.readFully(data);
        
        
        Packet ra = i.interpret(data);
        System.out.println(ra.getClass());
    
        
        
        
    }
}
