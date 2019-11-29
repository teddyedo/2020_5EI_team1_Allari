/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.pacchettipackage;

import java.util.ArrayList;

/**
 *
 * @author Zerbato,Nicolis
 * @author Allari Edoardo
 * 
 */

public class GroupUsersListPacket extends Packet{
    
    private byte[] type;
    private byte[] ListLength;
    private String JsonContent;
    private ArrayList UserConnected;
    private final int OpCode = 51;
    
    /**
     * Constructor
     * @param type
     * @param ListLength
     * @param JsonContent 
     */
    
    public GroupUsersListPacket(byte[] type, byte[] ListLength, String JsonContent) {
        this.type = type;
        this.ListLength = ListLength;
        this.JsonContent = JsonContent;
    }
    
    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    
    /**
     * getter tpye
     * @return byte[] --> type
     */

    public byte[] getType() {
        return type;
    }
    
    /**
     * setter type
     * @param type 
     */

    public void setType(byte[] type) {
        this.type = type;
    }
    
    /**
     * getter List
     * @return byte[] --> ListLength
     */

    public byte[] getListLength() {
        return ListLength;
    }
    
    /**
     * setter ListLength
     * @param ListLength 
     */

    public void setListLength(byte[] ListLength) {
        this.ListLength = ListLength;
    }
    
    /**
     * getter JsonContent
     * @return string --> JsonContent
     */

    public String getJsonContent() {
        return JsonContent;
    }
    
    /**
     * setter JsonContent
     * @param JsonContent 
     */

    public void setJsonContent(String JsonContent) {
        this.JsonContent = JsonContent;
    }

    /**
     * getter OpCode
     * @return int OpCode
     */
    
    public int getOpCode() {
        return OpCode;
    }
    
    /**
     * getter List of user connected
     * @return ArrayList --> userConnected
     */
    
    public ArrayList getUserConnected() {
        return UserConnected;
    }

    /**
     * setter UserConnected
     * @param UserConnected 
     */
    
    public void setUserConnected(ArrayList UserConnected) {
        this.UserConnected = UserConnected;
    }
    
    //</editor-fold>

   
    
}
