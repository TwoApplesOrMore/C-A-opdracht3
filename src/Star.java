import java.util.ArrayList;

public class Star {

    private char colour;
    private int number;
    private ArrayList<Star> neighbours;

    public Star(char colour, int number, ArrayList<Star> neighbours) {
        this.colour = colour;
        this.number = number;
        this.neighbours = neighbours;
    }

    public char getColour() {
        return colour;
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<Star> getNeighbours() {
        return neighbours;
    }
}
