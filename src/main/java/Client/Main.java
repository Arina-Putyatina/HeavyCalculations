package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        int port = 25555;
        Socket socket = new Socket("127.0.0.1", port);

        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("Введите номер числа из ряда Фибоначи или end");
                String result = scanner.nextLine();
                out.println(result);
                if (result.equals("end")) {
                    break;
                }
                System.out.printf("%s-е число из ряда Фибоначи = %s\n", result, in.readLine());
            }
        }
    }

}
