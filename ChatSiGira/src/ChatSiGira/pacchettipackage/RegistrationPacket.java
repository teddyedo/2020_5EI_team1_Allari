/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.pacchettipackage;

/**
 *
 * @author Zerbato,Nicolis
 */
public class RegistrationPacket {
    private byte[] version0;
    private String alias;
    private String topic;
    private int Opcode;

    /**
     * 
     * @param version0
     * @param alias
     * @param topic 
     */
    public RegistrationPacket(byte[] version0, String alias, String topic, int Opcode) {
        this.version0 = version0;
        this.alias = alias;
        this.topic = topic;
        this.Opcode=10;
    }
    /**
     * 
     * @return Version0
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
     * @return Alias
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
    
    /**
     * 
     * @return Opcode
     */

    public int getOpcode() {
        return Opcode;
    }
    
 
    
    //Costruzione pacchetto header 
    
    public byte[] header(){
        
        byte[] buffer = new byte[2];  //Lunghezza Array=2
        
        int i=0;
        
        buffer[i++] =(byte) this.Opcode ; // the integer value of the Opcode is transformed into bytes
        
        //Versione
        
        buffer[i++]=0;
        
        return buffer;
    
}
   //Packet length
    
    public int size()
    {
    if(this.topic == null)
        return 4 + this.alias.length();  // Return the length of the 4 bytes plus the length of the alias
    else 
        return 4 + this.alias.length() + this.topic.length();
    }
    
    public byte[] toBytes()
    {
        
        byte[] buffer = new byte[this.size()];
        
        int i=0;
        
        for(byte b : this.header())
            buffer[i++] = b;
        
        //Alias
        
        for (byte b : this.alias.getBytes())
            
            buffer[i++] = b;
        
        //Delimitator
        
        buffer[i++]=0;
        
        //Topic
        
        if(this.topic != null) {
            
            
           for (byte b : this.topic.getBytes())
               
               buffer[i++]= b;
        }
            
         //Delimitator
         
         buffer[i++] = 0;
         
         return buffer;
       
      }
    
   }
