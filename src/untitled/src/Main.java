import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(54321);

            for (int i = 0; i < 2 ; i++) {
                Socket socket = serverSocket.accept();
                new Server(socket).start();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
