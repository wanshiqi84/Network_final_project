import java.io.*;
import java.net.*;

public class Node {
    public static void main(String[] args) throws IOException {
        int nodeId = Integer.parseInt(args[0]);
        int port = 8080 + nodeId;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Node " + nodeId + " is running on port " + port);

        new Thread(() -> {
            try {
                while (true) {
                    Socket socket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String message = in.readLine();
                    System.out.println("Node " + nodeId + " received: " + message);
                    in.close();
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(10000); // Wait for other nodes to be up
                for (int i = 1; i <= 10; i++) {
                    if (i != nodeId) {
                        try {
                            Socket socket = new Socket("node" + i, 8080 + i);
                            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                            out.println("Hello from Node " + nodeId + "!");
                            out.close();
                            socket.close();
                        } catch (IOException e) {
                            System.out.println("Node " + nodeId + " couldn't connect to Node " + i);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
