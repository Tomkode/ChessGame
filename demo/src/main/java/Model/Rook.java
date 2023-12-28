package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rook extends Piece{
    public Rook(String color){
        if(color == "black")
            this.imagePath = "images/black-rook.png";
        else
            this.imagePath = "images/white-rook.png";
        this.color = color;
        this.dx = new ArrayList<Integer>(Arrays.asList(1, 0, -1, 0));
        this.dy = new ArrayList<Integer>(Arrays.asList(0, -1, 0, 1));

    }
    public String toString(){
        return "Rook";
    }


}
