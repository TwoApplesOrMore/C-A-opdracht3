import java.util.ArrayList;

public class Star {

    private char colour;
    private int number;
    private ArrayList<Star> neighbours = new ArrayList<>();

    public Star(char colour, int number) {
        this.colour = colour;
        this.number = number;
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

    public void setNeighbour(Star neighbour) {
        neighbours.add(neighbour);
    }
}
