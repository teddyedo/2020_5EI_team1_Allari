/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.pacchettipackage;

/**
 *
 * @author Zerbato,Nicolis
 * @author Allari Edoardo
 * 
 */

public class UtCPacket extends Packet{

    private byte[] ID;
    private String Message;
    private final int OpCode = 05;

    
    /**
     * Constructor
     * @param ID
     * @param Message 
     */
    
    public UtCPacket(byte[] ID, String Message) {
        this.ID = ID;
        this.Message = Message;
    }
    
    //<editor-fold defaultstate="collapsed" desc="getters and setters">

    
    /**
     * getter ID
     * @return byte[] --> ID
     */

    public byte[] getID() {
        return ID;
    }
    
    /**
     * setter ID
     * @param ID 
     */

    public void setID(byte[] ID) {
        this.ID = ID;
    }
    
    /**
     * getter Message
     * @return String --> Message
     */

    public String getMessage() {
        return Message;
    }
    
    /**
     * setter Message
     * @param Message 
     */

    public void setMessage(String Message) {
        this.Message = Message;
    }

    /**
     * getter OpCode
     * @return int --> Opcode
     */
    public int getOpCode() {
        return OpCode;
    }

    //</editor-fold>

    /**
     * create the packet header
     * @return byte[] --> header
     */
    
    public byte [] header(){
    
        byte[] buffer = new byte[1]; //header length = 1
        
        buffer[0] = (byte) this.getOpCode();
        
        return buffer;
        
    }
    
    /**
     * return the packet size
     * @return int --> packetSize
     */
    
    public int size(){
        return this.header().length + this.getID().length 
                + this.getMessage().length();
    }
    
    /**
     * convert our packet class into a byte[]
     * @return byte [] --> complete packet
     */
    
    public byte[] toBytes(){
        
        byte[] buffer = new byte[this.size()];
        
        int i = 0;
        
        //Add the header
        
        for (byte b : this.header())
            buffer[i++] = b;
        
        //Add the ID
        
        for (byte b : this.getID())
            buffer[i++] = b;
        
        //Add the message
        
        for (byte b : this.getMessage().getBytes())
            buffer[i++] = b;
        
        //Separator
        
        buffer[i] = 0;
        
        return buffer;
        
    }
    
    
   
    
}
