package Server;

import java.net.*;
import java.io.*;


//servo klase
public class Server extends Thread {

    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    @Override
    public void run()
    {
        try
        {
            server = new ServerSocket(5000);
            System.out.println("Server.Server started");
            System.out.println("Waiting for a client...");
            socket = server.accept();
            System.out.println("Server.Client accepted");

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";

            while (!line.equals("Over"))
            {
                try
                {
                    line = in.readUTF();
                    System.out.println(line);
                }
                catch (IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
            socket.close();
            in.close();
        }
        catch (IOException i)
        {
            System.out.println(i);
        }
    }
/*    public static void main(String args[])
    {
        Server server = new Server(5000);
    }*/
}
