/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.pacchettipackage;

/**
 *
 * @author Zerbato,Nicolis
 * 
 */
public class UtuPacket {
    private byte[] SenderId;
    private String DestinationAlias;
    private String Message;
    private int OpCode;

    public UtuPacket(byte[] SenderId, String DestinationAlias, String Message, int Opcode ) {
        this.SenderId = SenderId;
        this.DestinationAlias = DestinationAlias;
        this.Message = Message;
        this.OpCode= 01;
    }

    /**
     * 
     * @return OpCode
     */
    public int getOpCode() {
        return OpCode;
    }

    
    
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

    public byte[] header() {
        
        byte[] buffer = new byte[1];
        
       int i=0;
       
       buffer[i++] = (byte) this.OpCode;
       
       return buffer;
    }   
    public int size()
    {
        return 5 + this.DestinationAlias.length()+ this.Message.length();
    }
    
    public byte[] toBytes(){
        
        byte[] buffer = new byte [this.size() ];
        int i=0;
        
        for (byte b : this.header())
            
        buffer[i++] = b;
        
        for (byte b : this.DestinationAlias.getBytes())
            buffer[i++]=b;
            
        for (byte b : this.DestinationAlias.getBytes())
            buffer[i++]=b;
        
       
    }
}
