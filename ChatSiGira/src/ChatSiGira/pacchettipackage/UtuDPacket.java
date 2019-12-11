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
public class UtuDPacket implements Packet {

    private String SourceAlias;
    private String Message;
    private final int OpCode = 1;

    /**
     * Constructor
     *
     * @param SourceAlias The alias that sent the message.
     * @param Message The content of the message.
     */
    public UtuDPacket(String SourceAlias, String Message) {
        this.SourceAlias = SourceAlias;
        this.Message = Message;
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    /**
     * getter SourceAlias
     *
     * @return string --> SourceAlias
     */
    public String getSourceAlias() {
        return SourceAlias;
    }

    /**
     * setter sourceAlias
     *
     * @param SourceAlias
     */
    public void setSourceAlias(String SourceAlias) {
        this.SourceAlias = SourceAlias;
    }

    /**
     * getter message
     *
     * @return String --> Message
     */
    public String getMessage() {
        return Message;
    }

    /**
     * setter Message
     *
     * @param Message
     */
    public void setMessage(String Message) {
        this.Message = Message;
    }

    /**
     * getter OpCode
     *
     * @return int --> OpCode
     */
    public int getOpCode() {
        return OpCode;
    }

    //</editor-fold>
}
