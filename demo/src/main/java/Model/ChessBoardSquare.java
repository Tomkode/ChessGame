package Model;

public class ChessBoardSquare {
    private Piece piece;
    public ChessBoardSquare(){
        piece = null;
    }
    public ChessBoardSquare(Piece piece){
        this.piece = piece;
    }
    public String getColor(){
        return piece.getColor();
    }
    public Piece getPiece(){
        return piece;
    }
    public void setPiece(Piece piece){
        this.piece = piece;
    }
    public String toString(){
        return piece.toString();
    }
}
