package com.progen.games.simlperpg.controlls;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Controls {

    private final IKeyboard keyboard;
    private final IMouse mouse;

    public IKeyboard keyboard() {
        return keyboard;
    }

    public IMouse mouse() {
        return mouse;
    }
}
