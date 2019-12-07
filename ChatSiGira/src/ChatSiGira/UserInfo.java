/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Allari Edoardo
 * 
 */

public class UserInfo {
    
    //User list
    public static ArrayList<String> chatUserList = new ArrayList<>();
    
    //Id assigned from the server 
    public static byte[] ID = null;
    
    //My alias
    public static String alias = null;
    
    //Errors meaning
    public static HashMap<Integer, String> ErrorsMeaning = new HashMap<>();
    
}
