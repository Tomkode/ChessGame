package Communication;
import Model.ChessBoard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
public class Server {
    private final int portNumber = 7070;
    private ServerSocket serverSocket;
    private Socket clientSocket1;
    private Socket clientSocket2;
    private boolean allPlayersConnected = false;
    private boolean onePlayerConnected = false;
    private ChessBoard board;
    public Server(){
        try{
            serverSocket = new ServerSocket(portNumber);
            this.board = new ChessBoard();
        }catch(Exception e){
            System.out.println("Error in Server.java");
        }
    }
    public void awaitConnections(){
        try{
            clientSocket1 = serverSocket.accept();
            onePlayerConnected = true;
            clientSocket2 = serverSocket.accept();
            allPlayersConnected = true;
        }catch(Exception e){
            System.out.println("Error in Server.java");
        }
    }
    public boolean allPlayersConnected(){
        return allPlayersConnected;
    }
    public boolean onePlayerConnected(){
        return onePlayerConnected;
    }
    public void send(String message, int player){
        try{
            Socket toSend = clientSocket1;
            if(player == 2) {
                toSend = clientSocket2;
            }
            PrintWriter out = new PrintWriter(toSend.getOutputStream(), true);
            out.println(message);
            out.close();
        }catch(Exception e){
            System.out.println("Error in Server.java");
        }
    }
    public String receive(int player){
        try{
            Socket toReceive = clientSocket1;
            if(player == 2) {
                toReceive = clientSocket2;
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(toReceive.getInputStream()));
            String temp = in.readLine();
            in.close();
            return temp;
        }catch(Exception e){
            System.out.println("Error in Server.java");
        }
        return "";
    }

    public ChessBoard getBoard() {
        return board;
    }
}
