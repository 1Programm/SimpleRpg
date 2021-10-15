package com.progen.games.simlperpg.msg;

public interface IMessageHandler {

    void send(IMessage msg);
    <T extends IMessage> void listenFor(Class<T> cls, IMessageListener<T> listener);

}
