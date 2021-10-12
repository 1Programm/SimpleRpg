package com.progen.games.simlperpg;

import java.awt.*;

public abstract class GameObject {
    float x, y;
    float width, height;

    public GameObject(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public GameObject (float x, float y) {
        this.x = x;
        this.y = y;
        this.width = 32;                    //TODO: Make this later into a constant
        this.height = 32;
    }

    public void move(float x, float y) {
        this.x += x;
        this.y += y;
    }


    public abstract void update();

    public abstract void render(Graphics graphics);
}
