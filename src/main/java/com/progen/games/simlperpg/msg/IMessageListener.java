package com.progen.games.simlperpg.msg;

public interface IMessageListener <T extends IMessage> {

    void onMessage(T msg);

}
