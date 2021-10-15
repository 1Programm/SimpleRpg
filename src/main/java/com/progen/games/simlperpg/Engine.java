package com.progen.games.simlperpg;

import com.progen.games.simlperpg.controlls.Controls;
import com.progen.games.simlperpg.engine.IContext;
import com.progen.games.simlperpg.gfx.IWindow;
import com.progen.games.simlperpg.objs.GameObject;
import com.progen.games.simlperpg.objs.TestObject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Engine implements IContext {

    private final static String TITLE = "Simple RPG Game";
    private final static int WIDTH = 800, HEIGHT = WIDTH / 12 * 9;
    private final static boolean DEBUG_PRINT_FPS = true;

    private final Window window;
    private final Controls controls;
    private final List<GameObject> objs = new ArrayList<>();

    private boolean running;

    public Engine() {
        this.window = new Window(TITLE, WIDTH, HEIGHT);
        this.controls = new Controls(window.getKeyListener(), window.getMouseListener());
    }

    public void start() {
        if(running) return;
        running = true;

        window.setVisible(true);
        new Thread(this::run).start();
    }

    private void init(){
        objs.add(new TestObject(10, 10, 100, 200));
    }

    private void run() {
        init();

        long lastTime = System.nanoTime();
        int fps = 60;
        double ns = 1000000000;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            boolean updated = false;

            double d = 1.0 / fps;
            while (delta >= d) {
                update();
                if (!running) return;
                if (DEBUG_PRINT_FPS) updates++;
                delta -= d;

                updated = true;
            }

            if (updated) {
                render();
            }

            if (DEBUG_PRINT_FPS) {
                frames++;

                if (System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
                    log.trace("FPS: " + frames + " - TICKS: " + updates);
                    frames = 0;
                    updates = 0;
                }
            }
        }
    }

    private void update() {
        for(int i=0;i<objs.size();i++){
            objs.get(i).update(this);
        }
    }

    private void render() {
        window.render(objs);
    }

    @Override
    public IWindow window() {
        return window;
    }

    @Override
    public Controls controls() {
        return controls;
    }
}
