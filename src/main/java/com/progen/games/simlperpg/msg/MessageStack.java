package com.progen.games.simlperpg.msg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageStack implements IMessageHandler {

    private final Map<Class<? extends IMessage>, List<IMessageListener<? extends IMessage>>> messageListeners = new HashMap<>();
    private final List<IMessage> messageStack = new ArrayList<>();

    @Override
    public void send(IMessage msg) {
        if(msg.immediate()){
            handle(msg, msg.getClass());
        }
        else {
            messageStack.add(msg);
        }
    }

    @Override
    public <T extends IMessage> void listenFor(Class<T> cls, IMessageListener<T> listener) {
        messageListeners.computeIfAbsent(cls, c -> new ArrayList<>()).add(listener);
    }

    public void handleMessages(){
        for(IMessage msg : messageStack){
            handle(msg, msg.getClass());
        }

        messageStack.clear();
    }

    @SuppressWarnings("unchecked")
    private <T extends IMessage> void handle(T msg, Class<? extends IMessage> cls){
        List<IMessageListener<? extends IMessage>> list = messageListeners.get(cls);

        if(list != null) {
            List<IMessageListener<T>> batch = (List<IMessageListener<T>>) (List<?>) list;

            batch.forEach(l -> l.onMessage(msg));
        }

        Class<?> superCls = cls.getSuperclass();
        if(IMessage.class.isAssignableFrom(superCls)){
            Class<? extends IMessage> superMsgCls = (Class<? extends IMessage>) superCls;
            handle(superMsgCls.cast(msg), superMsgCls);
        }
    }
}
