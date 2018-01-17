import java.util.ArrayList;

public class Galaxy {

    private char name;
    private ArrayList<Star> stars = new ArrayList<>();
    private ArrayList<Galaxy> neighbours = new ArrayList<>();

    public Galaxy(char name, ArrayList<Star> stars, ArrayList<Galaxy> neighbours) {
        this.name = name;
        this.stars = stars;
        this.neighbours = neighbours;
    }

    public void setStars(ArrayList<Star> stars) {
        this.stars = stars;
    }

    public ArrayList<Galaxy> getNeighbours() {
        return neighbours;
    }

    public char getName(){
        return name;
    }

}
