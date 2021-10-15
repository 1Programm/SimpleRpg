package com.progen.games.simlperpg.controlls;

/**
 * A Keyboard.
 * Represents the visible methods of the keyboard-controls inside the game.
 */
public interface IKeyboard {

    /**
     * A Method to check whether a certain key is pressed by passing in its keycode from {@link java.awt.event.KeyEvent}.
     * @param keycode the keycode of the key to be checked.
     * @return true if the key is being pressed.
     */
    boolean is(int keycode);

    /**
     * A Method to register a {@link IKeyListener} which will be called on key-presses and key-releases.
     * @param listener the listener.
     */
    void listen(IKeyListener listener);

}
