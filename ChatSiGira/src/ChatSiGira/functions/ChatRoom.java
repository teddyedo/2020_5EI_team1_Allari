/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.functions;

import ChatSiGira.graphicinterface.ChatInterface;

/**
 *
 * @author Allari Edoardo
 *
 */
public class ChatRoom {

    private final String alias;
    private final ChatInterface chatInterface;

    /**
     * Constructor.
     * @param alias the name of the user with which we are chatting.
     * @param chatInterface the chat window.
     */
    public ChatRoom(String alias, ChatInterface chatInterface) {
        this.alias = alias;
        this.chatInterface = chatInterface;
    }

    /**
     * getter alias
     * @return string alias
     */
    public String getAlias() {
        return alias;
    }

    public ChatInterface getChatInterface() {
        return chatInterface;
    }
    
    

}
