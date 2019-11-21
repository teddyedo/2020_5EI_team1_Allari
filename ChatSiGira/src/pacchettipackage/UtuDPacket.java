/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacchettipackage;

/**
 *
 * @author Zerbato,Nicolis
 */
public class UtuDPacket {
    private String SourceAlias;
    private String Message;

    public UtuDPacket(String SourceAlias, String Message) {
        this.SourceAlias = SourceAlias;
        this.Message = Message;
    }
    /**
     * 
     * @return SourceAlias
     */
    
    public String getSourceAlias() {
        return SourceAlias;
    }
    
    /**
     * 
     * @param SourceAlias 
     */

    public void setSourceAlias(String SourceAlias) {
        this.SourceAlias = SourceAlias;
    }
    
    /**
     * 
     * @return Message
     */

    public String getMessage() {
        return Message;
    }
    
    /**
     * 
     * @param Message 
     */

    public void setMessage(String Message) {
        this.Message = Message;
    }

   
    
}
