package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {

        int port = 25555;
        ServerSocket serverSocket = new ServerSocket(port);

        try (Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            while (true) {
                String stringN = in.readLine();
                if (stringN.equals("end")) {
                    break;
                }
                int n = Integer.parseInt(stringN);
                out.println(calculateFibonacciNumber(n));
            }
        }
    }

    public static int calculateFibonacciNumber(int n) {
        if (n <= 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return calculateFibonacciNumber(n - 1) + calculateFibonacciNumber(n - 2);
        }
    }

}
