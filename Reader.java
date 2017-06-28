/**
 * Created by Stan Gilstrap on 2/20/2017.
 */
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Reader//Reads XML file and creates a binary tree in memory
{
    public BinaryTree theTree = new BinaryTree();
    public Reader (String fileName) throws IOException, SAXException
    {
        try
        {
            File xmlFile = new  File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("behavior = " + doc.getDocumentElement().getNodeName());//prints out name of root
            theTree.addNode(50,doc.getDocumentElement().getNodeName());//adds root node
            NodeList nList = doc.getElementsByTagName("node");
            for (int i = 0; i < nList.getLength(); i++ )
            {
                Node nNode = nList.item(i);

                if(nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) nNode;
                    System.out.println(element.getAttribute("") + element.getAttribute("id"));


                    if(element.getAttribute("response").isEmpty())
                    {
                        System.out.println("    behavior = "+element.getAttribute("behavior"));

                        theTree.addNode(Integer.parseInt(element.getAttribute("key")), element.getAttribute("behavior"));
                    }else
                    {
                        System.out.println("        response = "+element.getAttribute("response"));

                        theTree.addNode(Integer.parseInt(element.getAttribute("key")), element.getAttribute("response"));
                    }
                }
            }
        } catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
    }
}


