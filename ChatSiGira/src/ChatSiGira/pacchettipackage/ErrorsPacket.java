/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.pacchettipackage;

import java.util.ArrayList;

/**
 *
 * @author Zerbato,Nicolis
 * @author Allari Edoardo
 * 
 */

public class ErrorsPacket {
    
    private byte[] ErrorCode;
    private ArrayList ErrorTab;
    private final int OpCode = 255;

    /**
     * Constructor
     * @param ErrorCode 
     */
    
    public ErrorsPacket(byte[] ErrorCode, ArrayList a) {
        
        this.ErrorCode = ErrorCode;
        this.ErrorTab = a;
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

    /**
     * getter ErrorTab
     * @return ArrayList --> ErrorTab
     */
    
    public ArrayList getErrorTab() {
        return ErrorTab;
    }

    /**
     * Setter ErrorTab
     * @param ErrorTab 
     */
    
    public void setErrorTab(ArrayList ErrorTab) {
        this.ErrorTab = ErrorTab;
    }
    
    //</editor-fold>
    
    
}

   
    

