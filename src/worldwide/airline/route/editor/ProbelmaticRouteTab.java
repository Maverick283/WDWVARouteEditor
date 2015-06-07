/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sql.Schedules;

/**
 *
 * @author Patrick
 */
public class ProbelmaticRouteTab {

    TableView<Schedules> problematicRouteTable;
    TableColumn id;
    TableColumn code;
    TableColumn flightnum;
    TableColumn depicao;
    TableColumn arricao;
    TableColumn route;
    TableColumn routeDetails;
    TableColumn aircraft;
    TableColumn flightlevel;
    TableColumn distance;
    TableColumn deptime;
    TableColumn arrtime;
    TableColumn flighttime;
    TableColumn daysofweek;
    TableColumn price;
    TableColumn flighttype;
    TableColumn timesflown;
    TableColumn notes;
    TableColumn enabled;
    TableColumn issue;
    private final MainUIController father;

    ProbelmaticRouteTab(TableView<Schedules> problematicRouteTable, MainUIController father) {
        this.problematicRouteTable = problematicRouteTable;
        id = problematicRouteTable.getColumns().get(0);
        code = problematicRouteTable.getColumns().get(1);
        flightnum = problematicRouteTable.getColumns().get(2);
        depicao = problematicRouteTable.getColumns().get(3);
        arricao = problematicRouteTable.getColumns().get(4);
        route = problematicRouteTable.getColumns().get(5);
        routeDetails = problematicRouteTable.getColumns().get(6);
        aircraft = problematicRouteTable.getColumns().get(7);
        flightlevel = problematicRouteTable.getColumns().get(8);
        distance = problematicRouteTable.getColumns().get(9);
        deptime = problematicRouteTable.getColumns().get(10);
        arrtime = problematicRouteTable.getColumns().get(11);
        flighttime = problematicRouteTable.getColumns().get(12);
        daysofweek = problematicRouteTable.getColumns().get(13);
        price = problematicRouteTable.getColumns().get(14);
        flighttype = problematicRouteTable.getColumns().get(15);
        timesflown = problematicRouteTable.getColumns().get(16);
        notes = problematicRouteTable.getColumns().get(17);
        enabled = problematicRouteTable.getColumns().get(18);
        issue = problematicRouteTable.getColumns().get(19);
        
        this.father = father;
    }

    void createList(ArrayList<Schedules> faultySchedulesList) {
        id.setCellValueFactory(new PropertyValueFactory<Schedules, String>("id"));
        code.setCellValueFactory(new PropertyValueFactory<Schedules, String>("code"));
        flightnum.setCellValueFactory(new PropertyValueFactory<Schedules, String>("flightnum"));
        depicao.setCellValueFactory(new PropertyValueFactory<Schedules, String>("depicao"));
        arricao.setCellValueFactory(new PropertyValueFactory<Schedules, String>("arricao"));
        route.setCellValueFactory(new PropertyValueFactory<Schedules, String>("route"));
        routeDetails.setCellValueFactory(new PropertyValueFactory<Schedules, String>("routeDetails"));
        aircraft.setCellValueFactory(new PropertyValueFactory<Schedules, String>("aircraft"));
        flightlevel.setCellValueFactory(new PropertyValueFactory<Schedules, String>("flightlevel"));
        distance.setCellValueFactory(new PropertyValueFactory<Schedules, String>("distance"));
        deptime.setCellValueFactory(new PropertyValueFactory<Schedules, String>("deptime"));
        arrtime.setCellValueFactory(new PropertyValueFactory<Schedules, String>("arrtime"));
        flighttime.setCellValueFactory(new PropertyValueFactory<Schedules, String>("flighttime"));
        daysofweek.setCellValueFactory(new PropertyValueFactory<Schedules, String>("daysofweek"));
        price.setCellValueFactory(new PropertyValueFactory<Schedules, String>("price"));
        flighttype.setCellValueFactory(new PropertyValueFactory<Schedules, String>("flighttype"));
        timesflown.setCellValueFactory(new PropertyValueFactory<Schedules, String>("timesflown"));
        notes.setCellValueFactory(new PropertyValueFactory<Schedules, String>("notes"));
        enabled.setCellValueFactory(new PropertyValueFactory<Schedules, String>("enabled"));
        issue.setCellValueFactory(new PropertyValueFactory<Schedules, String>("issue"));
        problematicRouteTable.setItems(FXCollections.observableArrayList(faultySchedulesList));
    }

    void refresh(ActionEvent event) {
        System.out.println("Unsupported Method: refresh at worldwide.airline.route.editor.ProbelmaticRouteTab"); //To change body of generated methods, choose Tools | Templates.
    }

}
