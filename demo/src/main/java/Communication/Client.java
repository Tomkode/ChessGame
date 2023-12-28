package Communication;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
public class Client {
    private final int portNumber = 7070;
    private Socket clientSocket;
    public Client(){
        try{
            clientSocket = new Socket("localhost", portNumber);
        }catch(Exception e){
            System.out.println("Error in Client.java");
        }
    }
    public void send(String message){
        try{
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(message);
            out.close();
        }catch(Exception e){
            System.out.println("Error in Client.java");
        }
    }
    public String receive(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String temp = in.readLine();
            in.close();
            return temp;
        }catch(Exception e){
            System.out.println("Error in Client.java");
        }
        return "";
    }
}
