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
public class Airports {
    
    int airportID;
    String name;
    String city;
    String country;
    String iATAFAA;
    String iCAO;
    double latitude;
    double longitude;
    int altitude;
    double timezone;
    String dST;
    String dbTimeZone;

    Airports(String[] entries) {
        airportID = Integer.parseInt(entries[0]);
        name = entries[1];
        city = entries[2];
        country = entries[3];
        iATAFAA = entries[4];
        iCAO = entries[5];
        latitude = Double.parseDouble(entries[6]);
        longitude = Double.parseDouble(entries[7]);
        altitude = Integer.parseInt(entries[8]);
        timezone = Double.parseDouble(entries[9]);
        dST = entries[10];
        dbTimeZone = entries[11];
    }
    
}
