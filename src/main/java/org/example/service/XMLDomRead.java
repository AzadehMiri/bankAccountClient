package org.example.service;

import org.example.model.Transaction;
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
import java.util.ArrayList;
import java.util.List;

public class XMLDomRead {
    public static List<Transaction> xmlParser(String filePath) throws IOException, ParserConfigurationException, SAXException {
        List<Transaction> transactionList = new ArrayList<Transaction>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(filePath));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("transaction");
        NodeList n1List = document.getElementsByTagName("terminal");
        Node node1 = n1List.item(0);
        Element eElement1 = (Element) node1;
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                Transaction transaction = new Transaction();
                transaction.setId(Long.parseLong(eElement.getAttribute("id")));
                transaction.setTransactionType(eElement.getAttribute("type"));
                transaction.setTransactionAmount(Integer.valueOf(eElement.getAttribute("amount")));
                transaction.setDepositNumber(Long.parseLong(eElement.getAttribute("deposit")));
                transaction.setTerminalId(Long.parseLong(eElement1.getAttribute("id")));
                transaction.setTerminalType(eElement1.getAttribute("type"));
                transactionList.add(transaction);
            }
        }
        return transactionList;
    }
}



