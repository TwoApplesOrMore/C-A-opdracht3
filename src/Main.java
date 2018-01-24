import java.util.*;

public class Main {

    private Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        new Main().run();
    }

    private ArrayList<Galaxy> galaxies = Worldbuilder.buildGalaxies();

    /**
     * run method of this program. asks the user for a start and end star and returns all routes.
     */
    public void run() {

        System.out.println("--Welcome to the Galaxy Transport System--");

        System.out.println("Please enter the Galaxy you are now...");
        String startGalaxy = askGalaxy();

        System.out.println("Please enter the number of the Star you are now...");
        int startPlanet = askStar();

        System.out.println("Start Star: " + startGalaxy + startPlanet);


        System.out.println("Please enter the Galaxy you want to go to...");
        String endGalaxy = askGalaxy();

        System.out.println("Please enter the number of the Star you want to go to...");
        int endPlanet = askStar();

        System.out.println("End Star: " + endGalaxy + endPlanet);

        ArrayList<Journey> results = findJourneys(getStar(startGalaxy.charAt(0), startPlanet), getStar(endGalaxy.charAt(0), endPlanet));
        if(results.size() == 0){
            System.out.println("There are no possible routes to this star.");
        }else {
            System.out.println("number of results: " + results.size());
            for(Journey journey : results){
                System.out.println(Arrays.toString(journey.getRoute().toArray()));
            }
        }


    }

    /**
     * method for getting a star object using a galaxy name and a star number.
     * @param galaxyname the galaxyname
     * @param starnumber the star number
     * @return
     */
    private Star getStar(char galaxyname, int starnumber) {
        for(Galaxy galaxy : galaxies) {
            if(galaxy.getName() == galaxyname) {
                return galaxy.getStar(starnumber);
            }
        }
        return null;
    }

    /**
     * method for finding all possible routes to a star.
     * @param from the starting star
     * @param to the destination star
     * @return
     */
    private ArrayList<Journey> findJourneys(Star from, Star to){
        PriorityQueue<Journey> journeys = new PriorityQueue<>();
        ArrayList<Journey> solutions = new ArrayList<>();


        journeys.add(new Journey(from));
        while(!journeys.isEmpty()){
            Journey currentJourney = journeys.remove();

            ArrayList<Star> reachableStars = currentJourney.getLastStar().getNeighbours();
            for(Galaxy galaxy : currentJourney.getLastStar().getParentSystem().getNeighbours()) {
                if (galaxy.getStar(currentJourney.getLastStar().getNumber()).getColour() == currentJourney.getLastStar().getColour()) {
                    reachableStars.add(galaxy.getStar(currentJourney.getLastStar().getNumber()));
                }
            }

            reachableStars.remove(currentJourney.getLastStar());

            for(Star star : reachableStars){
                Journey nextJourney = new Journey(new ArrayList<>(currentJourney.getRoute()), star);
                if (star == to) {
                    solutions.add(nextJourney);
                } else if(!currentJourney.getRoute().contains(star)){
                    journeys.add(nextJourney);
                }
            }
            reachableStars.clear();
        }
        return solutions;
    }

    /**
     * method for asking the user to enter a galaxy character.
     * tests if the input was valid and keeps asking until it is.
     * @return the galaxy.
     */
    private String askGalaxy() {
        while (true) {
            String line = in.nextLine();
            line = line.toUpperCase();
            line = line.trim();
            if (line.matches("[A-K]")) {
                return line;
            } else {
                System.out.println("Not a valid Galaxy. Try again.");
            }
        }
    }

    /**
     * method for asking the user to enter a star number.
     * tests if the input was valid and keeps asking until it is.
     * @return the star.
     */
    private int askStar() {
        while (true) {
            String line = in.nextLine();
            line = line.toLowerCase();
            line = line.trim();
            if (line.matches("[1-9]")) {
                return Integer.valueOf(line);
            } else {
                System.out.println("Not a valid Planet number. Try again.");
            }
        }
    }

}
