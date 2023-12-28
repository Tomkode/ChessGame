package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChessBoard {
    private Map<String, ChessBoardSquare> board;
    public ChessBoard(){

        this.board = new LinkedHashMap<String, ChessBoardSquare>();
        for (int i = 8; i >= 1; i--){
            for (int j = 0; j < 8; j++){
                board.put(String.valueOf((char)((int)'a'+j)) + String.valueOf(i), new ChessBoardSquare(new NullPiece()));
            }
        }
        initializeBoard();
    }
    public String toString(){
        String result = "";
        for (int i = 8; i >= 1; i--){

            for (int j = 0; j < 8; j++){
                result += board.get(String.valueOf((char)((int)'a'+j)) + String.valueOf(i)).toString() + " ";
            }
            result += "<br>";
        }
        return result;
    }
    private Piece removePiece(String x){
        Piece result = board.get(x).getPiece();
        board.get(x).setPiece(new NullPiece());
        return result;
    }
    private void addPiece(String x, Piece piece){
        board.get(x ).setPiece(piece);
    }
    public void movePiece(String start, String end){
        Piece piece = removePiece(start);
        addPiece(end, piece);
    }
    private void initializeBoard(){
        //first iteration -- pawns
        for (int i = 0; i < 8; i++){
            board.get(String.valueOf((char)((int)'a'+i)) + "2").setPiece(new Pawn("white"));
            board.get(String.valueOf((char)((int)'a'+i)) + "7").setPiece(new Pawn("black"));
        }

        //second iteration - the rest of the pieces
        for(int i = 0 ; i < 8 ; i++){
            if(i == 0 || i == 7){
                board.get(String.valueOf((char)((int)'a'+i)) + "1").setPiece(new Rook("white"));
                board.get(String.valueOf((char)((int)'a'+i)) + "8").setPiece(new Rook("black"));
            }
            else if(i == 1 || i == 6){
                board.get(String.valueOf((char)((int)'a'+i)) + "1").setPiece(new Knight("white"));
                board.get(String.valueOf((char)((int)'a'+i)) + "8").setPiece(new Knight("black"));
            }
            else if(i == 2 || i == 5){
                board.get(String.valueOf((char)((int)'a'+i)) + "1").setPiece(new Bishop("white"));
                board.get(String.valueOf((char)((int)'a'+i)) + "8").setPiece(new Bishop("black"));
            }
            else if(i == 3){
                board.get(String.valueOf((char)((int)'a'+i)) + "1").setPiece(new Queen("white"));
                board.get(String.valueOf((char)((int)'a'+i)) + "8").setPiece(new Queen("black"));
            }
            else if(i == 4){
                board.get(String.valueOf((char)((int)'a'+i)) + "1").setPiece(new King("white"));
                board.get(String.valueOf((char)((int)'a'+i)) + "8").setPiece(new King("black"));
            }
        }
    }
    public Map<String, ChessBoardSquare> getBoard(){
        return this.board;
    }
}
