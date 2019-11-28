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
import ChatSiGira.UserList;

/**
 *
 * @author Jonathan Pollinari
 * @author Abreham Bologna
 * @author Allari Edoardo
 * 
 */

public class Interpreter {
    
    ArrayList<Object> packetList = new ArrayList<>();

    public Object interpret(byte[] data) {
        byte opCode = data[0];

        switch (opCode) {

            case 01:                        //message user to user
                return utuDPacketToBytes(data);
         
            case 05:
                return utcDPacketToBytes(data);
                
            case 11:                        //disconnection
                return disconnectionServerPacketToBytes(data);

            case 20:                        //registrationAck
                return createRegistrationAckFromBytes(data);

            case 51:                        //group user list 
                return groupUsersListPacketToBytes(data);
                
            case (byte) 255:
                return errorsPacketToBytes(data);

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
        
    
    
    private DisconnectionServerPacket disconnectionServerPacketToBytes(byte[] data) {
        
       DisconnectionServerPacket disconnectionServer = new DisconnectionServerPacket(null);
       
       //get the reason of the disconnection
       byte[] reason = new byte[1];
       reason[0] = data[1];
       
       //set the reason
       disconnectionServer.setReason(reason);
    
       return disconnectionServer;
    }
    
    private ErrorsPacket errorsPacketToBytes(byte[] data){
        
        ErrorsPacket errorsPacket = new ErrorsPacket(null);
        
        //get the error 
        byte[] error = new byte[1];
        error[0] = data[1];
        
        //set the error
        errorsPacket.setErrorCode(error);
        
        return errorsPacket;
    }
    
    private GroupUsersListPacket groupUsersListPacketToBytes(byte[] data){
        
        GroupUsersListPacket groupUsersListPacket = new GroupUsersListPacket(null, null, null);
        
        byte type = data[1];
        
        byte[] jsonByte = Arrays.copyOfRange(data, 3, data.length - 1);
        
        String jsonString = new String(jsonByte);
        
        ArrayList<String> userList = new ArrayList<>();
        
        Gson json = new Gson();
        userList = json.fromJson(jsonString, userList.getClass());
        
        switch(type){
            
            case 0:
                UserList.chatUserList.clear();
                UserList.chatUserList = userList;
 
            case 1:
                UserList.chatUserList.add(userList.get(0));
                
            case 2:
                UserList.chatUserList.remove(userList.get(0));
        }
        
        return groupUsersListPacket;
    }
    
    

    private UtuDPacket utuDPacketToBytes(byte[] data){
        
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
        
        for (Object p : packetList){
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
    
    
    //bisogna implementare un nuovo pacchetto per i pacchetti che arrivano dalle chat pubbliche
    private UtcDPacket utcDPacketToBytes(byte[] data){
        
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
        
        for (Object p : packetList){
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
