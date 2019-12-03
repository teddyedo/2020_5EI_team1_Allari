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
    
        protected static Socket client;

        protected static DataInputStream is; 
        protected static DataOutputStream os;
        
        protected static ReadClass reader;
        protected static InterpretClass interpreter;
        
        protected static Interpreter i = new Interpreter();
 
        public static void main(String[] args) throws IOException, InterruptedException {
       
            client = new Socket("127.0.0.1", 53101);
        
            is = new DataInputStream(client.getInputStream());
            os = new DataOutputStream(client.getOutputStream());

        
        
       
        
        System.out.println("Ho Scritto");
        
        Thread.sleep(3);
        
        int len = is.readInt();
        
        System.out.println(len);
        
        byte[] data = new byte[len];
        
        is.read(data);
        
    
        
        
        
    }
    
    public void registration() throws IOException{
        
        
        String alias = "GinoGino";
        String topic = null;      
        
        RegistrationPacket r = new RegistrationPacket(alias, topic);
      
        
        os.write(r.toBytes());
    }
    
    public static byte[] read() throws IOException{
        
        byte[] buffer = new byte[2048];
        
        is.read(buffer);
        
        return buffer;
    }
    
    public static void interpret(Packet p){
        
        switch(p){
            
            case RegistrationHackPacket:
                 System.out.println("Ciao");
            case UtuDPacket:
                 System.out.println("Gino");
            
            
        }
        
    }
    
    
    
    
}
