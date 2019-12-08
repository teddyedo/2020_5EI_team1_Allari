/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.pacchettipackage;

import ChatSiGira.functions.UserInfo;

/**
 *
 * @author Zerbato,Nicolis
 * @author Allari Edoardo
 *
 */
public class ErrorPacket implements Packet {

    private UserInfo.ErrorCode ErrorCode;
    private final int OpCode = 255;

    /**
     * Constructor
     *
     * @param ErrorCode The errorCode that refers to a specific error in
     * UserInfo
     */
    public ErrorPacket(UserInfo.ErrorCode ErrorCode) {

        this.ErrorCode = ErrorCode;
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    /**
     * getter ErrorCode
     *
     * @return byte[] --> ErrorCode
     */
    public UserInfo.ErrorCode getErrorCode() {
        return ErrorCode;
    }

    /**
     * setter ErrorCode
     *
     * @param ErrorCode
     */
    public void setErrorCode(UserInfo.ErrorCode ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    /**
     * Getter OpCode
     *
     * @return int --> OpCode
     */
    public int getOpCode() {
        return OpCode;
    }

    //</editor-fold>
}
