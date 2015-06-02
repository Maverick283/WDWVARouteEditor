/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

/**
 *
 * @author patrickburkart
 */
public class RouteOrganizer {
    Route first;
    String [] aircrafts;
    
    public RouteOrganizer(){
        aircrafts = new String[1];
        aircrafts[0] = "";
    }
    
    
    public void add(String [] information){
        if(first==null){
            first = new Route();
            first.registerInformation(information);
            first.newNumber(0);
        }
        first.addNewRoute(information);
    }
    
    public int getTotalNumber(){
        try{
            return first.getTotalNumber();
        }
        catch(NullPointerException e){
            return 0;
        }
    }
    
    public int getTotalAmount(){
        if(first!=null){
            return getTotalNumber()+1;
        }
        else{
            return 0;
        }
    }
    
    public double getTotalDistance(){
        if(first!=null){
            int toReturn = (int)first.getTotalDistance();
            return toReturn;
        }
        else{
            return 0;
        }
    }
    
    public void gatherAircraftInformation(){
        aircrafts = first.getAircraftInformation(aircrafts);
    }
    
    public int numberOfAircrafts(){
        if(aircrafts[0].isEmpty()){
            gatherAircraftInformation();
        }
        return aircrafts.length;
    }
}
