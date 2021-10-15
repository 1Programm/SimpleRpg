package com.progen.games.simlperpg.world;

import com.progen.games.simlperpg.objs.GameObject;

/**
 * The world context.
 * Provides info and methods to manage the world.
 */
public interface IWorld {

    /**
     * Adds an object into the currently loaded map.
     * @param obj the GameObject to add.
     */
    void addObject(GameObject obj);

}
