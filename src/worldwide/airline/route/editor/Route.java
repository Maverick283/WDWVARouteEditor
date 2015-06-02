/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.io.BufferedWriter;

/**
 *
 * @author patrickburkart
 */
public class Route {

    Route next;
    int ID;
    int flightnum;
    int flightlevel;
    double distance;
    double flighttime;
    double price;
    String code;
    String depicao;
    String arricao;
    String route;
    String aircraft;
    String deptime;
    String arrtime;
    String notes;
    String flighttype;
    String daysofweek;
    boolean enabled;

    public Route() {
        /* Order
         code
         flightnum
         depicao
         arricao
         route
         aircraft
         flightlevel
         distance
         deptime
         arrtime
         flighttime
         notes
         price
         flighttype
         daysofweek
         enabled*/

    }
    
    public Route(String [] information){
        registerInformation(information);
    }
    
    public void addNewRoute(String [] information){
        if(next==null){
            next = new Route(information);   
            next.newNumber(ID+1);
        }
        else{
            next.addNewRoute(information);
        }
    }
    
    public void newNumber(int ID){
        this.ID = ID;
    }
    
    public void registerInformation(String[] information){
        
        code = information[0];
        flightnum = calc.StringToInt(information[1]);
        depicao = information[2];
        arricao = information[3];
        route = information[4];
        aircraft = information[5];
        flightlevel = calc.StringToInt(information[6]);
        distance = calc.StringToDouble(information[7]);
        deptime = information[8];
        arrtime = information[9];
        flighttime = calc.StringToDouble(information[10]);
        notes = information[11];
        price = calc.StringToDouble(information[12]);
        flighttype = information[13];
        daysofweek = information[14];
        enabled = calc.StringToBoolean(information[15]);
    }
    
    public int getTotalNumber(){
        if(next==null){
            return ID;
        }
        else{
            return next.getTotalNumber();
        }
    }
    
    public double getTotalDistance(){
        if(next!=null){
            return next.getTotalDistance()+distance;
        }
        else{
            return distance;
        }
    }
    
    public String[] getAircraftInformation(String [] aircrafts){
        if(calc.notInArray(aircrafts,aircraft)){
            aircrafts = calc.addToArray(aircrafts,aircraft);
        }
        if(next!=null){
            return next.getAircraftInformation(aircrafts);
        }
        else{
            return aircrafts;
        }
    }
}
