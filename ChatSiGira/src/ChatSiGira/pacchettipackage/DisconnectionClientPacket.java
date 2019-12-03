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
 */

public class DisconnectionClientPacket implements Packet{
    
    private byte[] ID;
    private final int OpCode = 11;
    

    /**
     * Constructor 
     * @param ID 
     */
    
    public DisconnectionClientPacket(byte[] ID) {
        this.ID = ID;
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
     * getter OpCode
     * @return int --> OpCode
     */
    
    @Override
    public int getOpCode() {
        return OpCode;
    }
    
    //</editor-fold>
    
    
    /**
    * create the packet header
    * @return byte[] --> header
    */
    
    public byte[] header() {
        
       byte[] buffer = new byte[1];
        
       int i=0;
       
       buffer[i++] = (byte) this.OpCode;
       
       return buffer;
    }   
    
    /**
     * Get the size of the final packet
     * @return int size
     */
    
    public int size()
    {
        return 5 + this.getID().length;
    }
    
    /**
     * convert our packet class into a byte[]
     * @return byte [] --> complete packet
     */
    
    public byte[] toBytes(){
        
        byte[] buffer = new byte [this.size()];
        int i = 0;
        
        //Add the header part to the final packet
        
        for (byte b : this.header())
            buffer[i++] = b;
        
        //Add the ID
        
        for (byte b : this.getID())
            buffer[i++]=b;       
       
        
        return buffer;
       
    }
    
    
}
