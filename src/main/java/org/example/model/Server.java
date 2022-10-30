package org.example.model;

public class Server {
    private int portNumber;
    private String serverIp;

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    @Override
    public String toString() {
        return "Server{" +
                "portNumber=" + portNumber +
                ", serverIp='" + serverIp + '\'' +
                '}';
    }
}
