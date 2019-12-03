/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Allari Edoardo
 * 
 */

public class ReadClass extends Thread {

    @Override
    public void run() {
        
        
        while(true){
            byte[] data = new byte[2048];
            try {
                data = Connection.read();
            } catch (IOException ex) {
                Logger.getLogger(ReadClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection.interpreter.setData(data);
            
        }

    }
    
    
    
}
