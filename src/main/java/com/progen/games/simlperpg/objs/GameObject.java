package com.progen.games.simlperpg.objs;

import com.progen.games.simlperpg.engine.IContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class GameObject {

    protected float x, y;
    protected float width, height;

    public abstract void update(IContext ctx);

    public abstract void render(Graphics g);
}
