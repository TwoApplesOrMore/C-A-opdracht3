import java.util.ArrayList;

public class Galaxy {

    private char name;
    private ArrayList<Star> stars = new ArrayList<>();
    private ArrayList<Galaxy> neighbours = new ArrayList<>();

    public Galaxy(char name) {
        this.name = name;
    }

    /**
     * gets the star with the same given number
     * @param starnumber the given number
     * @return the star object.
     */
    public Star getStar(int starnumber) {
        for(Star star : stars) {
            if(star.getNumber() == starnumber) {
                return star;
            }
        }
        return null;
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
