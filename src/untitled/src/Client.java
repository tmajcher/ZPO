import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 54321);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            Scanner scan = new Scanner(System.in);
            System.out.println("Nazwij klienta");
            String name = scan.nextLine();
            out.writeUTF(name);

            socket.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
