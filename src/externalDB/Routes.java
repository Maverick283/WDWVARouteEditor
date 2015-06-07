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

    String airline;
    int airlineID;
    String sourceAirport;
    int sourceAirportID;
    String destinationAirport;
    int destinationAirportID;
    boolean codeshare;
    int stops;
    String[] equipment;

    Routes(String[] entries) {
        airline = entries[0];
        airlineID = Integer.parseInt(entries[1]);
        sourceAirport = entries[2];
        sourceAirportID = Integer.parseInt(entries[3]);
        destinationAirport = entries[4];
        destinationAirportID = Integer.parseInt(entries[5]);
        codeshare = entries[6].equalsIgnoreCase("Y");
        stops = Integer.parseInt(entries[7]);
        equipment = entries[8].split(" ");
    }
    
    Routes(String airline, int airlineID, String sourceAirport, int sourceAirportID, String destinationAirport, boolean codeshare, int stops, String[] equipment){
        this.airline = airline;
        this.airlineID = airlineID;
        this.sourceAirport = sourceAirport;
        this.sourceAirportID = sourceAirportID;
        this.destinationAirport = destinationAirport;
        this.destinationAirportID = destinationAirportID;
        this.codeshare = codeshare;
        this.stops = stops;
        this.equipment = equipment;
    }

}
