package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queen extends Piece{
    public Queen(String color){
        if(color=="black")
            this.imagePath = "images/black-queen.png";
        else
            this.imagePath = "images/white-queen.png";
        this.color = color;
        this.dx = new ArrayList<Integer>(Arrays.asList(1, 0, -1, 0, 1 , -1, 1, -1));
        this.dy = new ArrayList<Integer>(Arrays.asList(0, -1, 0, 1, 1, -1, -1, 1));

    }
    public String toString(){
        return "Queen";
    }


}
