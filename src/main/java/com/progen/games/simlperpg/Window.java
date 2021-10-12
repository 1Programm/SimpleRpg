package com.progen.games.simlperpg;

import com.progen.games.simlperpg.controlls.IKeyListener;
import com.progen.games.simlperpg.controlls.IKeyboard;
import com.progen.games.simlperpg.controlls.IMouse;
import com.progen.games.simlperpg.gfx.IWindow;
import com.progen.games.simlperpg.objs.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame implements IWindow {

    private static class MyKeyListener implements KeyListener, IKeyboard {
        private final List<Integer> keys = new ArrayList<>();
        private final List<IKeyListener> listeners = new ArrayList<>();

        @Override
        public void keyTyped(KeyEvent e) { }

        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            if(!keys.contains(keycode)){
                runAction(keycode, true);
                keys.add(keycode);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keycode = e.getKeyCode();
            if(keys.remove((Object)keycode)){
                runAction(keycode, false);
            }
        }

        @Override
        public boolean is(int keycode){
            return keys.contains(keycode);
        }

        private void runAction(int keyCode, boolean pressed){
            for(int i=0;i<listeners.size();i++){
                listeners.get(i).onKeyAction(keyCode, pressed);
            }
        }

        @Override
        public void listen(IKeyListener listener) {
            listeners.add(listener);
        }
    }

    private static class MyMouseListener implements MouseListener, MouseMotionListener, IMouse {

        private int x, y;
        private boolean left, right, middle;

        @Override
        public void mouseClicked(MouseEvent e) { }

        @Override
        public void mousePressed(MouseEvent e) {
            buttonAction(e.getButton(), true);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            buttonAction(e.getButton(), false);
        }

        private void buttonAction(int button, boolean pressed){
            if(button == 1){
                left = pressed;
            }
            else if(button == 2){
                right = pressed;
            }
            else if(button == 3){
                middle = pressed;
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }

        @Override
        public void mouseDragged(MouseEvent e) {
            this.x = e.getX();
            this.y = e.getY();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            this.x = e.getX();
            this.y = e.getY();
        }

        @Override
        public int x() {
            return x;
        }

        @Override
        public int y() {
            return y;
        }

        @Override
        public boolean buttonLeft() {
            return left;
        }

        @Override
        public boolean buttonRight() {
            return right;
        }

        @Override
        public boolean buttonMiddle() {
            return middle;
        }
    }


    private final Canvas canvas = new Canvas();
    private final MyKeyListener keyListener = new MyKeyListener();
    private final MyMouseListener mouseListener = new MyMouseListener();

    public Window (String title, int width, int height) {
        this.setTitle(title);
        this.setSize(width,height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        canvas.addKeyListener(keyListener);
        canvas.addMouseListener(mouseListener);
        canvas.addMouseMotionListener(mouseListener);

        this.add(canvas);
        this.setLocationRelativeTo(null);
    }

    public void render(List<GameObject> objs){
        BufferStrategy bs = canvas.getBufferStrategy();

        if(bs == null){
            canvas.createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for(int i=0;i<objs.size();i++){
            objs.get(i).render(g);
        }

        g.dispose();
        bs.show();
    }

    public IKeyboard getKeyListener() {
        return keyListener;
    }

    public MyMouseListener getMouseListener() {
        return mouseListener;
    }

    @Override
    public int width() {
        return canvas.getWidth();
    }

    @Override
    public int height() {
        return canvas.getHeight();
    }
}
