import java.util.ArrayList;

public class Journey {

    private ArrayList<Star> route;

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
}
