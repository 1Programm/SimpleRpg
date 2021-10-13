package com.progen.games.simlperpg.resources.xml;

import com.progen.games.simlperpg.utils.FileUtils;
import com.progen.games.simlperpg.utils.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlBuilder {

    public static XmlNode fromFile(File file) throws IOException {
        String content = FileUtils.read(file);
        return XmlBuilder.fromString(content);
    }

    public static XmlNode fromString(String xmlText) {
        List<XmlNode> children = loadChildren(xmlText);

        if(children.size() == 1) {
            return children.get(0);
        }

        return new WrapperNode("ROOT", xmlText, children);
    }

    private static List<XmlNode> loadChildren(String content){
        List<XmlNode> nodes = new ArrayList<>();

        int index = 0;
        int end = content.length();

        while(index < end){
            int nextOpen = content.indexOf('<', index);
            if(nextOpen == -1 || nextOpen > end) break;

            String before = content.substring(index, nextOpen);
            before = before.trim();
            if(!before.equals("")){
                TextNode textNode = new TextNode(before);
                nodes.add(textNode);
                index = nextOpen;
            }

            if(nextOpen + 3 < content.length() && content.startsWith("<!--", nextOpen)){
                int nextCommentClose = content.indexOf("-->", nextOpen);
                if(nextCommentClose != -1) {
                    index = nextCommentClose + 3;
                }

                continue;
            }

            int nextClose = content.indexOf('>', nextOpen);
            if(nextClose == -1 || nextClose > end) break;

            String attributeText = content.substring(nextOpen + 1, nextClose);
            attributeText = attributeText.trim();

            if(attributeText.equals("")) break;

            String[] attributes = attributeText.split(" ");
            String name = attributes[0];

            int contentClose = StringUtils.findClosing(content, nextClose, "<" + name, "</" + name, "<!--", "-->");
            if(contentClose == -1 || contentClose > end) break;


            String childContent = content.substring(nextClose + 1, contentClose);
            List<XmlNode> childChildren = loadChildren(childContent);

            Map<String, String> attributeMap = new HashMap<>();
            for(int i=1;i<attributes.length;i++){
                String[] keyVal = StringUtils.advancedSplit(attributes[i], "=", "\"", "\"");
                attributeMap.put(keyVal[0], keyVal[1]);
            }

            if(childChildren.isEmpty()){
                GroupNode groupNode = new GroupNode(name, childContent, childChildren);
                groupNode.attributes.putAll(attributeMap);
                nodes.add(groupNode);
            }
            else if(childChildren.size() == 1 && childChildren.get(0) instanceof TextNode){
                GroupNode groupNode = new GroupNode(name, childContent, new ArrayList<>());
                groupNode.attributes.putAll(attributeMap);
                nodes.add(groupNode);
            }
            else {
                GroupNode groupNode = new GroupNode(name, childContent, childChildren);
                groupNode.attributes.putAll(attributeMap);
                nodes.add(groupNode);
            }


            int contentCloseEnd = StringUtils.findClosing(content, contentClose + 1, "<", ">", "\"", "\"");
            if(contentCloseEnd == -1) break;

            index = contentCloseEnd + 1;
        }

        if(index < end){
            String rest = content.substring(index, end);
            rest = rest.trim();
            if(!rest.equals("")){
                TextNode textNode = new TextNode(rest);
                nodes.add(textNode);
            }
        }

        return nodes;
    }

}
