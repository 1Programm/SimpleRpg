package com.progen.games.simlperpg.msg;

/**
 * A message listener.
 * Can be used and registered to listen for specific implementations of {@link IMessage}.
 */
@FunctionalInterface
public interface IMessageListener <T extends IMessage> {

    /**
     * Will be called by an implementation of {@link IMessageHandler}.
     * @param msg the message.
     */
    void onMessage(T msg);

}
