package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Pawn extends Piece{
    public Pawn(String color){
        if(color == "black")
        {
            this.imagePath = "images/black-pawn.png";
            this.dx = new ArrayList<Integer>(Arrays.asList(0, 1, -1)); // a-h
            this.dy = new ArrayList<Integer>(Arrays.asList(-1, -1, -1)); // 1-8
        }
        else
        {
            this.imagePath = "images/white-pawn.png";
            this.dx = new ArrayList<Integer>(Arrays.asList(0, 1 ,-1));
            this.dy = new ArrayList<Integer>(Arrays.asList(1, 1, 1));
        }
        this.color = color;


    }
    public String toString(){
        return "Pawn";
    }

    @Override
    public List<String> allPossibleMoves(String start, Map<String, ChessBoardSquare> board) {
        List<String> moves = new ArrayList<String>();
        char x = start.charAt(0);
        char y = start.charAt(1);
        int newX = x + dx.get(0);
        int newY = y + dy.get(0);
        String move = Character.toString((char)newX) + Character.toString((char)newY);
        if(areValidCoordinates(move) && (board.get(move).getPiece().getColor() == null ) )
        {
            moves.add(move);
        }
        if(y == '2' || y == '7')
        {
            newY = y + 2*dy.get(0);
            move = Character.toString((char)newX) + Character.toString((char)newY);
            if(areValidCoordinates(move) && (board.get(move).getPiece().getColor() == null ))
            {
                moves.add(move);
            }
        }
        for(int dir = 1; dir < dx.size(); dir++)
        {
            newX = x + dx.get(dir);
            newY = y + dy.get(dir);
            move = Character.toString((char)newX) + Character.toString((char)newY);
            if(areValidCoordinates(move) && (board.get(move).getPiece().getColor() != null && board.get(move).getPiece().getColor() != this.getColor()))
            {
                moves.add(move);
            }
        }
        return moves;
    }
}
