/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sql.Aircraft;
import sql.Schedules;

/**
 *
 * @author Patrick
 */
public class AddTab {

    private final MainUIController father;
    private final SQLHandler sqlHandler;
    private final Label flightnumLabel;
    private final ScrollBar flightNumScrollBar;
    private final TextField depICAOTextArea;
    private final TextField arrICAOTextArea;
    private final TextArea routeTextArea;
    private final ComboBox<String> flightlevelComboBox;
    private final TextField distanceTextField;
    private final TextField priceTextField;
    private final ChoiceBox<String> flighttypeComboBox;
    private final TextField depTimeHourTextField;
    private final TextField depTimeMinutesTextArea;
    private final ChoiceBox<String> depTimeZoneComboBox;
    private final TextField flighttimeTextArea;
    private final VBox schedulesAirplaneVBox;
    private final CheckBox dOWAllCheckBox;
    private final CheckBox dOWMondayCheckBox;
    private final CheckBox dOWThursdayCheckBox;
    private final CheckBox dOWWednesdayCheckBox;
    private final CheckBox dOWTuesdayCheckBox;
    private final CheckBox dOWSaturdayCheckBox;
    private final CheckBox dOWFridayCheckBox;
    private final CheckBox dOWSundayCheckBox;
    private final Button addScheduleButton;
    private Button clearScheduleButton;
    private final Label scheduleMessageLabel;

    int selectedFlightNum;
    ArrayList<Integer> takenFlightnums;
    ArrayList<CheckBox> aircraftCheckBoxList;

    AddTab(MainUIController father, SQLHandler sqlHandler, TextField DepICAOTextArea, TextField ArrICAOTextArea, Button AddScheduleButton, Button ClearScheduleButton,
            CheckBox DOWAllCheckBox, CheckBox DOWFridayCheckBox, CheckBox DOWMondayCheckBox, CheckBox DOWSaturdayCheckBox, CheckBox DOWSundayCheckBox,
            CheckBox DOWThursdayCheckBox, CheckBox DOWTuesdayCheckBox, CheckBox DOWWednesdayCheckBox, TextField DepTimeHourTextField,
            TextField DepTimeMinutesTextArea, ChoiceBox<String> DepTimeZoneComboBox, TextField DistanceTextField, ScrollBar FlightNumScrollBar, ComboBox<String> FlightlevelComboBox,
            Label FlightnumLabel, TextField FlighttimeTextArea, ChoiceBox<String> FlighttypeComboBox, TextField PriceTextField, TextArea RouteTextArea, Label ScheduleMessageLabel,
            VBox SchedulesAirplaneVBox) {
        this.father = father;
        this.sqlHandler = sqlHandler;
        this.depICAOTextArea = DepICAOTextArea;
        this.arrICAOTextArea = ArrICAOTextArea;
        this.addScheduleButton = AddScheduleButton;
        this.dOWAllCheckBox = DOWAllCheckBox;
        this.dOWMondayCheckBox = DOWMondayCheckBox;
        this.dOWTuesdayCheckBox = DOWTuesdayCheckBox;
        this.dOWWednesdayCheckBox = DOWWednesdayCheckBox;
        this.dOWThursdayCheckBox = DOWThursdayCheckBox;
        this.dOWFridayCheckBox = DOWFridayCheckBox;
        this.dOWSaturdayCheckBox = DOWSaturdayCheckBox;
        this.dOWSundayCheckBox = DOWSundayCheckBox;
        this.depTimeHourTextField = DepTimeHourTextField;
        this.depTimeMinutesTextArea = DepTimeMinutesTextArea;
        this.depTimeZoneComboBox = DepTimeZoneComboBox;
        this.distanceTextField = DistanceTextField;
        this.flightNumScrollBar = FlightNumScrollBar;
        this.flightlevelComboBox = FlightlevelComboBox;
        this.flightnumLabel = FlightnumLabel;
        this.flighttimeTextArea = FlighttimeTextArea;
        this.flighttypeComboBox = FlighttypeComboBox;
        this.priceTextField = PriceTextField;
        this.routeTextArea = RouteTextArea;
        this.scheduleMessageLabel = ScheduleMessageLabel;
        this.schedulesAirplaneVBox = SchedulesAirplaneVBox;
        this.clearScheduleButton = ClearScheduleButton;

        takenFlightnums = new ArrayList<>();

    }

    void initWithData() {
        initFlightnumberChoices();
        initFlightlevelBox();
        initDepTimeZoneBox();
        initFlighttypeBox();
        initAircraftList();
        initDOWChoices();
    }

