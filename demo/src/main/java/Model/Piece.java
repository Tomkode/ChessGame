package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Piece{
    protected String imagePath; // TODO: Implement this
    protected String color;
    protected ArrayList<Integer> dx;
    protected ArrayList<Integer> dy; // These are the direction vectors for the pieces

    public String getImagePath() {
        return imagePath;
    }
    public String getColor() {
        return color;
    }
    public ArrayList<Integer> getDx() {
        return dx;
    }
    public ArrayList<Integer> getDy() {
        return dy;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setDx(ArrayList<Integer> dx) {
        this.dx = dx;
    }
    public void setDy(ArrayList<Integer> dy) {
        this.dy = dy;
    }
    public boolean areValidCoordinates(int x, int y){
        return (x>=0 && x<8 && y>=0 && y<8);
    }
    public boolean areValidCoordinates(String coordinate){
        char x = coordinate.charAt(0);
        char y = coordinate.charAt(1);

        return (x>='a' && x<='h' && y>='1' && y<='8');
    }
    public List<String> allPossibleMoves(String start, Map<String, ChessBoardSquare> board){
        List<String> moves = new ArrayList<String>();
        char x = start.charAt(0);
        char y = start.charAt(1);
        for(int i = 0; i < dx.size(); i++)
        {
            int newX = x + dx.get(i);
            int newY = y + dy.get(i);
            String move = Character.toString((char)newX) + Character.toString((char)newY);
            while(areValidCoordinates(move))
            {
                if(! (board.get(move).getPiece() instanceof NullPiece) && board.get(move).getPiece().getColor() == this.getColor())
                    break;
                moves.add(move);
                if(! (board.get(move).getPiece() instanceof NullPiece))
                    break;
                newX = newX + dx.get(i);
                newY = newY + dy.get(i);
                move = Character.toString((char)newX) + Character.toString((char)newY);


            }
        }
        return moves;
    }
    }

