/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira;

import ChatSiGira.pacchettipackage.*;
import java.util.ArrayList;

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

                Connection.interpret(packet);

    }

}
