package com.progen.games.simlperpg.controlls;

public interface IKeyboard {

    boolean is(int keycode);

    void listen(IKeyListener listener);

}
