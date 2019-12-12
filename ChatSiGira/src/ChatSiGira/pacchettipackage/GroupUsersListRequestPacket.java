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
public class GroupUsersListRequestPacket implements Packet {

    private byte[] AssignedId;
    private final int OpCode = 50;

    /**
     * Constructor
     * @param AssignedId The ID assigned by the server.
     */
    public GroupUsersListRequestPacket(byte[] AssignedId) {
        this.AssignedId = AssignedId;
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    /**
     * getter AssignedId
     *
     * @return byte[] AssignedId
     */
    public byte[] getAssignedId() {
        return AssignedId;
    }

    /**
     * setter AssignedId
     *
     * @param AssignedId my ID.
     */
    public void setAssignedId(byte[] AssignedId) {
        this.AssignedId = AssignedId;
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
    /**
     * create the packet header.
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
     * @return int size.
     */
    public int size() {
        return 1 + this.getAssignedId().length;
    }

    /**
     * convert our packet class into a byte[].
     * @return byte [] complete packet.
     */
    public byte[] toBytes() {

        byte[] buffer = new byte[this.size()];
        int i = 0;

        //Add the header part to the final packet
        for (byte b : this.header()) {
            buffer[i++] = b;
        }

        //Add the Id
        for (byte b : this.getAssignedId()) {
            buffer[i++] = b;
        }

        return buffer;

    }

}
