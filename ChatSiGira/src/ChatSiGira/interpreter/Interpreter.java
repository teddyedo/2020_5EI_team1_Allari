/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import ChatSiGira.pacchettipackage.*;
import com.google.gson.*;
import ChatSiGira.UserInfo;

/**
 *
 * @author Jonathan Pollinari
 * @author Abreham Bologna
 * @author Allari Edoardo
 * 
 */

public class Interpreter {
    
    ArrayList<Packet> packetList = new ArrayList<>();
    

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

    private RegistrationHackPacket createRegistrationAckFromBytes(byte[] data) {
        
        int start = 1;
        RegistrationHackPacket registration = new RegistrationHackPacket(null, null);
        
        ArrayList<byte[]> variableElements = new ArrayList<>();
        
        //get the personal ID - 2 bytes long
        variableElements.add( Arrays.copyOfRange( data, start, 3));
        
        start = 3;
        
        for (int i = 3; i < data.length; i++){
            if(data[i] == 0)
                
                //get the alias sended before
                variableElements.add( Arrays.copyOfRange( data, start, i));
        }
        
            byte[] myID = variableElements.get(0);
            String alias = new String( variableElements.get(1));
        
            registration.setAliasConfirmation(alias);
            registration.setAssignedId(myID);
        
            return registration;     
        }
        
    
    
    private DisconnectionServerPacket disconnectionServerPacketFromBytes(byte[] data) {
        
       
       //get the reason of the disconnection
       byte reason = data[1];
       
       //create disconnection packet
       
       DisconnectionServerPacket disconnectionServer = new DisconnectionServerPacket(reason);

       return disconnectionServer;
    }
    
    
    
    private ErrorPacket errorPacketToBytes(byte[] data){
        
        ErrorPacket errorPacket = new ErrorPacket(null);
        
        //get the error 
        byte error = data[1];
        
        //set the error
        errorPacket.setErrorCode(UserInfo.ErrorCode.getErrorCodeFromByte(error));
        
        return errorPacket;
    }
    
    private GroupUsersListPacket groupUsersListPacketFromBytes(byte[] data){
        
        byte type = data[1];
       
        byte listLength = data[2];
        
        byte[] jsonByte = Arrays.copyOfRange(data, 3, data.length);
        
        String jsonString = new String(jsonByte);
        
        GroupUsersListPacket groupUsersListPacket = new GroupUsersListPacket
        (type, listLength, jsonString);
        
        return groupUsersListPacket;
    }
    
    

    private UtuDPacket utuDPacketFromBytes(byte[] data){
        
        if(data.length > 2048)
            throw new UnsupportedOperationException();
        
        UtuDPacket utuDPacket = new UtuDPacket(null, null);
        
        ArrayList<byte[]> variableElements = new ArrayList<>();

        int start = 1;
        
        for(int i = 1; i < data.length; i++){
            if(data[i] == 0){
                variableElements.add( Arrays.copyOfRange( data, start, i));
                start = i + 1;
            }
        }
        
        //message
        variableElements.add( Arrays.copyOfRange( data, start, data.length -1));
       
        
        String sourceAlias = new String(variableElements.get(0));
        String message = new String(variableElements.get(1));
        
        utuDPacket.setMessage(message);
        utuDPacket.setSourceAlias(sourceAlias);
        
        boolean added = false;
        
        for (Packet p : packetList){
            if(p.getClass().isInstance(utuDPacket)){
                UtuDPacket u = (UtuDPacket) p;
                if(u.getSourceAlias() == utuDPacket.getSourceAlias()){
                    u.setMessage(u.getMessage() + message);
                    added = true;
                    if(data.length < 2048){
                        packetList.remove(u);
                        return u;          
                    }
                }
            }        
        }    
        
        if(data.length == 2048 && added == false)
              packetList.add(utuDPacket);
        
        else if (data.length < 2048){
            return utuDPacket;
        }
        return null;
    }
    
    
    private UtcDPacket utcDPacketFromBytes(byte[] data){
        
        UtcDPacket utcDPacket = new UtcDPacket(null, null);
        
        ArrayList<byte[]> variableElements = new ArrayList<>();

        int start = 1;
        
        for(int i = 1; i < data.length; i++){
            if(data[i] == 0){
                variableElements.add( Arrays.copyOfRange( data, start, i));
                start = i + 1;
            }
        }
        
        for(int i = start; i < data.length; i++){
            if(data[i] == 0)
                variableElements.add( Arrays.copyOfRange( data, start, i));
        }
        
        String sourceAlias = new String(variableElements.get(0));
        String message = new String(variableElements.get(1));
        
        utcDPacket.setMessage(message);
        utcDPacket.setSourceAlias(sourceAlias);
        
        boolean added = false;
        
        for (Packet p : packetList){
            if(p.getClass().isInstance(utcDPacket)){
                UtcDPacket u = (UtcDPacket) p;
                if(u.getSourceAlias() == utcDPacket.getSourceAlias()){
                    u.setMessage(u.getMessage() + message);
                    added = true;
                    if(data.length < 2048){
                        packetList.remove(u);
                        return u;          
                    }
                }
            }        
        }    
        
        if(data.length == 2048 && added == false)
              packetList.add(utcDPacket);
        
        else if (data.length < 2048){
            return utcDPacket;
        }
        return null;
        
    }
    
}
