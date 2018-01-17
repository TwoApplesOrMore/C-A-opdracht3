import org.json.JSONArray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Worldbuilder {

    public static ArrayList<Galaxy> buildGalaxies() {
        return null;
    }

    private void createGalaxies() {
        try {
            JSONArray jarray = new JSONArray(new FileReader("Galaxies.json"));

        } catch (FileNotFoundException fnf) {
            System.out.println("File not found");
        }
    }

    private void linkGalaxies() {

    }
}
