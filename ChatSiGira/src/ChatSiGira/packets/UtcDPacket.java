/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.packets;

/**
 *
 * @author Allari Edoardo
 *
 */
public class UtcDPacket implements Packet {

    private String SourceAlias;
    private String Message;
    private final int OpCode = 05;

    /**
     * Constructor
     *
     * @param SourceAlias The alias that sent the message.
     * @param Message The content of the message.
     */
    public UtcDPacket(String SourceAlias, String Message) {
        this.SourceAlias = SourceAlias;
        this.Message = Message;
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    /**
     * getter SourceAlias
     *
     * @return string SourceAlias
     */
    public String getSourceAlias() {
        return SourceAlias;
    }

    /**
     * setter sourceAlias
     *
     * @param SourceAlias the sender alias.
     */
    public void setSourceAlias(String SourceAlias) {
        this.SourceAlias = SourceAlias;
    }

    /**
     * getter message
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
     * getter OpCode
     *
     * @return int OpCode
     */
    public int getOpCode() {
        return OpCode;
    }

    //</editor-fold>
}
