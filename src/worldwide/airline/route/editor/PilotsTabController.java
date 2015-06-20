/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import sql.Pilots;
import sql.Schedules;

/**
 *
 * @author Patrick
 */
public class PilotsTabController {

    MainUIController father;
    TableView<Pilots> pilotsTable;
    private final SQLHandler sqlHandler;

    private final TableColumn<Pilots, Integer> id;
    private final TableColumn<Pilots, String> firstName;
    private final TableColumn<Pilots, String> lastName;
    private final TableColumn<Pilots, String> email;
    private final TableColumn<Pilots, String> location;
    private final TableColumn<Pilots, String> hub;
    private final TableColumn<Pilots, String> lastLogin;
    private final TableColumn<Pilots, String> lastFlight;
    private final TableColumn<Pilots, String> lastClient;
    private final TableColumn<Pilots, Integer> totalFlights;
    private final TableColumn<Pilots, Float> totalHours;
    private final TableColumn<Pilots, Float> totalPay;
    private final TableColumn<Pilots, Integer> rankID;
    private final TableColumn<Pilots, String> rankName;
    private final TableColumn<Pilots, Integer> vatsimID;

    PilotsTabController(MainUIController father, TableView<Pilots> pilotsTable, SQLHandler sqlHandler) {
        this.father = father;
        this.pilotsTable = pilotsTable;
        this.sqlHandler = sqlHandler;

        id = (TableColumn<Pilots, Integer>) pilotsTable.getColumns().get(0);
        firstName = (TableColumn<Pilots, String>) pilotsTable.getColumns().get(1).getColumns().get(0);
        lastName = (TableColumn<Pilots, String>) pilotsTable.getColumns().get(1).getColumns().get(1);
        email = (TableColumn<Pilots, String>) pilotsTable.getColumns().get(2);
        location = (TableColumn<Pilots, String>) pilotsTable.getColumns().get(3);
        hub = (TableColumn<Pilots, String>) pilotsTable.getColumns().get(4);
        lastLogin = (TableColumn<Pilots, String>) pilotsTable.getColumns().get(5).getColumns().get(0);
        lastFlight = (TableColumn<Pilots, String>) pilotsTable.getColumns().get(5).getColumns().get(1);
        lastClient = (TableColumn<Pilots, String>) pilotsTable.getColumns().get(5).getColumns().get(2);
        totalFlights = (TableColumn<Pilots, Integer>) pilotsTable.getColumns().get(6).getColumns().get(0);
        totalHours = (TableColumn<Pilots, Float>) pilotsTable.getColumns().get(6).getColumns().get(1);
        totalPay = (TableColumn<Pilots, Float>) pilotsTable.getColumns().get(6).getColumns().get(2);
        rankID = (TableColumn<Pilots, Integer>) pilotsTable.getColumns().get(7).getColumns().get(0);
        rankName = (TableColumn<Pilots, String>) pilotsTable.getColumns().get(7).getColumns().get(1);
        vatsimID = (TableColumn<Pilots, Integer>) pilotsTable.getColumns().get(8);

        firstName.setCellFactory(TextFieldTableCell.forTableColumn());
        firstName.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Pilots, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Pilots, String> t) {
                        Pilots edited = (Pilots) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getPilotid();
                        String newFirstName = t.getNewValue();
                        edited.setFirstname(newFirstName);
                        sqlHandler.changePilotFirstName(editedID, newFirstName);
                    }
                }
        );

        lastName.setCellFactory(TextFieldTableCell.forTableColumn());
        lastName.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Pilots, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Pilots, String> t) {
                        Pilots edited = (Pilots) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getPilotid();
                        String newLastName = t.getNewValue();
                        edited.setLastname(newLastName);
                        sqlHandler.changePilotLastName(editedID, newLastName);
                    }
                }
        );

        email.setCellFactory(TextFieldTableCell.forTableColumn());
        email.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Pilots, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Pilots, String> t) {
                        Pilots edited = (Pilots) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getPilotid();
                        String newEmail = t.getNewValue();
                        edited.setEmail(newEmail);
                        sqlHandler.changePilotEmail(editedID, newEmail);
                    }
                }
        );

        hub.setCellFactory(TextFieldTableCell.forTableColumn());
        hub.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Pilots, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Pilots, String> t) {
                        Pilots edited = (Pilots) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        int editedID = edited.getPilotid();
                        String newHub = t.getNewValue();
                        edited.setHub(newHub);
                        sqlHandler.changePilotHub(editedID, newHub);
                    }
                }
        );

    }

    void createList(ArrayList<Pilots> content) {
        id.setCellValueFactory(new PropertyValueFactory<Pilots, Integer>("pilotid"));
        firstName.setCellValueFactory(new PropertyValueFactory<Pilots, String>("firstname"));
        lastName.setCellValueFactory(new PropertyValueFactory<Pilots, String>("lastname"));
        email.setCellValueFactory(new PropertyValueFactory<Pilots, String>("email"));
        location.setCellValueFactory(new PropertyValueFactory<Pilots, String>("location"));
        hub.setCellValueFactory(new PropertyValueFactory<Pilots, String>("hub"));
        lastLogin.setCellValueFactory(new PropertyValueFactory<Pilots, String>("lastlogin"));
        lastFlight.setCellValueFactory(new PropertyValueFactory<Pilots, String>("lastpirep"));
        lastClient.setCellValueFactory(new PropertyValueFactory<Pilots, String>("lastclient"));
        totalFlights.setCellValueFactory(new PropertyValueFactory<Pilots, Integer>("totalflights"));
        totalHours.setCellValueFactory(new PropertyValueFactory<Pilots, Float>("totalhours"));
        totalPay.setCellValueFactory(new PropertyValueFactory<Pilots, Float>("totalpay"));
        rankID.setCellValueFactory(new PropertyValueFactory<Pilots, Integer>("rankid"));
        rankName.setCellValueFactory(new PropertyValueFactory<Pilots, String>("rank"));
        vatsimID.setCellValueFactory(new PropertyValueFactory<Pilots, Integer>("vatsimid"));
        pilotsTable.setItems(FXCollections.observableArrayList(content));
    }

}
