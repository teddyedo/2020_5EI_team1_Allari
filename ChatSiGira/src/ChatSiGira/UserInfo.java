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
    public static enum ErrorCode {

        /**
         * malformed package
         */
        PackageMalformed(0),
        /**
         * alias already in use
         */
        AliasInUse(100),
        /**
         * unvalid alias
         */
        InvalidAlias(101),
        /**
         * invalid room name
         */
        InvalidRoomName(102),
        /**
         * chat denied
         */
        ChatDenied(200),
        /**
         * maximum clients reached
         */
        MaxClientsReached(202),
        /**
         * server exploded
         */
        ServerExploded(254),
        /**
         * unspecified exception
         */
        Unspecified(255);

        private byte code;

        private ErrorCode(int code) {
            this.code = (byte) code;
        }

        public static ErrorCode getErrorCodeFromByte(byte error) {
            switch (error) {
                case 0:
                    return PackageMalformed;
                case 100:
                    return AliasInUse;
                case 101:
                    return InvalidAlias;
                case 102:
                    return InvalidRoomName;
                case (byte) 200:
                    return ChatDenied;
                case (byte) 202:
                    return MaxClientsReached;
                case (byte) 254:
                    return ServerExploded;
                case (byte) 255:
                    return Unspecified;
                default:
                    return null;
            }
        }
    }
}
