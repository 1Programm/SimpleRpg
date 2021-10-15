package com.progen.games.simlperpg.msg;

/**
 * A message.
 * This interface should be implemented as a way to define data between multiple objects, so that they can send that information between them.
 */
public interface IMessage {

    /**
     * Defines if this message will be handled immediately on send or on next update
     * @return true if the message should be handled immediately.
     */
    default boolean immediate() { return false; }

}
