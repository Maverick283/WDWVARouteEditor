/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import sql.Schedules;
import worldwide.airline.route.editor.MainUIController;

/**
 *
 * @author Patrick
 */
public class ExternalDBManager {

    private final MainUIController father;

    ArrayList<Airlines> airlineList;
    ArrayList<Airports> airportList;
    ArrayList<Routes> routeList;
    private final String ROUTES;
    private final String AIRPORTS;
    private final String AIRLINES;

    public ExternalDBManager(MainUIController father, String ROUTES, String AIRPORTS, String AIRLINES) {
        this.father = father;
        this.ROUTES = ROUTES;
        this.AIRPORTS = AIRPORTS;
        this.AIRLINES = AIRLINES;
        airlineList = new ArrayList<>();
        airportList = new ArrayList<>();
        routeList = new ArrayList<>();

        refreshData();
    }

    /**
     * parses the routes.dat file downloaded from sourceforge
     *
     * @param inputFilePath
     */
    public void readExternalRoutesData() {
        try (BufferedReader br = new BufferedReader(new FileReader(ROUTES))) {
            String line;
            /* Syntax of routes.dat
             Airline	2-letter (IATA) or 3-letter (ICAO) code of the airline.
             Airline ID	Unique OpenFlights identifier for airline (see Airline).
             Source airport	3-letter (IATA) or 4-letter (ICAO) code of the source airport.
             Source airport ID	Unique OpenFlights identifier for source airport (see Airport)
             Destination airport	3-letter (IATA) or 4-letter (ICAO) code of the destination airport.
             Destination airport ID	Unique OpenFlights identifier for destination airport (see Airport)
             Codeshare	"Y" if this flight is a codeshare (that is, not operated by Airline, but another carrier), empty otherwise.
             Stops	Number of stops on this flight ("0" for direct)
             Equipment	3-letter codes for plane type(s) generally used on this flight, separated by spaces
             */
            while ((line = br.readLine()) != null) {
                String[] entries = line.split(",");
                Routes instance = new Routes(entries);
                routeList.add(instance);
            }
        } catch (IOException e) {
        }
    }

    public void readExternalAirportsData() {
        try (BufferedReader br = new BufferedReader(new FileReader(AIRPORTS))) {
            String line;
            /* Syntax of airports.dat
             Airport ID	Unique OpenFlights identifier for this airport.
             Name	Name of airport. May or may not contain the City name.
             City	Main city served by airport. May be spelled differently from Name.
             Country	Country or territory where airport is located.
             IATA/FAA	3-letter FAA code, for airports located in Country "United States of America".
             3-letter IATA code, for all other airports.
             Blank if not assigned.
             ICAO	4-letter ICAO code.
             Blank if not assigned.
             Latitude	Decimal degrees, usually to six significant digits. Negative is South, positive is North.
             Longitude	Decimal degrees, usually to six significant digits. Negative is West, positive is East.
             Altitude	In feet.
             Timezone	Hours offset from UTC. Fractional hours are expressed as decimals, eg. India is 5.5.
             DST	Daylight savings time. One of E (Europe), A (US/Canada), S (South America), O (Australia), Z (New Zealand), N (None) or U (Unknown). See also: Help: Time
             Tz database time zone	Timezone in "tz" (Olson) format, eg. "America/Los_Angeles".
             */
            while ((line = br.readLine()) != null) {
                //Due to bad Database management some airports have to be hard coded here... :(
                switch (line.substring(0, 4)) {
                    case "5881":
                        line = line.replace("\"Angaha, Niuafo'ou Island\"", "\"Angaha Niuafo'ou Island\"");
                        break;
                    case "5675":
                        line = line.replace("\"Sao Filipe, Fogo Island\"", "\"Sao Filipe Fogo Island\"");
                        break;
                    case "5674":
                        line = line.replace("\"Praia, Santiago Island\"", "\"Praia Santiago Island\"");
                        break;
                    case "5562":
                        line = line.replace("\"Doncaster, Sheffield\"", "\"Doncaster Sheffield\"");
                        break;
                }
                String[] entries = line.split(",");
                Airports instance = new Airports(entries);
                airportList.add(instance);

            }
        } catch (IOException e) {
        }
    }

    public void readExternalAirlinesData() {
        try (BufferedReader br = new BufferedReader(new FileReader(AIRLINES))) {
            String line;
            /* Syntax of airlines.dat
             Airline ID	Unique OpenFlights identifier for this airline.
             Name	Name of the airline.
             Alias	Alias of the airline. For example, All Nippon Airways is commonly known as "ANA".
             IATA	2-letter IATA code, if available.
             ICAO	3-letter ICAO code, if available.
             Callsign	Airline callsign.
             Country	Country or territory where airline is incorporated.
             Active	"Y" if the airline is or has until recently been operational, "N" if it is defunct. This field is not reliable: in particular, major airlines that stopped flying long ago, but have not had their IATA code reassigned (eg. Ansett/AN), will incorrectly show as "Y".
             */
            while ((line = br.readLine()) != null) {
                String[] entries = line.split(",");
                Airlines instance = new Airlines(entries);
                airlineList.add(instance);

            }
        } catch (IOException e) {
        }
    }

    private void coupleRoutes() {
        for (Routes route : routeList) {
            int depAirportID = route.getSourceAirportID();
            int arrAirportID = route.getDestinationAirportID();
            String airlineID = route.getAirlineID();
            route.setDepAirport(findAirportByID(depAirportID));
            route.setArrAirport(findAirportByID(arrAirportID));
            route.setAirline(findAirlineByID(airlineID));
        }
    }

    private Airports findAirportByID(int iD) {
        for (Airports airport : airportList) {
            if (airport.getAirportID() == iD) {
                return airport;
            }
        }
        return null;
    }

    private Airlines findAirlineByID(String iD) {
        for (Airlines airline : airlineList) {
            if (airline.getAirlineID().equalsIgnoreCase(iD)) {
                return airline;
            }
        }
        return null;
    }

    public void refreshData() {
        try {
            readExternalAirlinesData();
            readExternalAirportsData();
            readExternalRoutesData();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        coupleRoutes();
    }

    public ArrayList<Schedules> checkForRealRoutes(ArrayList<Schedules> allRoutes) {
        ArrayList<Schedules> toReturn = new ArrayList<Schedules>();
        for (Schedules allRoute : allRoutes) {
            if (!isValidRoute(allRoute.getDepicao(), allRoute.getArricao())) {
                toReturn.add(allRoute);
            }
        }
        return toReturn;
    }

    public boolean isValidRoute(String depicao, String arricao) {
        for (Routes route : routeList) {
            try {
                String routeDepICAO = route.getDepAirport().getICAO();
                String routeArrICAO = route.getArrAirport().getICAO();
                if (routeDepICAO.equalsIgnoreCase(depicao) && routeArrICAO.equalsIgnoreCase(arricao)) {
                    return true;
                }
            } catch (NullPointerException e) {
            }
        }
        return false;
    }

    public ArrayList getRoutes() {
        return routeList;
    }

    public ArrayList getAirports() {
        return airportList;
    }

    public ArrayList getAirlines() {
        return airlineList;
    }
}
