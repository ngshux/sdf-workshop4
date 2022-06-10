package vtp2022.day4.workshop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String portNumber = args [0];
        String cookieFilePath = args [1];

        try {
            System.out.printf("Cookie Server started at %s\n", portNumber);
        
            ServerSocket server = new ServerSocket(Integer.parseInt(portNumber));
            Socket sock = server.accept();
            
            InputStream is = sock.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            OutputStream os = sock.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            String clientInput = dis.readUTF();
            System.out.printf("Command sent: %s", clientInput);

            if(clientInput.equals("get-cookie")){
                String randomCookie = Cookie.ChooseCookies(cookieFilePath);
                System.out.println("This is a random cookie!: "+ randomCookie);
                dos.writeUTF("cooki!" +randomCookie);
            }
            else
                dos.writeUTF("Invalid command");
        
            is.close();
            os.close();
            sock.close();
        }
            catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } 

    }


}
