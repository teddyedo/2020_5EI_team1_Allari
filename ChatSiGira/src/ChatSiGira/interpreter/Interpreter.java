/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import ChatSiGira.pacchettipackage.*;
import ChatSiGira.functions.UserInfo;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Jonathan Pollinari
 * @author Abreham Bologna
 * @author Allari Edoardo
 *
 */
public class Interpreter {

    ArrayList<Packet> packetList = new ArrayList<>();

    /**
     * This method received a byte array that represent a packet and, according
     * to his first byte (opCode), translate this byte array into a specific
     * packet class
     *
     * @param data byte array received in input.
     * @return a specific packet class.
     */
    public Packet interpret(byte[] data) {
        byte opCode = data[0];

        switch (opCode) {

            case 01:                        //message user to user
                return utuDPacketFromBytes(data);

            case 05:
                return utcDPacketFromBytes(data);

            case 11:                        //disconnection
                return disconnectionServerPacketFromBytes(data);

            case 20:                        //registrationAck
                return createRegistrationAckFromBytes(data);

            case 51:                        //group user list 
                return groupUsersListPacketFromBytes(data);

            case (byte) 255:
                return errorPacketToBytes(data);
        }
        return null;
    }

    /**
     * This method convert a byte array into a registrationAck packet.
     *
     * @param data a byte array received in input that represent a packet.
     * @return a registrationAck packet.
     */
    private RegistrationAckPacket createRegistrationAckFromBytes(byte[] data) {

        int start = 1;
        RegistrationAckPacket registration = new RegistrationAckPacket(null, null);

        ArrayList<byte[]> variableElements = new ArrayList<>();

        //get the personal ID - 2 bytes long
        variableElements.add(Arrays.copyOfRange(data, start, 3));

        start = 3;

        for (int i = 3; i < data.length; i++) {
            if (data[i] == 0) //get the alias sended before
            {
                variableElements.add(Arrays.copyOfRange(data, start, i));
            }
        }

        byte[] myID = variableElements.get(0);
        String alias = new String(variableElements.get(1));

        registration.setAliasConfirmation(alias);
        registration.setAssignedId(myID);

        return registration;
    }

    /**
     * This method convert a byte array into a disconnectionServer packet.
     *
     * @param data a byte array received in input that represent a packet.
     * @return a disconnectionServer packet.
     */
    private DisconnectionServerPacket disconnectionServerPacketFromBytes(byte[] data) {

        //get the reason of the disconnection
        byte reason = data[1];

        //create disconnection packet
        DisconnectionServerPacket disconnectionServer = new DisconnectionServerPacket(reason);

        return disconnectionServer;
    }

    /**
     * This method convert a byte array into a error packet.
     *
     * @param data a byte array received in input that represent a packet.
     * @return an errorPacket.
     */
    private ErrorPacket errorPacketToBytes(byte[] data) {

        ErrorPacket errorPacket = new ErrorPacket(null);

        //get the error 
        byte error = data[1];

        //set the error
        errorPacket.setErrorCode(UserInfo.ErrorCode.getErrorCodeFromByte(error));

        return errorPacket;
    }

    /**
     * This method convert a byte array into a groupUserList packet.
     *
     * @param data a byte array received in input that represent a packet.
     * @return a groupUserList packet.
     */
    private GroupUsersListPacket groupUsersListPacketFromBytes(byte[] data) {

        byte type = data[1];

        byte listLength = data[2];

        byte[] jsonByte = Arrays.copyOfRange(data, 3, data.length);

        String jsonString = new String(jsonByte, StandardCharsets.ISO_8859_1);

        GroupUsersListPacket groupUsersListPacket = new GroupUsersListPacket(type, listLength, jsonString);

        return groupUsersListPacket;
    }

    /**
     * This method convert a byte array into a utuDPacket.
     *
     * @param data a byte array received in input that represent a packet.
     * @return a utuDPacket.
     */
    private UtuDPacket utuDPacketFromBytes(byte[] data) {

        int length = 0;

        for (int i = 1; i < data.length; i++) {
            if (data[i] == 0 && data[i - 1] == 0) {
                length = i;
                break;
            }
        }

        data = Arrays.copyOfRange(data, 0, length);

        if (data.length > 2048) {
            throw new UnsupportedOperationException();
        }

        UtuDPacket utuDPacket = new UtuDPacket(null, null);

        ArrayList<byte[]> variableElements = new ArrayList<>();

        int start = 1;

        for (int i = 1; i < data.length; i++) {
            if (data[i] == 0) {
                variableElements.add(Arrays.copyOfRange(data, start, i));
                start = i + 1;

            }
        }

        String sourceAlias = new String(variableElements.get(0), StandardCharsets.ISO_8859_1);
        String message = new String(variableElements.get(1), StandardCharsets.ISO_8859_1);

        utuDPacket.setMessage(message);
        utuDPacket.setSourceAlias(sourceAlias);

        boolean added = false;

        for (Packet p : packetList) {
            if (p.getClass().isInstance(utuDPacket)) {
                UtuDPacket u = (UtuDPacket) p;
                if (u.getSourceAlias().equals(utuDPacket.getSourceAlias())) {
                    u.setMessage(u.getMessage() + message);
                    added = true;
                    if (data.length < 2048) {
                        packetList.remove(u);
                        return u;
                    }
                }
            }
        }

        if (data.length == 2048 && added == false) {
            packetList.add(utuDPacket);
        } else if (data.length < 2048) {
            return utuDPacket;
        }
        return null;
    }

    /**
     * This method convert a byte array into a utcDPacket.
     *
     * @param data a byte array received in input that represent a packet.
     * @return a utcDPacket.
     */
    private UtcDPacket utcDPacketFromBytes(byte[] data) {

        int length = 0;

        for (int i = 1; i < data.length; i++) {
            if (data[i] == 0 && data[i - 1] == 0) {
                length = i;
                break;
            }
        }

        data = Arrays.copyOfRange(data, 0, length);

        UtcDPacket utcDPacket = new UtcDPacket(null, null);

        ArrayList<byte[]> variableElements = new ArrayList<>();

        int start = 1;

        for (int i = 1; i < data.length; i++) {
            if (data[i] == 0) {
                variableElements.add(Arrays.copyOfRange(data, start, i));
                start = i + 1;
            }
        }

        String sourceAlias = new String(variableElements.get(0));
        String message = new String(variableElements.get(1));

        utcDPacket.setMessage(message);
        utcDPacket.setSourceAlias(sourceAlias);

        boolean added = false;

        for (Packet p : packetList) {
            if (p.getClass().isInstance(utcDPacket)) {
                UtcDPacket u = (UtcDPacket) p;
                if (u.getSourceAlias() == utcDPacket.getSourceAlias()) {
                    u.setMessage(u.getMessage() + message);
                    added = true;
                    if (data.length < 2048) {
                        packetList.remove(u);
                        return u;
                    }
                }
            }
        }

        if (data.length == 2048 && added == false) {
            packetList.add(utcDPacket);
        } else if (data.length < 2048) {
            return utcDPacket;
        }
        return null;

    }

}
