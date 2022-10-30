package org.example.service;

import org.example.model.Transaction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class WriteXml {
    public static void writeResponseToXml(String path, Transaction transaction) throws ParserConfigurationException, TransformerException {
        File myFile = new File(path);
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("transactions");
        doc.appendChild(rootElement);

        //deposit Node
        Element transactionNode = doc.createElement("transaction");
        rootElement.appendChild(transactionNode);

        //Set attribute for transaction
        Element depositNumber = doc.createElement("depositNumber");
        depositNumber.appendChild(doc.createTextNode(transaction.getDepositNumber().toString()));
        transactionNode.appendChild(depositNumber);

        // AccountBalance Node
        Element accountBalance = doc.createElement("newAccountBalance");
        accountBalance.appendChild(doc.createTextNode(transaction.getAccountBalance().toString()));
        transactionNode.appendChild(accountBalance);

        writeToXmlFile(doc, myFile);
    }

    public static void writeToXmlFile(Document doc, File myFile) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(myFile);

        transformer.transform(source, result);
    }
}
