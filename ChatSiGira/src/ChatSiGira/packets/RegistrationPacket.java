/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.packets;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author Zerbato,Nicolis
 * @author Allari Edoardo
 *
 */
public class RegistrationPacket implements Packet {

    private byte version0;
    private String alias;
    private String topic;
    private final int OpCode = 10;

    /**
     * Constructor
     * @param alias The alias that we have choosen.
     * @param topic The topic (name of the chat room) we want to join.
     *
     */
    public RegistrationPacket(String alias, String topic) {
        this.version0 = 0;
        this.alias = alias;
        this.topic = topic;

        //<editor-fold defaultstate="collapsed" desc="getters and setters">
    }

    /**
     * getter version=
     *
     * @return byte[] Version0
     */

    public byte getVersion0() {
        return version0;
    }

    /**
     * setter version
     *
     * @param version0 the version of the protocol - 0 default
     */
    public void setVersion0(byte version0) {
        this.version0 = version0;
    }

    /**
     * getter Alias
     *
     * @return String Alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * setter Alias
     *
     * @param alias my username
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * getter Topic
     *
     * @return String Topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * setter Topic
     *
     * @param topic the chatRoom that I want to join - version 0 only general.
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * getter Opcode
     *
     * @return int Opcode
     */
    public int getOpCode() {
        return this.OpCode;
    }

    //</editor-fold>
    
    /**
     * create the packet header.
     * @return byte[] header.
     */
    public byte[] header() {

        byte[] buffer = new byte[2];  //buffer length = 2

        int i = 0;

        buffer[i++] = (byte) this.getOpCode(); // the integer value of the Opcode is transformed into bytes

        //Versione
        buffer[i++] = 0;

        return buffer;

    }

    /**
     * return the packet size.
     * @return int packetSize.
     */

    public int size() {
        if (this.topic == null) {
            return 4 + this.alias.length();  // Return the length of the 4 bytes plus the length of the alias
        } else {
            return 4 + this.alias.length() + this.topic.length();
        }
    }

    /**
     * convert our packet class into a byte[].
     * @return byte [] complete packet.
     */
    public byte[] toBytes() {

        byte[] buffer = new byte[this.size()];

        int i = 0;

        for (byte b : this.header()) {
            buffer[i++] = b;
        }

        //Alias
        for (byte b : this.alias.getBytes(StandardCharsets.ISO_8859_1)) {
            buffer[i++] = b;
        }

        //Delimitator
        buffer[i++] = 0;

        //Topic
        if (this.topic != null) {

            for (byte b : this.topic.getBytes(StandardCharsets.ISO_8859_1)) {
                buffer[i++] = b;
            }
        }

        //Delimitator
        buffer[i++] = 0;

        return buffer;

    }

}
