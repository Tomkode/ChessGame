package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bishop extends Piece{
    public Bishop(String color){
        if(color == "black")
            this.imagePath = "images/black-bishop.png";
        else
            this.imagePath = "images/white-bishop.png";
        this.color = color;
        this.dx = new ArrayList<Integer>(Arrays.asList(1,1,-1, -1));
        this.dy = new ArrayList<Integer>(Arrays.asList(1,-1,1, -1));

    }
    public String toString(){
        return "Bishop";
    }

}
