/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira;

import ChatSiGira.pacchettipackage.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Allari Edoardo
 *
 *
 */
public class InterpretClass extends Thread {

    private byte[] data;
    private Packet packet;

    public InterpretClass(byte[] data) {
        this.data = data;
        this.start();
    }


    @Override
    public void run() {
                packet = Connection.i.interpret(data);

        try {
            Connection.interpret(packet);
        } catch (IOException ex) {
            Logger.getLogger(InterpretClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
