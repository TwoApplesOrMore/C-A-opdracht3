import java.util.ArrayList;

public class Galaxy {

    private char name;
    private ArrayList<Star> stars = new ArrayList<>();
    private ArrayList<Galaxy> neighbours = new ArrayList<>();

    public Galaxy(char name) {
        this.name = name;
    }

    public Star getStar(int index) {
        if(index >= 0 && index < stars.size()) {
            return stars.get(index);
        }
        return null;
    }

    public void setStars(ArrayList<Star> stars) {
        this.stars = stars;
    }

    public void addStar(Star star) {
        stars.add(star);
    }


    public void addNeighbour(Galaxy galaxy) {
        neighbours.add(galaxy);
    }

    public ArrayList<Galaxy> getNeighbours() {
        return neighbours;
    }


    public char getName(){
        return name;
    }

}
