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
import com.google.gson.Gson;
import java.util.ArrayList;

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

        client = new Socket("127.0.0.1", 53101);

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

    public static void changeAlias(String newAlias) throws IOException {

        ChangeOfAliasPacket c = new ChangeOfAliasPacket(UserInfo.ID, UserInfo.alias, newAlias);

        os.write(c.toBytes());

        System.out.println("Sended alias change packet");

    }

    public static void disconnection() throws IOException {

        DisconnectionClientPacket dscPkt = new DisconnectionClientPacket(UserInfo.ID);

        os.write(dscPkt.toBytes());

        System.out.println("Sended disconnection request");
    }

    public static void requestUserList() throws IOException {

        GroupUsersListRequestPacket g = new GroupUsersListRequestPacket(UserInfo.ID);

        os.write(g.toBytes());

        System.out.println("Sended list request");

    }

    public static void sendedPrivateMex(String message, String dstAlias) throws IOException {

        UtuPacket u = new UtuPacket(UserInfo.ID, dstAlias, message);

        os.write(u.toBytes());

        System.out.println("Sended private message");
    }

    public static void sendedTopicMex(String message) throws IOException {

        UtCPacket u = new UtCPacket(UserInfo.ID, message);

        os.write(u.toBytes());

        System.out.println("Sended public message");
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
                serverDisconnection(p);
                break;
            case 20:
                System.out.println("Registrazione avvenuta");
                registrationOccured(p);
                break;
            case 51:
                System.out.println("aggiornare lista");
                userListReceived(p);
                break;
            case 255:
                System.out.println("pacchetto di errore");
                errorPacketReceived(p);
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

    }

    public static void userListReceived(Packet p) {

        //creation userList packet
        GroupUsersListPacket gUsrLst = (GroupUsersListPacket) p;

        Gson json = new Gson();
        ArrayList<String> userList = json.fromJson(gUsrLst.getJsonContent(), ArrayList.class);

        switch (gUsrLst.getType()) {

            case 0:
                UserInfo.chatUserList.clear();
                UserInfo.chatUserList = userList;
                break;
            case 1:
                UserInfo.chatUserList.add(userList.get(0));
                break;
            case 2:
                UserInfo.chatUserList.remove(userList.get(0));
                break;
        }
    }

    public static void errorPacketReceived(Packet p) {

        //creation ErrorPacket 
        ErrorPacket errPkt = (ErrorPacket) p;

        System.out.println(errPkt.getErrorCode().name());
    }

    
    public static void serverDisconnection(Packet p) {

        //creation disconnection server packet
        DisconnectionServerPacket dscPkt = (DisconnectionServerPacket) p;

        switch (dscPkt.getReason()) {

            case 0:
                System.out.println("YOU ARE DISCONNECTED FROM SERVER FOR NO REASON");
                break;
            case 1:
                System.out.println("Disconnected for inactivity");
                break;
            case 2:
                System.out.println("Server gone offline");
                break;

        }

    }
    
    public static void userMessageReceived(Packet p){
        
        //creation utuDPacket 
        UtuDPacket u = (UtuDPacket) p;
        
        System.out.println(u.getSourceAlias() + ": " + u.getMessage());
    }
    
    
    public static void topicMessageReceived(Packet p){
        
        //creation utcDPacket
        UtcDPacket u = (UtcDPacket) p;
        
        System.out.println(u.getSourceAlias() + ": " + u.getMessage());
    }
    
}
