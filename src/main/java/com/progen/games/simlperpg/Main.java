package com.progen.games.simlperpg;

public class Main {

    public static void main(String[] args) {
        Window window = new Window("Cool Title n stuff", 200, 200);
        window.setVisible(true);

        while(true) {
            window.render();
        }
    }

}
