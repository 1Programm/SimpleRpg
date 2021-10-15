package com.progen.games.simlperpg.engine;

import com.progen.games.simlperpg.controlls.Controls;
import com.progen.games.simlperpg.gfx.IWindow;
import com.progen.games.simlperpg.msg.IMessageHandler;
import com.progen.games.simlperpg.world.IWorld;
import com.progen.games.simlperpg.objs.GameObject;

/**
 * The game context.
 * A collection of contexts to provide a {@link GameObject} with tools and info that it might need.
 */
public interface IContext {

    /**
     * @return the window context.
     */
    IWindow window();

    /**
     * @return the control context.
     */
    Controls controls();

    /**
     * @return the world context.
     */
    IWorld world();

    /**
     * @return the message handler context.
     */
    IMessageHandler messages();

}
