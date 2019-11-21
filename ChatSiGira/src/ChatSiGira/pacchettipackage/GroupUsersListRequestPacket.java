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
public class GroupUsersListRequestPacket {
    private byte[] AssignedId;

    public GroupUsersListRequestPacket(byte[] AssignedId) {
        this.AssignedId = AssignedId;
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
    
}
