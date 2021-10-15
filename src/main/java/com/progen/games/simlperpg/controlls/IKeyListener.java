package com.progen.games.simlperpg.controlls;

/**
 * Functional Interface which can be used and registered to listen for key-events.
 */
@FunctionalInterface
public interface IKeyListener {

    /**
     * Will be called by an implementation of {@link IKeyboard} to notify that a key has been pressed or released.
     * @param keycode the keycode representing a key.
     * @param pressed the state of the key.
     */
    void onKeyAction(int keycode, boolean pressed);

}
