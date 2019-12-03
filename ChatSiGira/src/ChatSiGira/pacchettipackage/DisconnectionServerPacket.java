/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.pacchettipackage;

/**
 *
 * @author Allari Edoardo
 * 
 */

public class DisconnectionServerPacket implements Packet{
    
    private byte[] reason;
    private final int OpCode = 11; 
    
    /**
     * Constructor 
     * @param reason 
     */
    
    public DisconnectionServerPacket(byte[] reason) {
        this.reason = reason;
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="getters and setters">

    /**
     * getter Reason
     * @return byte[] --> reason
     */

    public byte[] getReason() {
        return reason;
    }
    
    /**
     * setter reason
     * @param reason 
     */

    public void setReason(byte[] reason) {
        this.reason = reason;
    }

    /**
     * getter OpCode
     * @return int --> Opcode
     */
    public int getOpCode() {
        return OpCode;
    }
    
    //</editor-fold>
    
}
