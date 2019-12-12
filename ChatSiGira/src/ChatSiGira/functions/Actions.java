/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.functions;

import ChatSiGira.pacchettipackage.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import ChatSiGira.app.Connection;
import static ChatSiGira.functions.UserInfo.chatRoomList;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import ChatSiGira.graphicinterface.ChatInterface;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;
import java.util.List;

/**
 *
 * @author Allari Edoardo
 *
 */
public class Actions {

    /**
     * Constructor.
     */
    public Actions() {
    }

    /**
     * This method is used to perform loginInterface to the server.
     *
     * @param alias the name choosen by the user logged in.
     * @throws IOException Exception
     */
    public static void registration(String alias) throws IOException {

        UserInfo.alias = alias;

        String topic = "general";

        RegistrationPacket r = new RegistrationPacket(alias, topic);

        Connection.os.write(r.toBytes());
        
        System.out.println("Sended registration request ");

    }

    /**
     * This method is used to change our alias.
     *
     * @param newAlias the new name choosen by the user.
     * @throws IOException Exception
     */
    public static void changeAlias(String newAlias) throws IOException {

        if (UserInfo.chatUserList.contains(newAlias) || newAlias.length() < 6
                || newAlias.length() > 32) {
            Connection.mainInterface.invalidAlias();
        } else {
            ChangeOfAliasPacket c = new ChangeOfAliasPacket(newAlias);

            Connection.os.write(c.toBytes());

            System.out.println("Sended alias change packet");

            Connection.mainInterface.setUsername(newAlias);

            UserInfo.alias = newAlias;
        }

    }

    /**
     * This method is used to disconnect our user from the server.
     *
     * @throws IOException Exception
     */
    public static void disconnection() throws IOException {

        DisconnectionClientPacket dscPkt = new DisconnectionClientPacket(UserInfo.ID);

        Connection.os.write(dscPkt.toBytes());

        System.out.println("Sended disconnection request");

        Connection.mainInterface.setVisible(false);

        UserInfo.userOnline = false;
        Connection.client.close();

        System.exit(0);

    }

    /**
     * This method is used to request the list of the user "online".
     *
     * @throws IOException Exception
     */
    public static void requestUserList() throws IOException {

        GroupUsersListRequestPacket g = new GroupUsersListRequestPacket(UserInfo.ID);

        Connection.os.write(g.toBytes());

        System.out.println("Sended list request");

    }

    /**
     * This method is used to send private message to another user.
     *
     * @param message the content of the message.
     * @param dstAlias the name of the addressee.
     * @throws IOException Exception
     */
    public static void sendedPrivateMex(String message, String dstAlias) throws IOException {

        UtuPacket u = new UtuPacket(UserInfo.ID, dstAlias, message);

        Connection.os.write(u.toBytes());

        System.out.println("Sended private message");

        for (ChatRoom c : chatRoomList) {
            if (c.getAlias().equals(dstAlias)) {
                c.getChatInterface().updateMessageLabel(message, UserInfo.alias);
            }
        }
    }

    /**
     * This method is used to send a topic message to a group of users.
     *
     * @param message the content of the message.
     * @throws IOException Exception
     */
    public static void sendedTopicMex(String message) throws IOException {

        UtCPacket u = new UtCPacket(UserInfo.ID, message);
        System.out.println(u.size());

        Connection.os.write(u.toBytes());

        System.out.println("Sended public message");

        Connection.mainInterface.updateMessageLabel(message, UserInfo.alias);
    }

    /**
     * This method is used to read on the inputStream.
     *
     * @return a byte array from the server.
     * @throws IOException Exception
     */
    public static byte[] read() throws IOException {

        byte[] buffer = new byte[2048];

        Connection.is.read(buffer);

        return buffer;
    }

    /**
     * This method is used to sort every packet received to its specifical
     * action.
     *
     * @param p packet received.
     * @throws IOException Exception
     */
    public static void whatToDo(Packet p) throws IOException {

        switch (p.getOpCode()) {

            case 01:
                System.out.println("User message received");
                userMessageReceived(p);
                break;
            case 05:
                System.out.println("group message received");
                topicMessageReceived(p);
                break;
            case 11:
                System.out.println("Server disconnection");
                serverDisconnection(p);
                break;
            case 20:
                System.out.println("Registration occured");
                registrationOccured(p);
                break;
            case 51:
                System.out.println("UserList update");
                userListReceived(p);
                break;
            case 255:
                System.out.println("Error packet");
                errorPacketReceived(p);
                break;
        }

    }

    /**
     * This method is used to confirm the registration and set our unique ID.
     *
     * @param p packet sorted by whatToDo method.
     * @throws IOException Exception
     */
    public static void registrationOccured(Packet p) throws IOException {

        //creation regAck packet
        RegistrationAckPacket regAck = (RegistrationAckPacket) p;

        //alias verification
        if (!regAck.getAliasConfirmation().equals(UserInfo.alias)) {
            registration(UserInfo.alias);
        }

        //set my ID
        UserInfo.ID = regAck.getAssignedId();

        Connection.loginInterface.setVisible(false);
        Connection.mainInterface.setVisible(true);
        Connection.mainInterface.setUsername(UserInfo.alias);

    }

