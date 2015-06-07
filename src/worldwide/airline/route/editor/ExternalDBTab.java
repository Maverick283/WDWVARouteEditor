/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import externalDB.Airlines;
import externalDB.Airports;
import externalDB.Routes;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sql.Schedules;

/**
 *
 * @author Patrick
 */
public class ExternalDBTab {

    private final MainUIController father;
    private final ArrayList routes;
    private final ArrayList airports;
    private final ArrayList airlines;
    private final TableView<Routes> routesTableView;
    private final TableView<Airlines> airlineTableView;
    private final TableView<Airports> airportTableView;

    ExternalDBTab(MainUIController father, ArrayList routes, ArrayList airports, ArrayList airlines, TableView<Routes> routesTableView, TableView<Airlines> airlineTableView, TableView<Airports> airportTableView) {
        this.father = father;
        this.routes = routes;
        this.airports = airports;
        this.airlines = airlines;
        this.routesTableView = routesTableView;
        this.airlineTableView = airlineTableView;
        this.airportTableView = airportTableView;
        fillRoutes();
        fillAirlines();
        fillAirports();
    }

    private void fillRoutes() {
        ObservableList<TableColumn<Routes, ?>> columns = routesTableView.getColumns();
        TableColumn airline = columns.get(0);
        TableColumn airlineID = columns.get(1);
        TableColumn sourceAirp = columns.get(2);
        TableColumn sourceAirpID = columns.get(3);
        TableColumn destinationAirp = columns.get(4);
        TableColumn destinationAirpID = columns.get(5);
        TableColumn codeshare = columns.get(6);
        TableColumn stops = columns.get(7);
        TableColumn equipment = columns.get(8);
        airline.setCellValueFactory(new PropertyValueFactory<Routes, String>("airlineName"));
        airlineID.setCellValueFactory(new PropertyValueFactory<Routes, String>("airlineID"));
        sourceAirp.setCellValueFactory(new PropertyValueFactory<Routes, String>("sourceAirport"));
        sourceAirpID.setCellValueFactory(new PropertyValueFactory<Routes, String>("sourceAirportID"));
        destinationAirp.setCellValueFactory(new PropertyValueFactory<Routes, String>("destinationAirport"));
        destinationAirpID.setCellValueFactory(new PropertyValueFactory<Routes, String>("destinationAirportID"));
        codeshare.setCellValueFactory(new PropertyValueFactory<Routes, String>("codeshare"));
        stops.setCellValueFactory(new PropertyValueFactory<Routes, String>("stops"));
        equipment.setCellValueFactory(new PropertyValueFactory<Routes, String>("equipmentString"));
        routesTableView.setItems(FXCollections.observableArrayList(routes));
    }

    private void fillAirports() {
        ObservableList<TableColumn<Airports, ?>> columns = airportTableView.getColumns();
        TableColumn airportID = columns.get(0);
        TableColumn name = columns.get(1);
        TableColumn city = columns.get(2);
        TableColumn country = columns.get(3);
        TableColumn iATAFAA = columns.get(4);
        TableColumn iCAO = columns.get(5);
        TableColumn lat = columns.get(6);
        TableColumn lng = columns.get(7);
        TableColumn alt = columns.get(8);
        TableColumn timzone = columns.get(9);
        TableColumn dST = columns.get(10);
        TableColumn dbTimezone = columns.get(11);

        airportID.setCellValueFactory(new PropertyValueFactory<Airports, Integer>("airportID"));
        name.setCellValueFactory(new PropertyValueFactory<Airports, String>("name"));
        city.setCellValueFactory(new PropertyValueFactory<Airports, String>("city"));
        country.setCellValueFactory(new PropertyValueFactory<Airports, String>("country"));
        iATAFAA.setCellValueFactory(new PropertyValueFactory<Airports, String>("iATAFAA"));
        iCAO.setCellValueFactory(new PropertyValueFactory<Airports, String>("iCAO"));
        lat.setCellValueFactory(new PropertyValueFactory<Airports, Double>("latitude"));
        lng.setCellValueFactory(new PropertyValueFactory<Airports, Double>("longitude"));
        alt.setCellValueFactory(new PropertyValueFactory<Airports, Integer>("altitude"));
        timzone.setCellValueFactory(new PropertyValueFactory<Airports, String>("timezone"));
        dST.setCellValueFactory(new PropertyValueFactory<Airports, String>("dST"));
        dbTimezone.setCellValueFactory(new PropertyValueFactory<Airports, String>("dbTimeZone"));
        
        airportTableView.setItems(FXCollections.observableArrayList(airports));
    }

    private void fillAirlines() {
         ObservableList<TableColumn<Airlines, ?>> columns = airlineTableView.getColumns();
        TableColumn airlineID = columns.get(0);
        TableColumn name = columns.get(1);
        TableColumn alias = columns.get(2);
        TableColumn iATA = columns.get(3);
        TableColumn iCAO = columns.get(4);
        TableColumn callsign = columns.get(5);
        TableColumn country = columns.get(6);
        TableColumn active = columns.get(7);
        
        airlineID.setCellValueFactory(new PropertyValueFactory<Airlines, Integer>("airlineID"));
        name.setCellValueFactory(new PropertyValueFactory<Airlines, Integer>("name"));
        alias.setCellValueFactory(new PropertyValueFactory<Airlines, Integer>("alias"));
        iATA.setCellValueFactory(new PropertyValueFactory<Airlines, Integer>("iATA"));
        iCAO.setCellValueFactory(new PropertyValueFactory<Airlines, Integer>("iCAO"));
        callsign.setCellValueFactory(new PropertyValueFactory<Airlines, Integer>("callsign"));
        country.setCellValueFactory(new PropertyValueFactory<Airlines, Integer>("country"));
        active.setCellValueFactory(new PropertyValueFactory<Airlines, Integer>("active"));
        
        airlineTableView.setItems(FXCollections.observableArrayList(airlines));
    }

}
