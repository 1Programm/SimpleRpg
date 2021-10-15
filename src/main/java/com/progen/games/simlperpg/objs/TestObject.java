package com.progen.games.simlperpg.objs;

import com.progen.games.simlperpg.controlls.IKeyboard;
import com.progen.games.simlperpg.engine.IContext;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TestObject extends GameObject{

    private static final float SPEED = 0.8f;

    public TestObject(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public void update(IContext ctx) {
        IKeyboard keyboard = ctx.controls().keyboard();
        float vx = 0, vy = 0;

        if(keyboard.is(KeyEvent.VK_W)){
            vy -= SPEED;
        }
        if(keyboard.is(KeyEvent.VK_S)){
            vy += SPEED;
        }

        if(keyboard.is(KeyEvent.VK_A)){
            vx -= SPEED;
        }
        if(keyboard.is(KeyEvent.VK_D)){
            vx += SPEED;
        }

        this.x += vx;
        this.y += vy;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x,(int)y, (int)width, (int)height);
    }
}
