/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Allari Edoardo
 * 
 * 
 */

public class Connection {
    
    public static void main(String[] args) throws IOException {
        
        Socket client = new Socket("127.0.0.1", 53101);
        client.close();
    }
}