    private void initFlightnumberChoices() {
        try {
            takenFlightnums = father.getAllUnavailFlightnum();
            selectedFlightNum = takenFlightnums.get(takenFlightnums.size() - 1) + 1;
            flightnumLabel.setText("WDW " + String.valueOf(selectedFlightNum));
        } catch (IndexOutOfBoundsException e) {
            flightnumLabel.setText("");
        }
    }

    private void initFlightlevelBox() {
        ArrayList<String> flightLevels = new ArrayList<>();
        for (int i = 50; i < 490; i = i + 5) {
            flightLevels.add("FL" + String.valueOf(i));
        }
        flightlevelComboBox.setItems(FXCollections.observableArrayList(flightLevels));
    }

    private void initDepTimeZoneBox() {
        depTimeZoneComboBox.setItems(FXCollections.observableArrayList("GMT"));
        depTimeZoneComboBox.getSelectionModel().selectFirst();
    }

    private void initFlighttypeBox() {
        flighttypeComboBox.setItems(FXCollections.observableArrayList("Passenger", "Cargo"));
        flighttypeComboBox.getSelectionModel().selectFirst();

    }

    private void initAircraftList() {
        ArrayList<Aircraft> aircrafts = father.aircraftList;
        aircraftCheckBoxList = new ArrayList<>();
        for (Aircraft aircraft : aircrafts) {
            HBox aircraftBox = new HBox();
            CheckBox checkBox = new CheckBox(aircraft.getFullname());
            aircraftCheckBoxList.add(checkBox);
            Label registration = new Label(aircraft.getRegistration());
            aircraftBox.getChildren().addAll(checkBox, registration);
            aircraftBox.setSpacing(14);
            schedulesAirplaneVBox.getChildren().add(aircraftBox);
        }
    }

    private void initDOWChoices() {
        dOWAllCheckBox.setSelected(true);
        checkAllDOWChecboxes(new ActionEvent());
    }

    void flightnumberUp(ActionEvent event) {
        boolean isAvail = false;
        while (!isAvail) {
            selectedFlightNum++;
            isAvail = !calc.isIntPartOfArray(selectedFlightNum, takenFlightnums);
        }
        setFlightNumLabel(selectedFlightNum);
    }

    void flightnumberDown(ActionEvent event) {
        boolean isAvail = false;
        while (!isAvail) {
            selectedFlightNum = selectedFlightNum - 1;
            if (selectedFlightNum <= 0) {
                selectedFlightNum = 0;
                if (calc.isIntPartOfArray(selectedFlightNum, takenFlightnums)) {
                    flightnumberUp(event);
                }
            }
            isAvail = !calc.isIntPartOfArray(selectedFlightNum, takenFlightnums);
        }
        setFlightNumLabel(selectedFlightNum);
    }

    void checkAllDOWChecboxes(ActionEvent event) {
        boolean selectAll = dOWAllCheckBox.isSelected();
        dOWMondayCheckBox.setSelected(selectAll);
        dOWTuesdayCheckBox.setSelected(selectAll);
        dOWWednesdayCheckBox.setSelected(selectAll);
        dOWThursdayCheckBox.setSelected(selectAll);
        dOWFridayCheckBox.setSelected(selectAll);
        dOWSaturdayCheckBox.setSelected(selectAll);
        dOWSundayCheckBox.setSelected(selectAll);
    }

    Schedules addSchedule(ActionEvent event) {
        System.out.println("Unsupported Method: addSchedule at worldwide.airline.route.editor.AddTab"); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    void clearSchedule(ActionEvent event) {
        System.out.println("Unsupported Method: clearSchedule at worldwide.airline.route.editor.AddTab"); //To change body of generated methods, choose Tools | Templates.
    }

    private void setFlightNumLabel(int flightnum) {
        selectedFlightNum = flightnum;
        flightnumLabel.setText("WDW " + String.valueOf(flightnum));
    }

    void iCAOEntered(Event event) {
        String depICAO = depICAOTextArea.getText();
        String arrICAO = arrICAOTextArea.getText();
        if (!depICAO.isEmpty() && !arrICAO.isEmpty()) {
            if (depICAO.length() == 4 && arrICAO.length() == 4) {
                depICAOTextArea.setText(depICAOTextArea.getText().toUpperCase());
                arrICAOTextArea.setText(arrICAOTextArea.getText().toUpperCase());
                searchRouteInformation(depICAO,arrICAO);
            }

        }
    }

    private void searchRouteInformation(String depICAO, String arrICAO) {
        String [] routeInfo = father.findRoute(depICAO, arrICAO);
        try{
            routeTextArea.setText(routeInfo[0]);
            distanceTextField.setText(routeInfo[2]);
        }catch(ArrayIndexOutOfBoundsException e){
            routeTextArea.setText("www.rfinder.asalink.net/free/");
        }
    }

}
