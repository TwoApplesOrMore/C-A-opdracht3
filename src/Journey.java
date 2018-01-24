import java.util.ArrayList;
import java.util.Arrays;

public class Journey implements Comparable{

    private ArrayList<Star> route = new ArrayList<>();

    /**
     * constructor used for starting a journey.
     * @param startStar the star to start at.
     */
    public Journey(Star startStar){
        route.add(startStar);
    }

    /**
     * constructor for copying the already tested journey and adding a new star.
     * @param route the already testes route
     * @param addStar the star to add
     */
    public Journey(ArrayList<Star> route, Star addStar){
        this.route = route;
        this.route.add(addStar);
    }

    public ArrayList<Star> getRoute() {
        return route;
    }

    public Star getLastStar(){
        return route.get(route.size()-1);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(route.toArray());
    }
}
