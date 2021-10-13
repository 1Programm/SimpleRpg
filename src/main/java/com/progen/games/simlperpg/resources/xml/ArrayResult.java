package com.progen.games.simlperpg.resources.xml;

import java.util.List;

class ArrayResult extends BaseNode {

    private final List<XmlNode> children;

    public ArrayResult(String name, List<XmlNode> children) {
        super(name);
        this.children = children;
    }

    @Override
    public String name() {
        return "";
    }

    @Override
    public String value() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for(int i=0;i<children.size();i++){
            if(i != 0){
                sb.append(", ");
            }

            sb.append(children.get(i).value());
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public XmlNode get(String name) {
        try {
            int index = Integer.parseInt(name);
            return children.get(index);
        }
        catch (NumberFormatException e){
            return null;
        }
    }

    @Override
    public void addChild(XmlNode node) {
        children.add(node);
    }
}
