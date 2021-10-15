package com.progen.games.simlperpg.resources;

public interface IResourceHandler {

    void loadMap(String absPath);
    Object getResource(String name);
    String rootPath();
}
