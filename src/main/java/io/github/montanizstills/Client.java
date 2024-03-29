package io.github.montanizstills;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataOutputStream dataOutputStream;


    public void close() {
        try {
            this.dataOutputStream.close();
            this.socket.close();
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    public void write(String message) {
        try {
            this.dataOutputStream = new DataOutputStream(this.socket.getOutputStream());
            this.dataOutputStream.writeUTF(message);
            this.dataOutputStream.flush();
        } catch (IOException e) {
            throw new Error(e);
        }

    }

    public DataOutputStream getDataOutputStream() {
        return dataOutputStream;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        try {
            String message = null;
            client.socket = new Socket("localhost", 1234);
            while (!"q".equalsIgnoreCase(message)) {
                System.out.println("Write a message here:\n");
                message = scanner.nextLine();
                client.write(message);
            }

        } catch (IOException e) {
            throw new Error(e);
        }
    }
}
