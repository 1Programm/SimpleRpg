package com.progen.games.simlperpg.objs;

import com.progen.games.simlperpg.engine.IContext;
import com.progen.games.simlperpg.msg.TextMessage;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;

@Slf4j
public class MsgDude2 extends GameObject {

    //TODO: Some kind of init method for GameObjects which also gives access to IContext
    private boolean initialized = false;
    private float timer;
    private boolean stopped = true;
    private int dir = 1;

    public MsgDude2(float x, float y, float width, float height) {
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
            this.x += MsgDude1.SPEED * dir;

            if(this.x + this.width > ctx.window().width()){
                this.x = ctx.window().width() - this.width;
                timer = MsgDude1.TIME - timer;
                ctx.messages().send(new TextMessage("TURN 1!"));
                dir *= -1;
            }
            else if(this.x < 0){
                this.x = 0;
                timer = MsgDude1.TIME - timer;
                ctx.messages().send(new TextMessage("TURN 1!"));
                dir *= -1;
            }
        }
        else if(!stopped){
            stopped = true;
            ctx.messages().send(new TextMessage("GO 1!"));
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x,(int)y, (int)width, (int)height);
        g.setColor(Color.WHITE);
        g.drawString("Dude 2", (int)x + 5, (int)y + 20);
    }

    private void onTextMessage(TextMessage msg){
//        log.info(msg.getMessage());
        
        if(msg.getMessage().equals("GO 2!")){
            timer = MsgDude1.TIME;
            stopped = false;
        }
        else if(msg.getMessage().equals("TURN 2!")){
            dir *= -1;
        }
    }
}
