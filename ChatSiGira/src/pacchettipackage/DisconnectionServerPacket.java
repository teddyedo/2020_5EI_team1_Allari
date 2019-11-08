/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacchettipackage;

/**
 *
 * @author 17959
 */
public class DisconnectionServerPacket {
    private byte[] reason;

    public DisconnectionServerPacket(byte[] reason) {
        this.reason = reason;
    }
    
    /**
     *
     * @return reason
     */

    public byte[] getReason() {
        return reason;
    }
    
    /**
     * 
     * @param reason 
     */

    public void setReason(byte[] reason) {
        this.reason = reason;
    }
}
