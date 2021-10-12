package com.progen.games.simlperpg;

public class Engine {
    private boolean running;
    private final boolean debug_print_fps = true;

    public Engine() {



    }

    public void start() {
        run();
    }

    private void run() {

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

            while (delta >= 1f/fps) {
                update();
                if (!running) return;
                if (debug_print_fps) updates++;
                delta--;

                updated = true;
            }

            if (updated) {
                render();
            }

            if (debug_print_fps) {
                frames++;

                if (System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
                    System.out.println("FPS: " + frames + " - TICKS: " + updates);
                    frames = 0;
                    updates = 0;
                }
            }
        }
    }

    private void update() {

    }

    private void render() {

    }
}
