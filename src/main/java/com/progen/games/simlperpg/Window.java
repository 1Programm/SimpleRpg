package com.progen.games.simlperpg;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Window extends JFrame {

    private final Canvas canvas;

    public Window (String title, int width, int height) {
        this.setTitle(title);
        this.setSize(width,height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new Canvas();

        this.add(canvas);
        this.setLocationRelativeTo(null);
    }


    public void render(){
        BufferStrategy bs = canvas.getBufferStrategy();

        if(bs == null){
            canvas.createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        g.setColor(Color.RED);
        g.fillRect(10,30,100,100);

        g.dispose();
        bs.show();
    }

}
