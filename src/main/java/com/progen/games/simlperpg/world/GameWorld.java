package com.progen.games.simlperpg.world;

import com.progen.games.simlperpg.engine.IContext;
import com.progen.games.simlperpg.objs.GameObject;
import com.progen.games.simlperpg.objs.TestObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameWorld implements IWorld {

    private final List<GameObject> objs = new ArrayList<>();

    public void init(){
        objs.add(new TestObject(10, 10, 100, 200));
    }

    public void update(IContext ctx){
        for(int i=0;i<objs.size();i++){
            objs.get(i).update(ctx);
        }
    }

    public void render(Graphics g){
        //TODO: Draw the loaded Map or while switching between Maps a loading screen etc.
    }

    public List<GameObject> getVisibleObjects(){
        //TODO: Return only objects near player!
        return objs;
    }

    @Override
    public void addObject(GameObject obj) {
        //TODO: Map class and object list inside map instead of having it here.
        objs.add(obj);
    }
}
