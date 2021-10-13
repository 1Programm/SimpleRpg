package com.progen.games.simlperpg.resources.xml;

import java.util.List;

class WrapperNode extends GroupNode{

    public WrapperNode(String name, String content, List<XmlNode> children) {
        super(name, content, children);
    }

    @Override
    public String value() {
        if(children.size() != 1){
            return  "<" + name() + ">" + super.value() + "</" + name() + ">";
        }

        return super.value();
    }

}
