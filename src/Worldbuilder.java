import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Worldbuilder {

    public static ArrayList<Galaxy> buildGalaxies() {
        return createGalaxies();
    }

    private static ArrayList<Galaxy> createGalaxies() {
        ArrayList<Galaxy> galaxies = new ArrayList<>();
        try {
            String bareJSON = new String(Files.readAllBytes(Paths.get("Galaxies.json")));
            JSONArray jarray = new JSONArray(bareJSON);

            for(int i = 0; i<jarray.length(); i++) {
                JSONObject JSONgalaxy = jarray.getJSONObject(i);

                //System.out.println("Galaxyname = " + JSONgalaxy.getString("galaxy").charAt(0));
                Galaxy galaxy = new Galaxy(JSONgalaxy.getString("galaxy").charAt(0));
                galaxies.add(galaxy);

                JSONArray stars = JSONgalaxy.getJSONArray("stars");
                for (int y = 0; y<stars.length(); y++) {
                    int number = y+1;
                    char colour = stars.getJSONObject(y).getString("colour").charAt(0);
                    galaxy.addStar(new Star(colour, number, galaxy));
                }
                setStarNeighbours(galaxy, stars);
            }
            setGalaxyNeighbours(galaxies, jarray);
        } catch (FileNotFoundException fnf) {
            System.out.println("File not found");
        } catch (IOException ieo) {
            System.out.println("Could not read file.");
        }
        return galaxies;
    }

    private static void setStarNeighbours(Galaxy galaxy, JSONArray stars)  {
        for (int y = 0; y<stars.length(); y++) {
            JSONArray neighbours = stars.getJSONObject(y).getJSONArray("neighbour-stars");
            //add internal neighbours
            for(int i = 0; i<neighbours.length(); i++){
                int star = (int) neighbours.get(i);
                galaxy.getStar(y+1).addNeighbour(galaxy.getStar(star));
            }
        }

    }

    private static void setGalaxyNeighbours(ArrayList<Galaxy> galaxies, JSONArray jsongalaxies) {
        for(int i = 0; i<jsongalaxies.length(); i++) {
            JSONArray neighbours = jsongalaxies.getJSONObject(i).getJSONArray("neighbours");
          //  System.out.println("galaxy " + galaxies.get(i).getName() + " has neighbours: ");
            for(int y = 0; y<neighbours.length(); y++) {
                char galaxyname = neighbours.get(y).toString().charAt(0);
                //System.out.println(galaxyname);
                for(Galaxy galaxy : galaxies) {
                    if(galaxy.getName() == galaxyname) {
                        galaxies.get(i).addNeighbour(galaxy);
                    }
                }
            }
        }
    }
}
