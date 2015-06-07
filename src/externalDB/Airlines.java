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
public class Airlines {

    String airlineID;
    String name;
    String alias;
    String iATA;
    String iCAO;
    String callsign;
    String country;
    boolean active;
    
    Airlines(String[] entries) {
        airlineID = entries[0];
        name = entries[1];
        alias = entries[2];
        iATA= entries[3];
        iCAO = entries[4];
        callsign = entries[5];
        country = entries[6];
        active = entries[7].equalsIgnoreCase("Y");
    }
    
}
