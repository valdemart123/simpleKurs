package com.valentyn.product;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ListOfProducts {

    int productId = 0;
    private HashMap<Integer, BaseProduct> productsAssortment = new HashMap<>();

    public ListOfProducts() {
        getListsOfProductsFromXML();
    }

    public void getListsOfProductsFromXML() {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Build Document
            Document document = builder.parse(new File("src/resources/products.xml"));
            //Normalize the XML Structure;
            document.getDocumentElement().normalize();
            //Here the root node
            Element root = document.getDocumentElement();
            System.out.println(root.getNodeName());
            //Get all products from xml list
            NodeList nList = document.getElementsByTagName("product");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    //Print each employee's detail
                    Element product = (Element) node;
                    addProducts(product.getElementsByTagName("title").item(0).getTextContent(),
                            Integer.valueOf(product.getElementsByTagName("quantity").item(0).getTextContent()),
                            Double.valueOf(product.getElementsByTagName("price").item(0).getTextContent()));
                }
            }
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void addProducts(String productTitle, int availableQuantity, double price) {
        productId++;
        BaseProduct product = new BaseProduct(productTitle, availableQuantity, price);
        productsAssortment.put(productId, product);
    }

    public HashMap<Integer, BaseProduct> getProductsAssortment() {
        return productsAssortment;
    }
}
