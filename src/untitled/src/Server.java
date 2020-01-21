import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Server extends Thread{

    public static DataOutputStream out;
    public static DataInputStream in;
    public static Socket socket;
    public static String name;

    Server(Socket socket){
        try{
            this.socket = socket;
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            name = in.readUTF();
            System.out.println("Nazwa klienta to: " + name);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
