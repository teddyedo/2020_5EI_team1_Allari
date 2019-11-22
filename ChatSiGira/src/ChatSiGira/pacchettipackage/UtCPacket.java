/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.pacchettipackage;

/**
 *
 * @author Zerbato,Nicolis
 */
public class UtCPacket {
    private byte[] ID;
    private String Message;

    public UtCPacket(byte[] ID, String Message) {
        this.ID = ID;
        this.Message = Message;
    }
    
    /**
     * 
     * @return ID
     */

    public byte[] getID() {
        return ID;
    }
    
    /**
     * 
     * @param ID 
     */

    public void setID(byte[] ID) {
        this.ID = ID;
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
