package com.progen.games.simlperpg;

import com.progen.games.simlperpg.controlls.Controls;
import com.progen.games.simlperpg.engine.IContext;
import com.progen.games.simlperpg.gfx.IWindow;
import com.progen.games.simlperpg.msg.IMessageHandler;
import com.progen.games.simlperpg.msg.MessageStack;
import com.progen.games.simlperpg.objs.GameObject;
import com.progen.games.simlperpg.world.GameWorld;
import com.progen.games.simlperpg.world.IWorld;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Engine implements IContext {

    private final static boolean DEBUG_PRINT_FPS = false;

    private final Window window;
    private final Controls controls;
    private final GameWorld world;
    private final MessageStack messages;

    private boolean running;

    public Engine(String title, int width, int height) {
        this.window = new Window(title, width, height);
        this.controls = new Controls(window.getKeyListener(), window.getMouseListener());
        this.world = new GameWorld();
        this.messages = new MessageStack();
    }

    public void start() {
        if(running) return;
        running = true;

        window.setVisible(true);
        new Thread(this::run).start();
    }

    private void init(){
        world.init();
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
        messages.handleMessages();
        world.update(this);
    }

    private void render() {
        List<GameObject> visibleObjects = world.getVisibleObjects();
        window.render(world, visibleObjects);
    }

    @Override
    public IWindow window() {
        return window;
    }

    @Override
    public Controls controls() {
        return controls;
    }

    @Override
    public IWorld world() {
        return world;
    }

    @Override
    public IMessageHandler messages() {
        return messages;
    }
}
