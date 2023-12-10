 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author fabio
 */
public class DOMTest1 {
    public static void main(String[] args) throws Exception{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(DOMTest1.class.getResourceAsStream("/com/fabzdev/xml/dataBaseCon.xml"));
    
//        System.out.println(doc.getNodeName());
//        System.out.println(doc.getNodeValue());
    
        NodeList nodes = doc.getChildNodes();
        Node connectionListNode = null;
        for(int i=0;i<nodes.getLength();i++){
            Node node = nodes.item(i);
            System.out.println("Node: " + node.getNodeName());
            if(node.getNodeName().equals("connectionList")){
                connectionListNode = node;
            }
        }
        if (connectionListNode != null){
            System.out.println("connectionList found\n");
            NodeList conectionNodes = connectionListNode.getChildNodes();
            for(int i =0; i<conectionNodes.getLength();i++){
                Node nodeTemp = conectionNodes.item(i);
                System.out.println(nodeTemp.getNodeName());
            }
        }
        
        
    }
}
