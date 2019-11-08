/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacchettipackage;

/**
 *
 * @author Zerbato,Nicolis
 * 
 */
public class ErrorsPacket {
    private byte[] ErrorCode;

    public ErrorsPacket(byte[] ErrorCode) {
        this.ErrorCode = ErrorCode;
    }
    
    /**
     * 
     * @return ErrorCode
     */

    public byte[] getErrorCode() {
        return ErrorCode;
    }
    
    /**
     * 
     * @param ErrorCode 
     */

    public void setErrorCode(byte[] ErrorCode) {
        this.ErrorCode = ErrorCode;
    }
}

   
    

