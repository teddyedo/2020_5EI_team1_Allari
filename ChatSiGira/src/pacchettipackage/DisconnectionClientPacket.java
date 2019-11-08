/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacchettipackage;

/**
 *
 * @author Zerbato,Nicolis
 */
public class DisconnectionClientPacket {
    private byte[] ID;

    public DisconnectionClientPacket(byte[] ID) {
        this.ID = ID;
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
}
