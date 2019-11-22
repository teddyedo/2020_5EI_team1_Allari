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
public class GroupUsersListPacket {
    private byte[] type;
    private byte[] ListLenght;
    private String JsonContent;

    public GroupUsersListPacket(byte[] type, byte[] ListLenght, String JsonContent) {
        this.type = type;
        this.ListLenght = ListLenght;
        this.JsonContent = JsonContent;
    }
    
    /**
     * 
     * @return type
     */

    public byte[] getType() {
        return type;
    }
    
    /**
     * 
     * @param type 
     */

    public void setType(byte[] type) {
        this.type = type;
    }
    
    /**
     * 
     * @return ListLenght
     */

    public byte[] getListLenght() {
        return ListLenght;
    }
    
    /**
     * 
     * @param ListLenght 
     */

    public void setListLenght(byte[] ListLenght) {
        this.ListLenght = ListLenght;
    }
    
    /**
     * 
     * @return JsonContent
     */

    public String getJsonContent() {
        return JsonContent;
    }
    
    /**
     * 
     * @param JsonContent 
     */

    public void setJsonContent(String JsonContent) {
        this.JsonContent = JsonContent;
    }
    
}
