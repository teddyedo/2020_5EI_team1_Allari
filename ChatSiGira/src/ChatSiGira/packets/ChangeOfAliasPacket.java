/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.packets;

import ChatSiGira.functions.UserInfo;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Zerbato,Nicolis
 * @author Allari Edoardo
 *
 */
public class ChangeOfAliasPacket implements Packet {

  
    private String NewAlias;
    private final int OpCode = 18;

    /**
     * Constructor
     *

     * @param NewAlias The new Alias that I want to set.
     */
    public ChangeOfAliasPacket(String NewAlias) {
        this.NewAlias = NewAlias;
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    /**
     * getter newAlias
     *
     * @return String NewAlias
     */
    public String getNewAlias() {
        return NewAlias;
    }

    /**
     * setter NewAlias
     *
     * @param NewAlias new alias choosen
     */
    public void setNewAlias(String NewAlias) {
        this.NewAlias = NewAlias;
    }

    /**
     * getter OpCode
     *
     * @return int OpCode
     */
    @Override
    public int getOpCode() {
        return this.OpCode;
    }

    //</editor-fold>
    
    /**
     * create the packet header.
     *
     * @return byte[] header.
     */
    public byte[] header() {

        byte[] buffer = new byte[3];

        int i = 0;

        buffer[i++] = (byte) this.OpCode;

        for (byte b : UserInfo.ID) {
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
        return 5 + UserInfo.alias.length() + this.getNewAlias().length();
    }

    /**
     * convert our packet class into a byte[].
     *
     * @return byte [] complete packet.
     */
    public byte[] toBytes() {

        byte[] buffer = new byte[this.size()];
        int i = 0;

        //Add the header part to the final packet
        for (byte b : this.header()) {
            buffer[i++] = b;
        }

        //Add the oldAlias
        for (byte b : UserInfo.alias.getBytes(StandardCharsets.ISO_8859_1)) {
            buffer[i++] = b;
        }

        //Separator
        buffer[i++] = 0;

        //Add the message
        for (byte b : this.getNewAlias().getBytes(StandardCharsets.ISO_8859_1)) {
            buffer[i++] = b;
        }

        //Separator
        buffer[i++] = 0;

        return buffer;

    }

}
