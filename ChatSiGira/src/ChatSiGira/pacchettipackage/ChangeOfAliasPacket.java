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
public class ChangeOfAliasPacket {
    private byte[] privateId;
    private String oldAlias;
    private String NewAlias;

    public ChangeOfAliasPacket(byte[] privateId, String oldAlias, String NewAlias) {
        this.privateId = privateId;
        this.oldAlias = oldAlias;
        this.NewAlias = NewAlias;
    }
    
    /**
     * 
     * @return privateId
     */

    public byte[] getPrivateId() {
        return privateId;
    }
    
    /**
     * 
     * @param privateId 
     */

    public void setPrivateId(byte[] privateId) {
        this.privateId = privateId;
    }
    
    /**
     * 
     * @return oldAlias
     */

    public String getOldAlias() {
        return oldAlias;
    }
    
    /**
     * 
     * @param oldAlias 
     */

    public void setOldAlias(String oldAlias) {
        this.oldAlias = oldAlias;
    }
    
    /**
     * 
     * @return NewAlias
     */

    public String getNewAlias() {
        return NewAlias;
    }
    
    /**
     * 
     * @param NewAlias 
     */

    public void setNewAlias(String NewAlias) {
        this.NewAlias = NewAlias;
    }
}