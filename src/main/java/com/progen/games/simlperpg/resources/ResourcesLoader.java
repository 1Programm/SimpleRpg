package com.progen.games.simlperpg.resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourcesLoader implements IResourceHandler{

    private BufferedImage loadImage(String absPath) { //TODO: Load Error Image on Error
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(absPath));
        } catch (IOException e) {       //TODO: Own Exception
            e.printStackTrace();
        }
        return img;
    }


    @Override
    public Object getResource(String name) {
        return null;
    }
}
