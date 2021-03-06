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
public class UtuPacket implements Packet {

    private byte[] SenderId;
    private String DestinationAlias;
    private String Message;
    private final int OpCode = 01;

    /**
     * Constructor
     *
     * @param SenderId The ID assigned by the server.
     * @param DestinationAlias The addressee of our message.
     * @param Message The content of the message.
     */
    public UtuPacket(byte[] SenderId, String DestinationAlias, String Message) {
        this.SenderId = SenderId;
        this.DestinationAlias = DestinationAlias;
        this.Message = Message;
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    /**
     * getter opcode
     *
     * @return int OpCode
     */
    public int getOpCode() {
        return OpCode;
    }

    /**
     * getter SenderId
     *
     * @return byte[] SenderId
     */
    public byte[] getSenderId() {
        return SenderId;
    }

    /**
     * setter senderId
     *
     * @param SenderId the sender ID
     */
    public void setSenderId(byte[] SenderId) {
        this.SenderId = SenderId;
    }

    /**
     * getter DestinationAlias
     *
     * @return string DestinationAlias
     */
    public String getDestinationAlias() {
        return DestinationAlias;
    }

    /**
     * setter DestinationAlias
     *
     * @param DestinationAlias the user alias that will receive the message.
     */
    public void setDestinationAlias(String DestinationAlias) {
        this.DestinationAlias = DestinationAlias;
    }

    /**
     * getter Message
     *
     * @return String Message
     */

    public String getMessage() {
        return Message;
    }

    /**
     * setter Message
     *
     * @param Message the text of the message
     */
    public void setMessage(String Message) {
        this.Message = Message;
    }

    /**
     * Compose the header of the UTUPacket
     *
     * @return byte [] --> header
     */
    //</editor-fold> 
    /**
     * create the packet header.
     *
     * @return byte[] header.
     */
    public byte[] header() {

        byte[] buffer = new byte[1];

        int i = 0;

        buffer[i++] = (byte) this.OpCode;

        return buffer;
    }

    /**
     * Get the size of the final packet.
     *
     * @return int size.
     */
    public int size() {
        return 5 + this.DestinationAlias.length() + this.Message.length();
    }

    /**
     * convert our packet class into a byte[].
     *
     * @return byte [] complete packet.
     */
    public byte[] toBytes() {

        byte[] messageBytes = this.getMessage().getBytes(StandardCharsets.ISO_8859_1);
        
        //max length of payload
        int maxMexLength = 2043 - this.getDestinationAlias().length();
        
        //number of packet to send
        int numberOfPacket = (this.getMessage().length() / maxMexLength) + 1;
        
        
        
        
        byte[] buffer = new byte[this.size()];
        int i = 0;

        //Add the header part to the final packet
        for (byte b : this.header()) {
            buffer[i++] = b;
        }

        //Add the personalID
        buffer[i++] = UserInfo.ID[0];
        buffer[i++] = UserInfo.ID[1];

        //Add the destination alias
        for (byte b : this.DestinationAlias.getBytes(StandardCharsets.ISO_8859_1)) {
            buffer[i++] = b;
        }

        //Separator
        buffer[i++] = 0;

        //Add the message
        for (byte b : this.Message.getBytes(StandardCharsets.ISO_8859_1)) {
            buffer[i++] = b;
        }

        //Separator
        buffer[i++] = 0;

        return buffer;

    }
}
