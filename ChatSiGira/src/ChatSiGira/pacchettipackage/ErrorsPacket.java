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

public class ErrorsPacket extends Packet{
    
    private byte[] ErrorCode;
    private final int OpCode = 255;

    /**
     * Constructor
     * @param ErrorCode 
     */
    
    public ErrorsPacket(byte[] ErrorCode) {
        
        this.ErrorCode = ErrorCode;
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="getters and setters">

    
    /**
     * getter ErrorCode
     * @return byte[] --> ErrorCode
     */

    public byte[] getErrorCode() {
        return ErrorCode;
    }
    
    /**
     * setter ErrorCode
     * @param ErrorCode 
     */

    public void setErrorCode(byte[] ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    /**
     * Getter OpCode
     * @return int --> OpCode
     */
    
    public int getOpCode() {
        return OpCode;
    }

  
    
    //</editor-fold>
    
    
}

   
    

