package com.progen.games.simlperpg.resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ResourcesLoader implements IResourceHandler{

    private final String rootPath;
    private final Map<String, Object> map = new HashMap<>();

    public ResourcesLoader(String rootPath) {
        this.rootPath = rootPath;
    }

    private BufferedImage loadImage(String absPath) { //TODO: Load Error Image on Error
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(absPath));
        } catch (IOException e) {                     //TODO: Own Exception
            e.printStackTrace();
        }
        return img;
    }


    @Override
    public void loadMap(String absPath) {
//        BufferedReader reader = new BufferedReader();
//        ResourcesLoader.class.getResource()
    }

    @Override
    public Object getResource(String name) {
        return null;
    }

    @Override
    public String rootPath() {
        return rootPath;
    }
}
