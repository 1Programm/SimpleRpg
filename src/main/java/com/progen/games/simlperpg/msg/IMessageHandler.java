package com.progen.games.simlperpg.msg;

/**
 * The Message handler.
 * Can be used to send and to listen for Messages.
 */
public interface IMessageHandler {

    /**
     * Sends a Message to all listeners which listen for its specific class AND for all classes which are superclasses of it.
     * The method {@link IMessage#immediate()} will be called to check if the message should be handled on next update or now.
     * @param msg the message to send.
     */
    void send(IMessage msg);

    /**
     * Registers a {@link IMessageListener} for a specific class. That class must extend from IMessage.
     * @param cls the class to listen for.
     * @param listener the listener which will be invoked if a Message with the fitting class has been called.
     */
    <T extends IMessage> void listenFor(Class<T> cls, IMessageListener<T> listener);

}
