package Server;

import java.net.*;
import java.io.*;

//client klase
public class Client extends Thread
{
        private Socket socket = null;
        private DataInputStream input = null;
        private DataOutputStream out = null;

        @Override
        public void run()
        {
                try
                {
                        socket = new Socket("127.0.0.1",5000);
                        System.out.println("connected");

                        input = new DataInputStream(System.in);

                        out = new DataOutputStream(socket.getOutputStream());

                }
                catch (UnknownHostException u)
                {
                        System.out.println(u);
                }
                catch (IOException i)
                {
                        System.out.println(i);
                }
                String line = "";
                while (!line.equals("Over"))
                {
                        try
                        {
                                line = input.readLine();
                                out.writeUTF(line);
                        }
                        catch (IOException i)
                        {
                                System.out.println(i);
                        }
                }
                try
                {
                        input.close();
                        out.close();
                        socket.close();
                }
                catch (IOException i)
                {
                        System.out.println(i);
                }
        }
/*        public static void main (String args[])
        {
                Client client = new Client("127.0.0.1", 5000);
        }*/
}