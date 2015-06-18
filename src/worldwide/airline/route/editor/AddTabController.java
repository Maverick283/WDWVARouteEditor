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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sql.Aircraft;
import sql.Schedules;

/**
 *
 * @author Patrick
 */
public class AddTabController {

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
    CheckBox[] checkBoxes;

    AddTabController(MainUIController father, SQLHandler sqlHandler, TextField DepICAOTextArea, TextField ArrICAOTextArea, Button AddScheduleButton, Button ClearScheduleButton,
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
        checkBoxes = new CheckBox[]{dOWMondayCheckBox, dOWTuesdayCheckBox, dOWWednesdayCheckBox, dOWThursdayCheckBox, dOWFridayCheckBox, dOWSaturdayCheckBox, dOWSundayCheckBox};

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
        for (CheckBox checkBoxe : checkBoxes) {
            checkBoxe.setSelected(selectAll);
        }
    }

    boolean addSchedule(ActionEvent event) {
        String[] fi = new String[14]; //flightinfo
        /*
         0 = flightnum
         1 = depicao
         2 = arricao
         3 = route
         4 = route_details
         5 = aircraft
         6 = flightlevel
         7 = distance
         8 = deptime
         9 = arrtime
         10 = flighttime
         11 = daysofweek
         12 = price
         13 = flighttype
         */
        fi[0] = getFlightnum();
        fi[1] = getDepICAO();
        fi[2] = getArrICAO();
        fi[3] = getRoute();
        fi[4] = "NA"; //No route details!
        fi[5] = getAircraft();
        fi[6] = getFlightlevelInFeet();
        fi[7] = String.valueOf(getDistance());
        fi[8] = getDepTime();
        fi[9] = getArrTime();
        fi[10] = String.valueOf(getFlighttime());
        fi[11] = getDOW();
        fi[12] = String.valueOf(getPrice());
        fi[13] = getFlighttype();
        boolean allDataAvail = true;
        for (int i = 0; i < fi.length; i++) {
            if (fi[i].isEmpty()) {
                allDataAvail = false;
            }
        }

        if (allDataAvail) {
            sqlHandler.executeQuery("INSERT INTO wdwvacom_wdw.schedules (code, flightnum, depicao, arricao, route, route_details, aircraft, flightlevel, distance, deptime, arrtime, flighttime, daysofweek, price, flighttype, timesflown, notes, enabled, bidid) \n"
                    + "	VALUES ('WDW', '" + fi[0] + "', '" + fi[1] + "', '" + fi[2] + "', '" + fi[3] + "', '" + fi[4] + "', '" + fi[5] + "', '" + fi[6] + "', " + fi[7] + ", '" + fi[8] + "', '" + fi[9] + "', " + fi[10] + ", '" + fi[11] + "', " + fi[12] + ", '" + fi[13] + "', DEFAULT, '', DEFAULT, DEFAULT);");
            return true;
        } else {
            System.out.println("Please enter all data!");
            return false;
        }
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
                searchRouteInformation(depICAO, arrICAO);
            }

        }
    }

    private void searchRouteInformation(String depICAO, String arrICAO) {
        if (routeTextArea.getText().isEmpty()) {
            String[] routeInfo = father.findRoute(depICAO, arrICAO);
            try {
                routeTextArea.setText(routeInfo[0]);
                distanceTextField.setText(routeInfo[2]);
                float distance = getDistance();
                float div = (float) 3.4;
                float priceFloat = distance / div;
                String price = String.valueOf(priceFloat);
                try {
                    price = price.substring(0, price.indexOf(".") + 3);
                } catch (IndexOutOfBoundsException e) {
                }
                priceTextField.setText(price);
            } catch (ArrayIndexOutOfBoundsException e) {
                routeTextArea.setText("www.rfinder.asalink.net/free/");
            }
        }
    }

    private float getDistance() {
        String distance = distanceTextField.getText();
        distance = calc.getDecimalFromString(distance);
        float toReturn = Float.parseFloat(distance.replaceAll(",", "."));
        return toReturn;
    }

    private int getPrice() {
        String price = priceTextField.getText();
        price = calc.getDecimalFromString(price);
        float toReturn = Float.parseFloat(price);
        return (int)toReturn;
    }

    private String getRoute() {
        return routeTextArea.getText();
    }

    private String getDepICAO() {
        return depICAOTextArea.getText();
    }

    private String getArrICAO() {
        return arrICAOTextArea.getText();
    }

    private String getFlightlevelInFeet() {
        String flightlevel = flightlevelComboBox.getValue();
        try {
            flightlevel = calc.getDecimalFromString(flightlevel);
            return flightlevel + "00";
        } catch (NullPointerException e) {
            return "";
        }
    }

    private String getFlighttype() {
        if (flighttypeComboBox.getValue().equalsIgnoreCase("Cargo")) {
            return "C";
        } else {
            return "P";
        }
    }

    private String getFlightnum() {
        return calc.getDecimalFromString(flightnumLabel.getText());
    }

    private String getDepTime() throws NullPointerException {
        String hour = depTimeHourTextField.getText();
        String min = depTimeMinutesTextArea.getText();
        String timezone = depTimeZoneComboBox.getValue();
        if (hour.isEmpty() || min.isEmpty() || timezone.isEmpty()) {
            throw new NullPointerException("Please fill in the Departure time properly!");
        } else {
            String timeString = hour + ":" + min + " " + timezone;
            int time = 0;
            try {
                time = calc.getTimeFromString(timeString);
                return timeString;
            } catch (NumberFormatException e) {
                return "00:00 GMT";
            }
        }
    }

    private Float getFlighttime() {
        String flighttime = flighttimeTextArea.getText();
        if (flighttime.isEmpty()) {
            throw new NullPointerException("Please fill in a proper Flighttime using this format: HH:MM");
        } else {
            return calc.getFlighttimeFloat(flighttime);
        }
    }

    private String getArrTime() {
        try {
            String deptime = getDepTime();
            Float flighttime = getFlighttime();
            return calc.getTimePlusDuration(deptime, flighttime);
        } catch (NullPointerException e) {
            e.printStackTrace(System.out);
            return "00:00 GMT";
        }
    }

    private String getDOW() {
        String toReturn = "";
        for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isSelected()) {
                toReturn = toReturn + String.valueOf(i+1);
            }
        }
        return toReturn;
    }

    void recalcDOWBoxes(ActionEvent event) {
        boolean allSelected = true;
        for (CheckBox checkBox : checkBoxes) {
            if (!checkBox.isSelected()) {
                allSelected = false;
            }
        }
        dOWAllCheckBox.setSelected(allSelected);
    }

    private String getAircraft() {
        for (int i = 0; i < aircraftCheckBoxList.size(); i++) {
            if (aircraftCheckBoxList.get(i).isSelected()) {
                return String.valueOf(i + 1);
            }
        }
        return "";
    }

}
