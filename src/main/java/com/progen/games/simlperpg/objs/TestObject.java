package com.progen.games.simlperpg.objs;

import com.progen.games.simlperpg.engine.IContext;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TestObject extends GameObject{

    @Override
    public void update(IContext ctx) {
        if(ctx.controls().keyboard().is(KeyEvent.VK_SPACE)){
            System.out.println("SPAAACE");
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(10,30,100,100);
    }
}
