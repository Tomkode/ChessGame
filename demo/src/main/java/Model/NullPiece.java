package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class NullPiece extends Piece{
    public NullPiece(){
        this.imagePath = "";
        this.color = null;
        this.dx = null;
        this.dy = null;
    }
    public String toString(){
        return "NullPiece";
    }

    @Override
    public List<String> allPossibleMoves(String start, Map<String, ChessBoardSquare> board) {
        return null;
    }
}
