package com.progen.games.simlperpg.objs;

import com.progen.games.simlperpg.engine.IContext;
import com.progen.games.simlperpg.msg.TextMessage;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;

@Slf4j
public class MsgDude1 extends GameObject {

    public static final float SPEED = 3;
    public static final int TIME = 50 * 2;

    //TODO: Some kind of init method for GameObjects which also gives access to IContext
    private boolean initialized = false;
    private float timer;
    private boolean stopped;
    private int dir = 1;

    public MsgDude1(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public void update(IContext ctx) {
        if(!initialized){
            initialized = true;
            ctx.messages().listenFor(TextMessage.class, this::onTextMessage);
        }

        if(timer > 0) {
            timer--;
            this.x += SPEED * dir;

            if(this.x + this.width > ctx.window().width()){
                this.x = ctx.window().width() - this.width;
                timer = TIME - timer;
                ctx.messages().send(new TextMessage("TURN 2!"));
                dir *= -1;
            }
            else if(this.x < 0){
                this.x = 0;
                timer = TIME - timer;
                ctx.messages().send(new TextMessage("TURN 2!"));
                dir *= -1;
            }
        }
        else if(!stopped){
            stopped = true;
            ctx.messages().send(new TextMessage("GO 2!"));
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x,(int)y, (int)width, (int)height);
        g.setColor(Color.WHITE);
        g.drawString("Dude 1", (int)x + 5, (int)y + 20);
    }

    private void onTextMessage(TextMessage msg){
//        log.info(msg.getMessage());

        if(msg.getMessage().equals("GO 1!")){
            timer = TIME;
            stopped = false;
        }
        else if(msg.getMessage().equals("TURN 1!")){
            dir *= -1;
        }
    }
}
