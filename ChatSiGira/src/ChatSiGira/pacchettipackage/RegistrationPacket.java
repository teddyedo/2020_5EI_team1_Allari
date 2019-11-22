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
public class RegistrationPacket {
    private byte[] version0;
    private String alias;
    private String topic;

    public RegistrationPacket(byte[] version0, String alias, String topic) {
        this.version0 = version0;
        this.alias = alias;
        this.topic = topic;
    }
    
    /**
     * 
     * @return version0
     */

    public byte[] getVersion0() {
        return version0;
    }
    
    /**
     * 
     * @param version0 
     */

    public void setVersion0(byte[] version0) {
        this.version0 = version0;
    }
    
    /**
     * 
     * @return alias
     */

    public String getAlias() {
        return alias;
    }
    
    /**
     * 
     * @param alias 
     */

    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    /**
     * 
     * @return Topic 
     */

    public String getTopic() {
        return topic;
    }
    
    /**
     * 
     * @param topic 
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

   
 }
    

