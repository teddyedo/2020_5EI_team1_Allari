/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.functions;

import ChatSiGira.packets.Packet;
import ChatSiGira.app.Connection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Allari Edoardo
 *
 */
public class Executor extends Thread {

    private byte[] data;
    private Packet packet;

    public Executor(byte[] data) {
        this.data = data;
        this.start();
    }

    @Override
    //This Thread interpret the read data and acts accordingly
    public void run() {
        packet = Connection.interpreter.interpret(data);

        try {
            Actions.whatToDo(packet);
        } catch (IOException ex) {
            Logger.getLogger(Executor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
