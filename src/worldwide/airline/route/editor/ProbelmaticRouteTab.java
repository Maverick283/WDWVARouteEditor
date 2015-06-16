/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
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
    private final SQLHandler sqlHandler;

    ProbelmaticRouteTab(TableView<Schedules> problematicRouteTable, MainUIController father, SQLHandler sqlHandler) {
        this.father = father;
        this.sqlHandler = sqlHandler;
        this.problematicRouteTable = problematicRouteTable;
        problematicRouteTable.setEditable(true);
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

        StringConverter<Float> floatConverter = new StringConverter<Float>() {

            @Override
            public String toString(Float object) {
                return String.valueOf(object);
            }

            @Override
            public Float fromString(String string) {
                return Float.parseFloat(string);
            }
        };

        StringConverter<Integer> intConverter = new StringConverter<Integer>() {

            @Override
            public String toString(Integer object) {
                return String.valueOf(object);
            }

            @Override
            public Integer fromString(String string) {
                return Integer.parseInt(string);
            }
        };
        
        
        flightnum.setCellFactory(TextFieldTableCell.forTableColumn());
        flightnum.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, String> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        String newFlightnum = t.getNewValue();
                        edited.setFlightnum(newFlightnum);
                        sqlHandler.changeFlightNum(editedID, newFlightnum);
                    }
                }
        );

        depicao.setCellFactory(TextFieldTableCell.forTableColumn());
        depicao.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, String> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        String newDepicao = t.getNewValue();
                        edited.setDepicao(newDepicao);
                        sqlHandler.changeDepicao(editedID, newDepicao);
                    }
                }
        );

        arricao.setCellFactory(TextFieldTableCell.forTableColumn());
        arricao.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, String> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        String newArricao = t.getNewValue();
                        edited.setArricao(newArricao);
                        sqlHandler.changeArricao(editedID, newArricao);
                    }
                }
        );

        route.setCellFactory(TextFieldTableCell.forTableColumn());
        route.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, String> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        String newRoute = t.getNewValue();
                        edited.setRoute(newRoute);
                        sqlHandler.changeRoute(editedID, newRoute);
                    }
                }
        );

        routeDetails.setCellFactory(TextFieldTableCell.forTableColumn());
        routeDetails.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, String> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        String newRouteDetails = t.getNewValue();
                        edited.setRouteDetails(newRouteDetails);
                        sqlHandler.changeRouteDetails(editedID, newRouteDetails);
                    }
                }
        );

        aircraft.setCellFactory(TextFieldTableCell.forTableColumn());
        aircraft.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, String> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        String newAircraft = t.getNewValue();
                        edited.setAircraft(newAircraft);
                        sqlHandler.changeAircraft(editedID, newAircraft);
                    }
                }
        );

        flightlevel.setCellFactory(TextFieldTableCell.forTableColumn());
        flightlevel.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, String> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        String newFlightlevel = t.getNewValue();
                        edited.setFlightlevel(newFlightlevel);
                        sqlHandler.changeFlightlevel(editedID, newFlightlevel);
                    }
                }
        );

        distance.setCellFactory(TextFieldTableCell.forTableColumn(floatConverter));
        distance.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, Float>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, Float> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        Float newDistance = t.getNewValue();
                        edited.setDistance(newDistance);
                        sqlHandler.changeDistance(editedID, newDistance);
                    }
                }
        );

        deptime.setCellFactory(TextFieldTableCell.forTableColumn());
        deptime.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, String> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        String newDeptime = t.getNewValue();
                        Float duration = edited.getFlighttime();
                        String arrTime = calc.getTimePlusDuration(newDeptime, duration);
                        edited.setDeptime(newDeptime);
                        edited.setArrtime(arrTime);
                        sqlHandler.changeDeptime(editedID, newDeptime);
                        sqlHandler.changeArrtime(editedID, arrTime);

                    }
                }
        );

        arrtime.setCellFactory(TextFieldTableCell.forTableColumn());
        arrtime.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, String> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        String newArrtime = t.getNewValue();
                        Float duration = edited.getFlighttime();
                        String depTime = calc.getTimeMinusDuration(newArrtime, duration);
                        edited.setArrtime(newArrtime);
                        edited.setDeptime(depTime);
                        sqlHandler.changeArrtime(editedID, newArrtime);
                        sqlHandler.changeDeptime(editedID, depTime);
                    }
                }
        );

        flighttime.setCellFactory(TextFieldTableCell.forTableColumn(floatConverter));
        flighttime.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, Float>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, Float> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        Float newFlightime = t.getNewValue();
                        String depTime = edited.getDeptime();
                        String arrTime = calc.getTimePlusDuration(depTime, newFlightime);
                        edited.setArrtime(arrTime);
                        edited.setFlighttime(newFlightime);
                        sqlHandler.changeFlightime(editedID, newFlightime);
                        sqlHandler.changeArrtime(editedID, arrTime);
                    }
                }
        );

        daysofweek.setCellFactory(TextFieldTableCell.forTableColumn());
        daysofweek.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, String> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        String newDaysofweek = t.getNewValue();
                        edited.setDaysofweek(newDaysofweek);
                        sqlHandler.changeDaysofweek(editedID, newDaysofweek);
                    }
                }
        );

        price.setCellFactory(TextFieldTableCell.forTableColumn(floatConverter));
        price.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, Float>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, Float> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        Float newPrice = t.getNewValue();
                        edited.setPrice(newPrice);
                        sqlHandler.changePrice(editedID, newPrice);
                    }
                }
        );

        flighttype.setCellFactory(TextFieldTableCell.forTableColumn());
        flighttype.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, String> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        String newFlighttype = t.getNewValue();
                        if (newFlighttype.equalsIgnoreCase("P") || newFlighttype.equalsIgnoreCase("C")) {
                            edited.setFlighttype(newFlighttype);
                            sqlHandler.changeFlighttype(editedID, newFlighttype);
                        } else {
                            edited.setFlighttype(t.getOldValue());
                        }
                    }
                }
        );

        /*timesflown.setCellFactory(TextFieldTableCell.forTableColumn(intConverter));
        timesflown.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, Integer> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        int newTimesflown = t.getNewValue();
                        edited.setTimesflown(newTimesflown);
                        sqlHandler.changeTimesflown(editedID, newTimesflown);
                    }
                }
        );*/

        notes.setCellFactory(TextFieldTableCell.forTableColumn());
        notes.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, String> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        String newNotes = t.getNewValue();
                        edited.setNotes(newNotes);
                        sqlHandler.changeNotes(editedID, newNotes);
                    }
                }
        );

        enabled.setCellFactory(TextFieldTableCell.forTableColumn(intConverter));
        enabled.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Schedules, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Schedules, Integer> t) {
                        Schedules edited = (Schedules) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getId();
                        int newEnabled = t.getNewValue();
                        edited.setEnabled(newEnabled);
                        sqlHandler.changeEnabled(editedID, newEnabled);
                    }
                }
        );
    }

    void createList(ArrayList<Schedules> faultySchedulesList) {
        id.setCellValueFactory(new PropertyValueFactory<Schedules, Integer>("id"));
        code.setCellValueFactory(new PropertyValueFactory<Schedules, String>("code"));
        flightnum.setCellValueFactory(new PropertyValueFactory<Schedules, String>("flightnum"));
        depicao.setCellValueFactory(new PropertyValueFactory<Schedules, String>("depicao"));
        arricao.setCellValueFactory(new PropertyValueFactory<Schedules, String>("arricao"));
        route.setCellValueFactory(new PropertyValueFactory<Schedules, String>("route"));
        routeDetails.setCellValueFactory(new PropertyValueFactory<Schedules, String>("routeDetails"));
        aircraft.setCellValueFactory(new PropertyValueFactory<Schedules, String>("aircraft"));
        flightlevel.setCellValueFactory(new PropertyValueFactory<Schedules, String>("flightlevel"));
        distance.setCellValueFactory(new PropertyValueFactory<Schedules, Float>("distance"));
        deptime.setCellValueFactory(new PropertyValueFactory<Schedules, String>("deptime"));
        arrtime.setCellValueFactory(new PropertyValueFactory<Schedules, String>("arrtime"));
        flighttime.setCellValueFactory(new PropertyValueFactory<Schedules, Float>("flighttime"));
        daysofweek.setCellValueFactory(new PropertyValueFactory<Schedules, String>("daysofweek"));
        price.setCellValueFactory(new PropertyValueFactory<Schedules, Float>("price"));
        flighttype.setCellValueFactory(new PropertyValueFactory<Schedules, String>("flighttype"));
        timesflown.setCellValueFactory(new PropertyValueFactory<Schedules, Integer>("timesflown"));
        notes.setCellValueFactory(new PropertyValueFactory<Schedules, String>("notes"));
        enabled.setCellValueFactory(new PropertyValueFactory<Schedules, String>("enabled"));
        issue.setCellValueFactory(new PropertyValueFactory<Schedules, String>("issue"));
        problematicRouteTable.setItems(FXCollections.observableArrayList(faultySchedulesList));
    }

    void refresh(ActionEvent event) {
        System.out.println("Unsupported Method: refresh at worldwide.airline.route.editor.ProbelmaticRouteTab"); //To change body of generated methods, choose Tools | Templates.
    }

}
