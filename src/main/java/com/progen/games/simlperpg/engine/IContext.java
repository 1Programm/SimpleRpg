package com.progen.games.simlperpg.engine;

import com.progen.games.simlperpg.controlls.Controls;
import com.progen.games.simlperpg.gfx.IWindow;
import com.progen.games.simlperpg.world.IWorld;

public interface IContext {

    IWindow window();
    Controls controls();
    IWorld world();
}
