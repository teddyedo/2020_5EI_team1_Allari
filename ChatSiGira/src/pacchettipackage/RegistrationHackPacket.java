/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacchettipackage;

/**
 *
 * @author Zerbato, Nicolis
 */
public class RegistrationHackPacket {
    private byte[] AssignedId;
    private String AliasConfirmation;

    public RegistrationHackPacket(byte[] AssignedId, String AliasConfirmation) {
        this.AssignedId = AssignedId;
        this.AliasConfirmation = AliasConfirmation;
    }
    
    /**
     * 
     * @return AssignedId
     */

    public byte[] getAssignedId() {
        return AssignedId;
    }
    
    /**
     * 
     * @param AssignedId 
     */

    public void setAssignedId(byte[] AssignedId) {
        this.AssignedId = AssignedId;
    }
    
    /**
     * 
     * @return AliasConfirmation
     */

    public String getAliasConfirmation() {
        return AliasConfirmation;
        
    }
    
    /**
     * 
     * @param AliasConfirmation 
     */

    public void setAliasConfirmation(String AliasConfirmation) {
        this.AliasConfirmation = AliasConfirmation;
    }

 
 
    
    
}
