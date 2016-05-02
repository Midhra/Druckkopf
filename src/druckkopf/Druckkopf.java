/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package druckkopf;
import java.io.*;
import java.net.*;

/**
 *
 * @author debian
 */
public class Druckkopf {

  static String line;
  static BufferedReader fromClient;
  static DataOutputStream toClient;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        String line; boolean verbunden;
        ServerSocket listenSocket = new ServerSocket(9998);
        while (true){
            Socket cliSocket = listenSocket.accept();
            verbunden = true;
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(cliSocket.getInputStream()));
            DataOutputStream toClient = new DataOutputStream(cliSocket.getOutputStream());
            while(verbunden){
                line = fromClient.readLine();
                verbunden = false;
                System.out.println(line);
                toClient.writeBytes("success" + '\n');
            } // end while verbunden
            toClient.close();
            cliSocket.close();
        } // end repeat forever
    
        }
        catch(IOException e){
    
        }
    }
}