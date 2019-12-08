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
public class ChangeOfAliasPacket implements Packet {

    private byte[] privateId;
    private String oldAlias;
    private String NewAlias;
    private final int OpCode = 18;

    /**
     * Constructor
     *
     * @param privateId The ID assigned by the server.
     * @param oldAlias My OldAlias.
     * @param NewAlias The new Alias that I want to set.
     */
    public ChangeOfAliasPacket(byte[] privateId, String oldAlias, String NewAlias) {
        this.privateId = privateId;
        this.oldAlias = oldAlias;
        this.NewAlias = NewAlias;
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    /**
     * getter privateId
     *
     * @return byte[] --> privateId
     */
    public byte[] getPrivateId() {
        return privateId;
    }

    /**
     * setter privateId
     *
     * @param privateId
     */
    public void setPrivateId(byte[] privateId) {
        this.privateId = privateId;
    }

    /**
     * getter oldAlias
     *
     * @return String --> oldAlias
     */
    public String getOldAlias() {
        return oldAlias;
    }

    /**
     * setter oldAlias
     *
     * @param oldAlias
     */
    public void setOldAlias(String oldAlias) {
        this.oldAlias = oldAlias;
    }

    /**
     * getter newAlias
     *
     * @return String --> NewAlias
     */
    public String getNewAlias() {
        return NewAlias;
    }

    /**
     * setter NewAlias
     *
     * @param NewAlias
     */
    public void setNewAlias(String NewAlias) {
        this.NewAlias = NewAlias;
    }

    /**
     * getter OpCode
     *
     * @return int --> OpCode
     */
    @Override
    public int getOpCode() {
        return this.OpCode;
    }

    //</editor-fold>
    
    /**
     * create the packet header.
     *
     * @return byte[] --> header.
     */
    public byte[] header() {

        byte[] buffer = new byte[3];

        int i = 0;

        buffer[i++] = (byte) this.OpCode;

        for (byte b : this.getPrivateId()) {
            buffer[i++] = b;
        }

        return buffer;
    }

    /**
     * Get the size of the final packet.
     *
     * @return int size.
     */
    public int size() {
        return 5 + this.getOldAlias().length() + this.getNewAlias().length();
    }

    /**
     * convert our packet class into a byte[].
     *
     * @return byte [] --> complete packet.
     */
    public byte[] toBytes() {

        byte[] buffer = new byte[this.size()];
        int i = 0;

        //Add the header part to the final packet
        for (byte b : this.header()) {
            buffer[i++] = b;
        }

        //Add the oldAlias
        for (byte b : this.getOldAlias().getBytes()) {
            buffer[i++] = b;
        }

        //Separator
        buffer[i++] = 0;

        //Add the message
        for (byte b : this.getNewAlias().getBytes()) {
            buffer[i++] = b;
        }

        //Separator
        buffer[i++] = 0;

        return buffer;

    }

}
