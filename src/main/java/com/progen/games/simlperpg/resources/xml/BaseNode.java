package com.progen.games.simlperpg.resources.xml;

import java.util.HashMap;
import java.util.Map;

abstract class BaseNode implements XmlNode {

    private final String name;
    final Map<String, String> attributes = new HashMap<>();

    public BaseNode(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String attribute(String name) {
        return attributes.get(name);
    }

    @Override
    public String toString() {
        return value();
    }
}
