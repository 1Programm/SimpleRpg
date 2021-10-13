package com.progen.games.simlperpg.resources.xml;

public interface XmlNode {

    String name();

    String value();

    String attribute(String name);

    XmlNode get(String name);

    void addChild(XmlNode node);

}
