import java.util.ArrayList;

public class Star {

    private char colour;
    private int number;
    private Galaxy parentSystem;
    private ArrayList<Star> neighbours = new ArrayList<>();


    public Star(char colour, int number, Galaxy parentSystem ) {
        this.colour = colour;
        this.number = number;
        this.parentSystem = parentSystem;
    }

    public Galaxy getParentSystem() {
        return parentSystem;
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

    public void addNeighbour(Star neighbour) {
        neighbours.add(neighbour);
    }


    @Override
    public String toString() {
        return this.parentSystem.getName() + "" + this.number;
    }
}
