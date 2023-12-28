package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Knight extends Piece{
    public Knight(String color){
        if(color == "black")
            this.imagePath = "images/black-knight.png";
        else
            this.imagePath = "images/white-knight.png";
        this.color = color;
        this.dx = new ArrayList<Integer>(Arrays.asList(2,2,1, -1, -2, -2, -1, 1));
        this.dy = new ArrayList<Integer>(Arrays.asList(-1,1,2, 2, 1, -1, -2, -2));

    }
    public String toString(){
        return "Knight";
    }

    @Override
    public List<String> allPossibleMoves(String start, Map<String, ChessBoardSquare> board) {
        List<String> moves = new ArrayList<String>();
        char x = start.charAt(0);
        char y = start.charAt(1);
        for(int dir = 0; dir < dx.size(); dir++)
        {
            int newX = x + dx.get(dir);
            int newY = y + dy.get(dir);
            String move = Character.toString((char)newX) + Character.toString((char)newY);
            if(areValidCoordinates(move) && (board.get(move).getPiece().getColor() == null || board.get(move).getPiece().getColor() != this.getColor()))
            {
                moves.add(move);
            }
        }


        return moves;
    }

}
