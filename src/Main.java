import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        ArrayList<Galaxy> galaxies = Worldbuilder.buildGalaxies();
        System.out.println("--Welcome to the Galaxy Transport System--");

        System.out.println("Please enter the Galaxy you are now...");
        String startGalaxy = askGalaxy();

        System.out.println("Please enter the number of the Star you are now...");
        int startPlanet = askPlanet();

        System.out.println("Start Star: " + startGalaxy + startPlanet);


        System.out.println("Please enter the Galaxy you want to go to...");
        String endGalaxy = askGalaxy();

        System.out.println("Please enter the number of the Star you want to go to...");
        int endPlanet = askPlanet();

        System.out.println("End Star: " + endGalaxy + endPlanet);


    }

    public ArrayList<Journey> findJourneys(Star from, Star to){
        Queue<Journey> journeys = new PriorityQueue<>();
        ArrayList<Journey> solutions = new ArrayList<>();

        while(!journeys.isEmpty()){
            Journey currentJourney = journeys.remove();
            for(Star star : currentJourney.getLastStar().getNeighbours()){
                Journey nextJourney = new Journey(currentJourney.getRoute(),star);
                if (star == to) {
                    solutions.add(nextJourney);
                }else{
                    journeys.add(nextJourney);
                }
            }

        }

        return solutions;
    }

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

    private int askPlanet() {
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
