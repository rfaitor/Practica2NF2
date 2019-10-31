package iam46258177;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Scanner;

public class SeleccioDOM_XML {

    public static void main(String argv[]) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Scanner scanner = new Scanner(System.in);
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("data/produkte.xml"));
            document.getDocumentElement().normalize();

            NodeList content = document.getElementsByTagName("area");

            Node ar = content.item(0);


            if (ar.getNodeType() == Node.ELEMENT_NODE) {

                Element elemento = (Element) ar;
                NodeList informacio = elemento.getElementsByTagName("element");

                System.out.println(informacio.item(0).getAttributes().getNamedItem("header").getTextContent());
                System.out.println("\n----------------------------------------------");
                for (int i = 1; i < informacio.getLength(); i ++) {

                    Node area = informacio.item(i);
                    //System.out.println("ID: " + getNodo("element", elemento));
                    System.out.println(i+") "+area.getAttributes().getNamedItem("header").getTextContent());

                }
                System.out.println("----------------------------------------------");
                System.out.print(">> Introdueix el número del curs del que vols informació: ");
                int numero = scanner.nextInt();
                System.out.println("\nCurs: " + informacio.item(numero).getAttributes().getNamedItem("header").getTextContent());
                System.out.println("\nInformació del curs: \n" + informacio.item(numero).getAttributes()
                        .getNamedItem("text").getTextContent());
            }





        } catch (Exception e) { e.printStackTrace();}
    }
}
