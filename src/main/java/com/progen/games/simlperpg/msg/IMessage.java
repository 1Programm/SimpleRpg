package com.progen.games.simlperpg.msg;

public interface IMessage {

    /**
     * Defines if this message will be handled immediately on send or on next update
     * @return true if the message should be handled immediately.
     */
    default boolean immediate() { return false; }

}
