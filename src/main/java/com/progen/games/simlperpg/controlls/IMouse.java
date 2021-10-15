package com.progen.games.simlperpg.controlls;

/**
 * A Mouse.
 * Represents the visible methods of the mouse-controls inside the game.
 */
public interface IMouse {

    /**
     * @return the x-position of the mouse.
     */
    int x();

    /**
     * @return the y-position of the mouse.
     */
    int y();

    /**
     * @return the state of the left-button of the mouse.
     */
    boolean buttonLeft();

    /**
     * @return the state of the right-button of the mouse.
     */
    boolean buttonRight();

    /**
     * @return the state of the middle-button (mouse-wheel) of the mouse.
     */
    boolean buttonMiddle();

}
