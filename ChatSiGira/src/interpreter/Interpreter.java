/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import pacchettipackage.*;

/**
 *
 * @author Jonathan Pollinari
 * @author Abreham Bologna
 */
public class Interpreter {

    public byte[] interpret(byte[] data) {
        byte opCode = data[0];

        switch (opCode) {

            case 01:                        //message user to user
                return userToUser(data);

            case 05:                        //message user to chat
                return userToChat(data);

            case 10:                        //registration
                return createRegistrationFromBytes(data);

            case 11:                        //disconnection
                return disconnection(data);

            case 18:                        //changeOfAlias
                return createChangeOfAliasPacketFromBytes(data);

            case 20:                        //registrationAck
                return registrationAck(data);

            case 50:                        //group user list request
                return gino(data);

            case 51:                        //group user list 
                return list(data);

        }

    }

    private RegistrationPacket createRegistrationFromBytes(byte[] data) {
        
        int start = 2;
        RegistrationPacket registration = new RegistrationPacket(null, null,null);
        
        ArrayList<byte[]> variableElements = new ArrayList<>();
        for (int i = 2; i < data.length; i++){
            if ( data[i] == 0){
                variableElements.add( Arrays.copyOfRange( data, start, i));
                start = i + 1;
            }
            String alias = new String( variableElements.get(0));
            byte[] version = new byte[1];
            version[0] = 0;
            registration.setVersion0(version);
            registration.setAlias(alias);
            registration.setTopic(null);
    
        }
        
        return registration;
    }
    
    private ChangeOfAliasPacket createChangeOfAliasPacketFromBytes(byte[] data) {
        
       ChangeOfAliasPacket aliasChange = new ChangeOfAliasPacket( null, null, null );
       ArrayList<byte[]> aliasList = new ArrayList<>();
       
       byte[] id = new byte[2];
       id[0] = data[1];
       id[1] = data[2];
       
       aliasChange.setPrivateId(id);
       
       int start = 3;
      
       for ( int i = 3; i < data.length; i++ ) 
       {
           if ( data[i] == 0 ) 
           {
               aliasList.add( Arrays.copyOfRange( data, start, i ) );
               start = i + 1;
           }
           
       
       aliasChange.setOldAlias( new String (aliasList.get(0)));
       aliasChange.setNewAlias( new String (aliasList.get(1))); 
    }
        return aliasChange;
    }

}
