/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalDB;

/**
 *
 * @author Patrick
 */
public class Routes {

    String airlineName;
    String airlineID;
    String sourceAirport;
    int sourceAirportID;
    String destinationAirport;
    int destinationAirportID;
    boolean codeshare;
    int stops;
    String[] equipment;

    Airports depAirport;
    Airports arrAirport;
    Airlines airline;

    Routes(String[] entries) {
        airlineName = entries[0];
        airlineID = entries[1];
        sourceAirport = entries[2];
        sourceAirportID = parseInt(entries[3]);
        destinationAirport = entries[4];
        destinationAirportID = parseInt(entries[5]);
        codeshare = entries[6].equalsIgnoreCase("Y");
        stops = Integer.parseInt(entries[7]);
        if (entries.length > 8) {
            equipment = entries[8].split(" ");
        } else {
            equipment = new String[]{"NA"};
        }
    }

    Routes(String airlineName, String airlineID, String sourceAirport, int sourceAirportID, String destinationAirport, int destinationAirportID, boolean codeshare, int stops, String[] equipment) {
        this.airlineName = airlineName;
        this.airlineID = airlineID;
        this.sourceAirport = sourceAirport;
        this.sourceAirportID = sourceAirportID;
        this.destinationAirport = destinationAirport;
        this.destinationAirportID = destinationAirportID;
        this.codeshare = codeshare;
        this.stops = stops;
        this.equipment = equipment;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public int getSourceAirportID() {
        return sourceAirportID;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public int getDestinationAirportID() {
        return destinationAirportID;
    }

    public boolean getCodeshare() {
        return codeshare;
    }

    public int getStops() {
        return stops;
    }

    public String[] getEquipment() {
        return equipment;
    }

    void setDepAirport(Airports airport) {
        this.depAirport = airport;
    }

    void setArrAirport(Airports airport) {
        this.arrAirport = airport;
    }

    void setAirline(Airlines airline) {
        this.airline = airline;
    }
    
    Airports getDepAirport(){
        return depAirport;
    }
    
    Airports getArrAirport(){
        return arrAirport;
    }

    private int parseInt(String entry) {
        try {
            return Integer.parseInt(entry);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
