/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.functions;

import ChatSiGira.app.Connection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Allari Edoardo
 * 
 */

public class Reader extends Thread {

    public Reader() {
        this.start();
    }
    
    

    @Override
    public void run() {
        
        
        while(true){
            byte[] data = new byte[2048];
            try {
                data = Actions.read();
            } catch (IOException ex) {
                Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Executor i = new Executor(data);
            
        }

    }
    
    
    
}