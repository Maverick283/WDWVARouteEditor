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
        name = entries[1].replace("\"", "");
        alias = entries[2].replace("\"", "");
        iATA= entries[3].replace("\"", "");
        iCAO = entries[4].replace("\"", "");
        callsign = entries[5].replace("\"", "");
        country = entries[6].replace("\"", "");
        active = entries[7].equalsIgnoreCase("Y");
    }
    
    public String getAirlineID(){
        return airlineID;
    }
    public String getName(){
        return name;
    }
    public String getAlias(){
        return alias;
    }
    public String getIATA(){
        return iATA;
    }
    public String getICAO(){
        return iCAO;
    }
    public String getCallsign(){
        return callsign;
    }
    public String getCountry(){
        return country;
    }
    public boolean getActive(){
        return active;
    }
}
