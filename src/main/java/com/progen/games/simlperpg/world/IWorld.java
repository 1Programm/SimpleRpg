package com.progen.games.simlperpg.world;

import com.progen.games.simlperpg.objs.GameObject;

public interface IWorld {

    /**
     * Adds an object into the currently loaded map.
     * @param obj the GameObject to add.
     */
    void addObject(GameObject obj);

}
