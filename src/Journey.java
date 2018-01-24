import java.util.ArrayList;
import java.util.Arrays;

public class Journey implements Comparable{

    private ArrayList<Star> route = new ArrayList<>();

    public Journey(Star startStar){
        route.add(startStar);
    }

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
