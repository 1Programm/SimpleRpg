package com.progen.games.simlperpg.resources.xml;

import java.util.ArrayList;
import java.util.List;

class GroupNode extends BaseNode {

    private final String content;
    protected final List<XmlNode> children;

    public GroupNode(String name, String content, List<XmlNode> children) {
        super(name);
        this.content = content;
        this.children = children;
    }

    @Override
    public String value() {
        return content;
    }

    @Override
    public XmlNode get(String name) {
        try {
            int index = Integer.parseInt(name);
            return children.get(index);
        }
        catch (NumberFormatException e){
            //Try to group by name
            List<XmlNode> result = new ArrayList<>();
            for(XmlNode child : children){
                if(name.equals(child.name())){
                    result.add(child);
                }
            }

            if(result.size() == 1){
                return result.get(0);
            }
            else if(!result.isEmpty()){
                return new ArrayResult(name(), children);
            }
        }

        return null;
    }

    @Override
    public void addChild(XmlNode node) {
        children.add(node);
    }


}
