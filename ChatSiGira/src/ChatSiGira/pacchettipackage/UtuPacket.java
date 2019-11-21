/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacchettipackage;

/**
 *
 * @author Zerbato,Nicolis
 * 
 */
public class UtuPacket {
    private byte[] SenderId;
    private String DestinationAlias;
    private String Message;

    public UtuPacket(byte[] SenderId, String DestinationAlias, String Message) {
        this.SenderId = SenderId;
        this.DestinationAlias = DestinationAlias;
        this.Message = Message;
    }

    /**
     * 
     * @return SenderId
     */
    
    public byte[] getSenderId() {
        return SenderId;
    }

    /**
     * 
     * @param SenderId 
     */
    
    public void setSenderId(byte[] SenderId) {
        this.SenderId = SenderId;
    }
    
    /**
     * 
     * @return DestinationAlias
     */
    public String getDestinationAlias() {
        return DestinationAlias;
    }
    
    /**
     * 
     * @param DestinationAlias 
     */
    
    public void setDestinationAlias(String DestinationAlias) {
        this.DestinationAlias = DestinationAlias;
    }
    /**
     * 
     * @return Message
     */

    public String getMessage() {
        return Message;
    }
    
    /**
     * 
     * @param Message 
     */

    public void setMessage(String Message) {
        this.Message = Message;
    }


   
    
}
