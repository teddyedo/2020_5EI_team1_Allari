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

    protected static byte[] data = null;
    ArrayList<Packet> PacketList = new ArrayList<>();

    public void setData(byte[] d) {
        InterpretClass.data = d;
    }

    @Override
    public void run() {
        while (true) {

            if (data != null) {
                PacketList.add(Connection.i.interpret(data));

                Connection.interpret(PacketList.get(0));

                PacketList.remove(0);
                data = null;
            }
        }
    }

}
