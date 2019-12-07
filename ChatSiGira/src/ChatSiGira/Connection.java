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

    protected static Interpreter interpreter = new Interpreter();

    public static void main(String[] args) throws IOException, InterruptedException {

        client = new Socket("172.16.7.141", 53101);

        is = new DataInputStream(client.getInputStream());
        os = new DataOutputStream(client.getOutputStream());

        registration();
        Reader reader = new Reader();
    }

    
    public static void registration() throws IOException {

        String alias = "GinoGino";
        String topic = "general";

        RegistrationPacket r = new RegistrationPacket(alias, topic);

        os.write(r.toBytes());

        System.out.println("Sended new Registration Packet");

    }
    

    public static byte[] read() throws IOException {

        byte[] buffer = new byte[2048];

        is.read(buffer);

        return buffer;
    }

    
    public static void whatToDo(Packet p) throws IOException {

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
                registrationOccured(p);
                break;
            case 51:
                System.out.println("aggiornare lista");
                break;
            case 255:
                System.out.println("pacchetto di errore");
                break;
        }

    }

    public static void registrationOccured(Packet p) throws IOException {
        
        //creation regAck packet
        RegistrationHackPacket regAck = (RegistrationHackPacket) p;
        
        //alias verification
        if (!regAck.getAliasConfirmation().equals("GinoGino")) {
            registration();
        }
        
        //set my ID
        UserInfo.ID = regAck.getAssignedId();
        
        //request userList
        GroupUsersListRequestPacket g = new GroupUsersListRequestPacket(UserInfo.ID);
        os.write(g.toBytes());
        
        System.out.println("Richiesta lista inviata");
    }

}
