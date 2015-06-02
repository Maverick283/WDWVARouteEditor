/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author patrickburkart
 */
public class csvReader {

    String csvFile;
    BufferedReader br;
    String line;
    String cvsSplitBy;

    public csvReader(String file) {
        csvFile = file;
        br = null;
        line = "";
        cvsSplitBy = ",";

    }

    public RouteOrganizer read() throws FileNotFoundException, IOException {

        br = new BufferedReader(new FileReader(csvFile));
        RouteOrganizer routes = new RouteOrganizer();
        line = br.readLine();
        while ((line = br.readLine()) != null) {

            // use comma as separator
            String[] route  = line.split(cvsSplitBy);
            routes.add(route);

            

        }

        if (br != null) {
            br.close();

        }
        return routes;
    }
}
