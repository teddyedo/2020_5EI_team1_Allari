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
 *
 */
public class GroupUsersListPacket implements Packet {

    private byte type;
    private byte ListLength;
    private String JsonContent;
    private final int OpCode = 51;

    /**
     * Constructor
     * @param type The type of the userList:
     * 0: New userList;
     * 1: New user to update;
     * 2: User to delete;
     * @param ListLength The length of the userList.
     * @param JsonContent The userList in JSON format.
     */
    public GroupUsersListPacket(byte type, byte ListLength, String JsonContent) {
        this.type = type;
        this.ListLength = ListLength;
        this.JsonContent = JsonContent;
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    /**
     * getter tpye
     *
     * @return byte[] --> type
     */
    public byte getType() {
        return type;
    }

    /**
     * setter type
     *
     * @param type
     */
    public void setType(byte type) {
        this.type = type;
    }

    /**
     * getter List
     *
     * @return byte[] --> ListLength
     */
    public byte getListLength() {
        return ListLength;
    }

    /**
     * setter ListLength
     *
     * @param ListLength
     */
    public void setListLength(byte ListLength) {
        this.ListLength = ListLength;
    }

    /**
     * getter JsonContent
     *
     * @return string --> JsonContent
     */
    public String getJsonContent() {
        return JsonContent;
    }

    /**
     * setter JsonContent
     *
     * @param JsonContent
     */
    public void setJsonContent(String JsonContent) {
        this.JsonContent = JsonContent;
    }

    /**
     * getter OpCode
     *
     * @return int OpCode
     */
    public int getOpCode() {
        return OpCode;
    }

    //</editor-fold>
}