    /**
     * This method is used to set or update the list of the online users.
     *
     * @param p packet sorted by whatToDo method.
     */
    public static void userListReceived(Packet p) {

        //creation userList packet
        GroupUsersListPacket gUsrLst = (GroupUsersListPacket) p;

        Gson json = new Gson();

        JsonReader reader = new JsonReader(new StringReader(gUsrLst.getJsonContent()));
        reader.setLenient(true);

        Type userListType = new TypeToken<ArrayList<String>>() {
        }.getType();

        List<String> userList = new ArrayList<>();

        userList = json.fromJson(reader, userListType);

        System.out.println(userList.size());

        switch (gUsrLst.getType()) {

            case 0:
                UserInfo.chatUserList.clear();
                for (String s : userList) {
                    UserInfo.chatUserList.add(s);
                }
                break;
            case 1:
                UserInfo.chatUserList.add(userList.get(0));
                break;
            case 2:
                UserInfo.chatUserList.remove(userList.get(0));
                break;
            default:
                System.out.println("User list packet error!!");

        }

        Connection.mainInterface.updateUserList(UserInfo.chatUserList);

    }

    /**
     * This method is used to print out the error message received from the
     * server.
     *
     * @param p packet sorted by whatToDo method.
     */
    public static void errorPacketReceived(Packet p) {

        //creation ErrorPacket 
        ErrorPacket errPkt = (ErrorPacket) p;

        System.out.println(errPkt.getErrorCode().name());

        switch (errPkt.getErrorCode()) {

            case PackageMalformed:
                System.out.println("Package malformed was sent");
                break;

            case MaxClientsReached:
                Connection.loginInterface.setTextErrorLabel("Too much users connected!");
                System.out.println("Too much users connected!");
                break;

            case InvalidAlias:
                Connection.loginInterface.setTextErrorLabel("Your alias isn't valid!");
                System.out.println("Your alias isn't valid!");
                break;

            case AliasInUse:
                Connection.loginInterface.setTextErrorLabel("This alias is already in use!");
                System.out.println("This alias is already in use!");
                break;

            case ChatDenied:
                System.out.println("Access denied!");
                break;

            case InvalidRoomName:
                System.out.println("The room name selected isn't valid!");
                break;

            case ServerExploded:
                System.out.println("BOOOM!!");
                System.exit(0);
                break;

            case Unspecified:
                System.out.println("A fatal error was occured!");
                break;

            default:
                System.out.println("generical error");

        }

    }

    /**
     * This method is used to accept the disconnection from server and indicate
     * what is the cause of disconnection.
     *
     * @param p packet sorted by whatToDo method.
     * @throws java.io.IOException Exception
     */
    public static void serverDisconnection(Packet p) throws IOException {

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

        Connection.mainInterface.setVisible(false);

        UserInfo.userOnline = false;
        Connection.client.close();

        System.exit(0);
    }

    /**
     * This method is used to receive and print out a user message.
     *
     * @param p packet sorted by whatToDo method.
     */
    public static void userMessageReceived(Packet p) {

        //creation utuDPacket 
        UtuDPacket u = (UtuDPacket) p;

        System.out.println(u.getSourceAlias() + ": " + u.getMessage());

        Boolean chatExisting = false;

        for (ChatRoom c : chatRoomList) {
            if (c.getAlias().equals(u.getSourceAlias())) {
                chatExisting = true;
            }
        }

        if (chatExisting == false) {
            ChatInterface c = new ChatInterface();
            c.setTitle(u.getSourceAlias());
            c.setUsername(u.getSourceAlias());
            c.setVisible(true);
            ChatRoom chatRoom = new ChatRoom(u.getSourceAlias(), c);
            chatRoomList.add(chatRoom);
        }

        for (ChatRoom c : chatRoomList) {
            if (c.getAlias().equals(u.getSourceAlias())) {
                c.getChatInterface().setVisible(true);
                c.getChatInterface().updateMessageLabel(u.getMessage(), u.getSourceAlias());
            }
        }
    }

    /**
     * This method is used to receive and print out a topic message.
     *
     * @param p packet sorted by whatToDo method.
     */
    public static void topicMessageReceived(Packet p) {

        //creation utcDPacket
        UtcDPacket u = (UtcDPacket) p;

        System.out.println(u.getSourceAlias() + ": " + u.getMessage());

        Connection.mainInterface.updateMessageLabel(u.getMessage(), u.getSourceAlias());
    }

    /**
     * This method is used to open a private chatRoom interface when required.
     *
     * @param alias is the name of the user with which we are chatting.
     */
    public static void openPrivateChatRoom(String alias) {

        Boolean created = false;

        for (ChatRoom c : chatRoomList) {
            if (c.getAlias().equals(alias)) {
                System.out.println("A chatRoom with this user is just opened");
                c.getChatInterface().setVisible(true);
                created = true;
            }
        }

        if (!created) {
            ChatInterface c = new ChatInterface();
            c.setTitle(alias);
            c.setUsername(alias);
            c.setVisible(true);
            ChatRoom chatRoom = new ChatRoom(alias, c);
            chatRoomList.add(chatRoom);
        }
    }

    public static void closeChatRoom(String alias) {

        for (ChatRoom c : chatRoomList) {
            if (c.getAlias().equals(alias)) {
                c.getChatInterface().setVisible(false);
                break;
            }
        }
    }

}
