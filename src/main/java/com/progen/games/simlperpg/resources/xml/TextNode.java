package com.progen.games.simlperpg.resources.xml;

class TextNode implements XmlNode {

    private final String value;

    public TextNode(String value) {
        this.value = value;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String attribute(String name) {
        return null;
    }

    @Override
    public XmlNode get(String name) {
        return null;
    }

    @Override
    public void addChild(XmlNode node) {
        throw new IllegalStateException();
    }
}
