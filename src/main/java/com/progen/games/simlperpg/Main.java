package com.progen.games.simlperpg;

public class Main {

    private final static String TITLE = "Simple RPG Game";
    private final static int WIDTH = 800, HEIGHT = WIDTH / 12 * 9;

    public static void main(String[] args) {
        Engine engine = new Engine(TITLE, WIDTH, HEIGHT);
        engine.start();
    }

}
