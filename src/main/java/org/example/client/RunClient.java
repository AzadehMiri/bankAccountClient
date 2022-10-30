package org.example.client;

import org.example.model.Server;
import org.example.model.Transaction;
import org.example.service.WriteXml;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class RunClient {

    public static void runClient(String responsePath,Server server, List<Transaction> transactions) {
        try {
            Socket socket = new Socket(server.getServerIp(), server.getPortNumber());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            for (Transaction transaction : transactions) {
                outputStream.writeObject(transaction);
                Transaction inputTransaction=(Transaction) inputStream.readObject();

               WriteXml.writeResponseToXml(responsePath,inputTransaction);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | ParserConfigurationException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}

