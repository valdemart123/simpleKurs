package com.valentyn.discount;

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

public class DiscountVoucher {

    private HashMap<String, Integer> discount = new HashMap<>();

    public DiscountVoucher() {
        getListsOfDiscountFromXML();

    }

    private void getListsOfDiscountFromXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Build Document
            Document document = builder.parse(new File("src/resources/vouchers.xml"));
            //Normalize the XML Structure;
            document.getDocumentElement().normalize();
            //Here the root node
            Element root = document.getDocumentElement();
            System.out.println(root.getNodeName());
            //Get all products from xml list
            NodeList nList = document.getElementsByTagName("voucher");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element discountValue = (Element) node;
                    discount.put(discountValue.getElementsByTagName("vouchercode").item(0).getTextContent(),
                            Integer.valueOf(discountValue.getElementsByTagName("percent").item(0).getTextContent()));
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

    public HashMap getVouchers() {
        return discount;
    }
}
