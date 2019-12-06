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

    protected static Interpreter i = new Interpreter();

    public static void main(String[] args) throws IOException, InterruptedException {

        client = new Socket("172.16.7.141", 53101);

        is = new DataInputStream(client.getInputStream());
        os = new DataOutputStream(client.getOutputStream());

        registration();
        ReadClass reader = new ReadClass();
    }

    public static void registration() throws IOException {

        String alias = "GinoGino";
        String topic = null;

        RegistrationPacket r = new RegistrationPacket(alias, topic);

        os.write(r.toBytes());

        System.out.println("Sended new Registration Packet");
        /*
        byte[] buffer = new byte[4 + alias.length()];
        
        is.read(buffer);
        
        System.out.println(new String(buffer));
        
        
        Packet p = i.interpret(buffer);
        
        RegistrationHackPacket regAck = (RegistrationHackPacket) p;
        if ( ! regAck.getAliasConfirmation().equals(alias)) {
            registration();
        }
        UserList.ID = regAck.getAssignedId();
                
         */
    }

    public static byte[] read() throws IOException {

        byte[] buffer = new byte[2048];

        is.read(buffer);

        return buffer;
    }

    public static void interpret(Packet p) throws IOException {

        switch (p.getOpCode()) {

            case 01:
                System.out.println("messaggio da utente");
                break;
            case 05:
                System.out.println("messaggio da chat");
                break;
            case 11:
                System.out.println("disconnessioneDaServer");
                break;
            case 20:
                System.out.println("Registrazione avvenuta");
                RegistrationHackPacket regAck = (RegistrationHackPacket) p;
                if (!regAck.getAliasConfirmation().equals("GinoGino")) {
                    registration();
                }
                UserList.ID = regAck.getAssignedId();
                break;
            case 51:
                System.out.println("aggiornare lista");
                break;
            case 255:
                System.out.println("pacchetto di errore");
                break;
        }

    }

}
