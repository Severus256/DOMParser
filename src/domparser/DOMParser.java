/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domparser;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Aga
 */
public class DOMParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("src/domparser/config.xml"));
      //  String element = doc.getDocumentElement().getNodeName();
       // System.out.println("Root: " + element);

        // NodeList хранит список node объектов, каждый из которых - элемент XML документа
        NodeList list = doc.getElementsByTagName("product");
        
        String title="";
        String price = "";
        int amount = 0;
        
        // выпишем список всех атрибутов продуктов из XML
        for (int i = 0; i <list.getLength(); i++) {
            Element element = (Element)list.item(i);
            title =  element.getElementsByTagName("title").item(0).getChildNodes().item(0).getNodeValue(); // получаем самый первый node из nodelist у title
            price =  element.getElementsByTagName("price").item(0).getChildNodes().item(0).getNodeValue();
            amount =  (Integer.parseInt(element.getElementsByTagName("amount").item(0).getChildNodes().item(0).getNodeValue()));
            System.out.println("Название продукта: "+title+"\n");
            System.out.println("Цена продукта: "+price+"\n");
            System.out.println("Количество: "+amount+"\n");
        }

    }

}
