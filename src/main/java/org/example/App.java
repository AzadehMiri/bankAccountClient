package org.example;

import org.example.client.RunClient;
import org.example.model.Server;
import org.example.model.Transaction;
import org.example.service.Configuration;
import org.example.service.XMLDomRead;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        Server server = new Server();
        Configuration.ipAndPortConfig("src\\main\\resources\\terminal.xml", server);

        List<Transaction> transactionList = XMLDomRead.xmlParser("src\\main\\resources\\terminal.xml");

        RunClient.runClient("C:\\Users\\Azadeh\\Desktop\\response.xml", server, transactionList);
    }
}
