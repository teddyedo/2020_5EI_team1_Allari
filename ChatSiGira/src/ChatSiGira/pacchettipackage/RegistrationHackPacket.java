/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.pacchettipackage;

/**
 *
 * @author Zerbato, Nicolis
 * @author Allari Edoardo
 * 
 */

public class RegistrationHackPacket implements Packet{

    private byte[] AssignedId;
    private String AliasConfirmation;
    private final int OpCode = 20;
    
    /**
     * Constructor
     * @param AssignedId
     * @param AliasConfirmation 
     */
    
    public RegistrationHackPacket(byte[] AssignedId, String AliasConfirmation) {
        this.AssignedId = AssignedId;
        this.AliasConfirmation = AliasConfirmation;
    }
    
    //<editor-fold defaultstate="collapsed" desc="getters and setters">

    
    /**
     * getter AssignedId
     * @return byte[] --> AssignedId
     */

    public byte[] getAssignedId() {
        return AssignedId;
    }
    
    /**
     * setter AssignedId
     * @param AssignedId 
     */

    public void setAssignedId(byte[] AssignedId) {
        this.AssignedId = AssignedId;
    }
    
    /**
     * getter Alias COnfirmation
     * @return String --> AliasConfirmation
     */

    public String getAliasConfirmation() {
        return AliasConfirmation;
        
    }
    
    /**
     * setter AliasConfirmation
     * @param AliasConfirmation 
     */

    public void setAliasConfirmation(String AliasConfirmation) {
        this.AliasConfirmation = AliasConfirmation;
    }

    /**
     * getter OpCode
     * @return int --> OpCode
     */
    
    public int getOpCode() {
        return OpCode;
    }

    
    //</editor-fold>
}
