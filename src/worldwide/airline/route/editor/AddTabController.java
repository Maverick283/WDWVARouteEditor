/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sql.Aircraft;
import sql.Ranks;
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
    private final TextField addAircraftICAO;
    private final TextField addAircraftType;
    private final TextField addAircraftName;
    private final TextField addAircraftRegistration;
    private final TextField addAircraftMAXPax;
    private final TextField addAircraftMaxCargo;
    private final TextField addAircraftDownloadLink;
    private final TextField addAircraftImageLink;
    private final TextField addAircraftRange;
    private final TextField addAircraftWeight;
    private final TextField addAircraftCruise;
    private final ComboBox<String> addAircraftMinRank;
    private final Slider addAircraftEnabledSlider;
    private final Button addAircraftEnabledButton;
    private final ImageView addAircraftImageView;
    private final VBox addAircraftRoutesVBox;
    private final CheckBox addAircraftFilterCoutesCheckBox;
    private final TextField addAircraftRoutesFilterICAOTextField;
    private final Button addAircraftAddPlusRoute;
    private final Button addAircraftAircraftONLY;
    private final Button addAircraftClear;
    private ArrayList<Ranks> ranks;
    private final Label addAircraftMessageLabel;
    private ArrayList<CheckBox> routeCheckBoxes;

    AddTabController(MainUIController father, SQLHandler sqlHandler, TextField DepICAOTextArea, TextField ArrICAOTextArea, Button AddScheduleButton, Button ClearScheduleButton,
            CheckBox DOWAllCheckBox, CheckBox DOWFridayCheckBox, CheckBox DOWMondayCheckBox, CheckBox DOWSaturdayCheckBox, CheckBox DOWSundayCheckBox,
            CheckBox DOWThursdayCheckBox, CheckBox DOWTuesdayCheckBox, CheckBox DOWWednesdayCheckBox, TextField DepTimeHourTextField,
            TextField DepTimeMinutesTextArea, ChoiceBox<String> DepTimeZoneComboBox, TextField DistanceTextField, ScrollBar FlightNumScrollBar, ComboBox<String> FlightlevelComboBox,
            Label FlightnumLabel, TextField FlighttimeTextArea, ChoiceBox<String> FlighttypeComboBox, TextField PriceTextField, TextArea RouteTextArea, Label ScheduleMessageLabel,
            VBox SchedulesAirplaneVBox, TextField addAircraftICAO, TextField addAircraftType, TextField addAircraftName, TextField addAircraftRegistration, TextField addAircraftMAXPax,
            TextField addAircraftMaxCargo, TextField addAircraftDownloadLink, TextField addAircraftImageLink, TextField addAircraftRange, TextField addAircraftWeight,
            TextField addAircraftCruise, ComboBox<String> addAircraftMinRank, Slider addAircraftEnabledSlider, Button addAircraftEnabledButton, ImageView addAircraftImageView,
            VBox addAircraftRoutesVBox, CheckBox addAircraftFilterCoutesCheckBox, TextField addAircraftRoutesFilterICAOTextField, Button addAircraftAddPlusRoute,
            Button addAircraftAircraftONLY, Button addAircraftClear, Label addAircraftMessageLabel) {
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
        this.addAircraftICAO = addAircraftICAO;
        this.addAircraftType = addAircraftType;
        this.addAircraftName = addAircraftName;
        this.addAircraftRegistration = addAircraftRegistration;
        this.addAircraftMAXPax = addAircraftMAXPax;
        this.addAircraftMaxCargo = addAircraftMaxCargo;
        this.addAircraftDownloadLink = addAircraftDownloadLink;
        this.addAircraftImageLink = addAircraftImageLink;
        this.addAircraftRange = addAircraftRange;
        this.addAircraftWeight = addAircraftWeight;
        this.addAircraftCruise = addAircraftCruise;
        this.addAircraftMinRank = addAircraftMinRank;
        this.addAircraftEnabledSlider = addAircraftEnabledSlider;
        this.addAircraftEnabledButton = addAircraftEnabledButton;
        this.addAircraftImageView = addAircraftImageView;
        this.addAircraftRoutesVBox = addAircraftRoutesVBox;
        this.addAircraftFilterCoutesCheckBox = addAircraftFilterCoutesCheckBox;
        this.addAircraftRoutesFilterICAOTextField = addAircraftRoutesFilterICAOTextField;
        this.addAircraftAddPlusRoute = addAircraftAddPlusRoute;
        this.addAircraftAircraftONLY = addAircraftAircraftONLY;
        this.addAircraftClear = addAircraftClear;
        this.addAircraftMessageLabel = addAircraftMessageLabel;

        takenFlightnums = new ArrayList<>();
        checkBoxes = new CheckBox[]{dOWMondayCheckBox, dOWTuesdayCheckBox, dOWWednesdayCheckBox, dOWThursdayCheckBox, dOWFridayCheckBox, dOWSaturdayCheckBox, dOWSundayCheckBox};
        addAircraftEnabledButton.setStyle(STYLE.setBackgroundTransparent());

    }

    void initWithData() {
        initFlightnumberChoices();
        initFlightlevelBox();
        initDepTimeZoneBox();
        initFlighttypeBox();
        initAircraftList();
        initDOWChoices();
        initAddAircraftMinRank();
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
            CheckBox checkBox = new CheckBox(aircraft.getRegistration());
            aircraftCheckBoxList.add(checkBox);
            Label registration = new Label(aircraft.getFullname());
            aircraftBox.getChildren().addAll(checkBox, registration);
            aircraftBox.setSpacing(14);
            schedulesAirplaneVBox.getChildren().add(aircraftBox);
        }
    }

    private void initDOWChoices() {
        dOWAllCheckBox.setSelected(true);
        checkAllDOWChecboxes(new ActionEvent());
    }

    private void initEnabled(boolean isEnabled) {
        setSliderValue(isEnabled);
    }

    void enableAircraftToggled(ActionEvent event) {
        if (true) {
            if (getSliderValue()) {
                addAircraftEnabledSlider.setValue(1);
            } else {
                addAircraftEnabledSlider.setValue(0);
            }
        }
    }

    void setSliderValue(boolean value) {
        if (value) {
            addAircraftEnabledSlider.setValue(0);
        } else {
            addAircraftEnabledSlider.setValue(1);
        }
    }

    boolean getSliderValue() {
        return addAircraftEnabledSlider.getValue() == 0.0;
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
        scheduleMessageLabel.setText("");
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
        ArrayList aircraftsTicked = getAllAircraftsTicked();
        int amountOfAIrcraftsTicked = aircraftsTicked.size();
        int counter = 0;
        boolean allFlightsEntered = true;
        String errorMessageCollection = "";
        if (counter == amountOfAIrcraftsTicked) {
            scheduleMessageLabel.setText("Please select at least one aircraft!");
            return false;
        }

        while (counter < amountOfAIrcraftsTicked) {
            try {
                int id = 0;
                String flightnum = getFlightnum();
                String depicao = getDepICAO();
                String arricao = getArrICAO();
                String route = getRoute();
                String routeDetails = getRouteDetails();
                String aircraft = getAircraft();
                String flightlevel = getFlightlevelInFeet();
                float distance = getDistance();
                String deptime = getDepTime();
                String arrtime = getArrTime();
                float flighttime = getFlighttime();
                String daysofweek = getDOW();
                float price = getPrice();
                String flighttype = getFlighttype();
                String notes = "Created by Route Editor.";
                Schedules schedule = new Schedules(id, flightnum, depicao, arricao, route, routeDetails, aircraft, flightlevel, distance, deptime, arrtime, flighttime, daysofweek, price, flighttype, notes);
                father.createNewSchedule(schedule);

                counter++;
                untickFirstSelectedAircraft();
            } catch (NullPointerException e) {
                scheduleMessageLabel.setText("Please enter all the necessary information");
                return false;
            }
        }
        return true;
    }

    void clearSchedule(ActionEvent event) {
        initFlightnumberChoices();
        depICAOTextArea.setText("");
        arrICAOTextArea.setText("");
        routeTextArea.setText("");
        clearAircraftTicks();
        distanceTextField.setText("");
        depTimeHourTextField.setText("");
        depTimeMinutesTextArea.setText("");
        depTimeZoneComboBox.getSelectionModel().selectFirst();
        flighttimeTextArea.setText("");
        checkAllDOWChecboxes(new ActionEvent());
        priceTextField.setText("");
        flighttypeComboBox.getSelectionModel().selectFirst();
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

    private float getDistance() throws NullPointerException {
        String distance = distanceTextField.getText();
        distance = calc.getDecimalFromString(distance);
        float toReturn = Float.parseFloat(distance.replaceAll(",", "."));
        return toReturn;
    }

    private int getPrice() throws NullPointerException {
        String price = priceTextField.getText();
        price = calc.getDecimalFromString(price);
        float toReturn = Float.parseFloat(price);
        if (toReturn == 0) {
            throw new NullPointerException("No Price entered");
        } else {
            return (int) toReturn;
        }
    }

    private String getRoute() throws NullPointerException {
        String toReturn = routeTextArea.getText();
        if (!toReturn.isEmpty()) {
            return routeTextArea.getText();
        } else {
            throw new NullPointerException("No route entered");
        }
    }

    private String getDepICAO() throws NullPointerException {
        String toReturn = depICAOTextArea.getText();
        if (!toReturn.isEmpty()) {
            return depICAOTextArea.getText();
        } else {
            throw new NullPointerException("No Departure ICAO entered");
        }
    }

    private String getArrICAO() throws NullPointerException {
        String toReturn = arrICAOTextArea.getText();
        if (!toReturn.isEmpty()) {
            return arrICAOTextArea.getText();
        } else {
            throw new NullPointerException("No Arrival ICAO entered");
        }
    }

    private String getFlightlevelInFeet() throws NullPointerException {
        String flightlevel = flightlevelComboBox.getValue();
        try {
            flightlevel = calc.getDecimalFromString(flightlevel);
            return flightlevel + "00";
        } catch (NullPointerException e) {
            throw new NullPointerException("No Flightlevel entered");
        }
    }

    private String getFlighttype() throws NullPointerException {
        if (flighttypeComboBox.getValue().equalsIgnoreCase("Cargo")) {
            return "C";
        } else {
            return "P";
        }
    }

    private String getFlightnum() throws NullPointerException {
        String toReturn = calc.getDecimalFromString(flightnumLabel.getText());
        if (!toReturn.isEmpty()) {
            return toReturn;
        } else {
            throw new NullPointerException("No Flightnumber entered");
        }
    }

    private String getDepTime() {
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

    private Float getFlighttime() throws NullPointerException {
        String flighttime = flighttimeTextArea.getText();
        if (flighttime.isEmpty()) {
            throw new NullPointerException("Please fill in a proper Flighttime using this format: HH:MM");
        } else {
            return calc.getFlighttimeFloat(flighttime);
        }
    }

    private String getArrTime() throws NullPointerException {
        try {
            String deptime = getDepTime();
            Float flighttime = getFlighttime();
            return calc.getTimePlusDuration(deptime, flighttime);
        } catch (NullPointerException e) {
            e.printStackTrace(System.out);
            return "00:00 GMT";
        }
    }

    private String getDOW() throws NullPointerException {
        String toReturn = "";
        for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isSelected()) {
                toReturn = toReturn + String.valueOf(i + 1);
            }
        }
        if (!toReturn.isEmpty()) {
            return toReturn;
        } else {
            throw new NullPointerException("No Days of Week ticked");
        }
    }

    void recalcDOWBoxes(ActionEvent event) throws NullPointerException {
        boolean allSelected = true;
        for (CheckBox checkBox : checkBoxes) {
            if (!checkBox.isSelected()) {
                allSelected = false;
            }
        }
        dOWAllCheckBox.setSelected(allSelected);
    }

    private String getAircraft() throws NullPointerException {
        for (int i = 0; i < aircraftCheckBoxList.size(); i++) {
            if (aircraftCheckBoxList.get(i).isSelected()) {
                return String.valueOf(getAircraftIDByRegistration(aircraftCheckBoxList.get(i).getText()));
            }
        }
        //This statement will only be reached if there was no aircraft found.
        throw new NullPointerException("No Aircraft entered");
    }

    private ArrayList getAllAircraftsTicked() {
        ArrayList<String> toReturn = new ArrayList<>();
        for (CheckBox aircraftCheckBoxList1 : aircraftCheckBoxList) {
            if (aircraftCheckBoxList1.isSelected()) {
                toReturn.add(aircraftCheckBoxList1.getText());
            }
        }
        return toReturn;
    }

    private int getAircraftIDByRegistration(String registration) {
        return father.getAircraftIDByRegistration(registration);
    }

    private void untickFirstSelectedAircraft() {
        for (int i = 0; i < aircraftCheckBoxList.size(); i++) {
            if (aircraftCheckBoxList.get(i).isSelected()) {
                aircraftCheckBoxList.get(i).setSelected(false);
                i = aircraftCheckBoxList.size();
                flightnumberUp(new ActionEvent());
            }
        }
    }

    private String getRouteDetails() {
        return "NA";
    }

    private void clearAircraftTicks() {
        for (int i = 0; i < aircraftCheckBoxList.size(); i++) {
            aircraftCheckBoxList.get(i).setSelected(false);
        }
    }

    private void initAddAircraftMinRank() {
        ranks = new ArrayList<Ranks>();
        try {
            ResultSet rs = sqlHandler.getResult("SELECT * from ranks;");
            while (rs.next()) {
                int rankid = rs.getInt("rankid");
                String rankName = rs.getString("rank");
                String rankimage = rs.getString("rankimage");
                short minHours = rs.getShort("minhours");
                float payrate = rs.getFloat("payrate");
                Ranks rank = new Ranks(rankid, rankName, rankimage, minHours, payrate);
                ranks.add(rank);

            }
            ArrayList<String> rankEntries = new ArrayList<>();
            for (Ranks rank : ranks) {
                rankEntries.add(rank.getRank());
            }
            addAircraftMinRank.setItems(FXCollections.observableArrayList(rankEntries));
        } catch (SQLException ex) {

        }

    }

    void onlyShowRoutesContainingOnAction(ActionEvent event) {
        suggestRoutesForAircraft(event);
    }

    void onlyShowRoutesICAOOnAction(ActionEvent event) {
        suggestRoutesForAircraft(event);
    }

    void addAircraftAndRoutePressed(ActionEvent event) {
        addAircraftAircraftONLYPressed(event);
        System.out.println("Unsupported Method: addAircraftAndRoutePressed at worldwide.airline.route.editor.AddTabController"); //To change body of generated methods, choose Tools | Templates.
    }

    void addAircraftAircraftONLYPressed(ActionEvent event) {
        try {
            addAircraftMessageLabel.setText("");
            String icao = getAircraftICAO();
            String name = getAircraftType();
            String fullname = getAircraftName();
            String registration = getAircraftRegistration();
            String downloadlink = getAircraftDownloadLink();
            String imagelink = getAircraftImageLink();
            String range = getAircraftRange();
            String weight = getAircraftWeight();
            String cruise = getAircraftCruise();
            float maxpax = getAircraftMaxPax();
            float maxcargo = getAircraftMaxCargo();
            int minrank = getRankIDByName(addAircraftMinRank.getSelectionModel().getSelectedItem());
            short enabled = addAircraftGetEnabledAsInt();
            Aircraft aircraft = new Aircraft(icao, name, fullname, registration, downloadlink, imagelink, range, weight, cruise, maxpax, maxcargo, minrank, enabled);
            if (!father.createNewAircraft(aircraft)) {
                throw new NullPointerException("The aircraft was not added to the Database. The registration is possibly already used!");
            }
        } catch (NullPointerException e) {
            addAircraftMessageLabel.setText(e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private String getAircraftICAO() throws NullPointerException {
        if (addAircraftICAO.getText().isEmpty()) {
            throw new NullPointerException("Aircraft ICAO not entered!");
        }
        return addAircraftICAO.getText().substring(0, 4);
    }

    private String getAircraftType() throws NullPointerException {
        if (addAircraftType.getText().isEmpty()) {
            throw new NullPointerException("Aircraft Type not entered!");
        }
        return addAircraftType.getText();
    }

    private String getAircraftName() throws NullPointerException {
        if (addAircraftName.getText().isEmpty()) {
            throw new NullPointerException("Aircraft Name not entered!");
        }
        return addAircraftName.getText();
    }

    private String getAircraftRegistration() throws NullPointerException {
        if (addAircraftRegistration.getText().isEmpty()) {
            throw new NullPointerException("Aircraft Registration not entered!");
        }
        return addAircraftRegistration.getText();
    }

    private String getAircraftImageLink() throws NullPointerException {
        return addAircraftImageLink.getText();
    }

    private String getAircraftDownloadLink() throws NullPointerException {
        return addAircraftDownloadLink.getText();
    }

    private String getAircraftRange() throws NullPointerException {
        if (!addAircraftRange.getText().matches("[0-9]+")) {
            throw new NullPointerException("Aircraft Range must be entered in a valif format (eg. 3800)!");
        }
        return addAircraftRange.getText() + " nm";
    }

    private int getAircraftRangeInt() {
        try {
            if (!addAircraftRange.getText().matches("[0-9]+")) {
                throw new NullPointerException("Aircraft Range must be entered in a valif format (eg. 3800)!");
            }
            return Integer.parseInt(addAircraftRange.getText());
        } catch (NullPointerException e) {
            addAircraftMessageLabel.setText(e.getMessage());
            return 0;
        }
    }

    private String getAircraftWeight() throws NullPointerException {
        if (!addAircraftWeight.getText().matches("[0-9]+")) {
            throw new NullPointerException("Aircraft Weight must be entered in a valif format (eg. 87930)!");
        }
        return addAircraftWeight.getText() + " lbs";
    }

    private String getAircraftCruise() throws NullPointerException {
        if (!addAircraftCruise.getText().matches("[0-9]+")) {
            throw new NullPointerException("Aircraft Cruise must be entered in a valif format (eg. 486)!");
        }
        return addAircraftCruise.getText() + "kts";
    }

    private float getAircraftMaxPax() throws NullPointerException {
        if (!addAircraftMAXPax.getText().matches("[0-9]+")) {
            throw new NullPointerException("Aircraft Max Pax must be entered in a valif format (eg. 142)!");
        }
        return Float.parseFloat(addAircraftMAXPax.getText());
    }

    private float getAircraftMaxCargo() throws NullPointerException {
        if (!addAircraftMaxCargo.getText().matches("[0-9]+")) {
            throw new NullPointerException("Aircraft Max Cargo must be entered in a valif format (eg. 41391)!");
        }
        return Float.parseFloat(addAircraftMaxCargo.getText());
    }

    void addAircraftImageLinkEntered(ActionEvent event) throws NullPointerException {
        addAircraftImageView.setImage(new Image(addAircraftImageLink.getText()));
    }

    void addAircraftClearPressed(ActionEvent event) throws NullPointerException {
        System.out.println("Unsupported Method: addAircraftClearPressed at worldwide.airline.route.editor.AddTabController"); //To change body of generated methods, choose Tools | Templates.
    }

    private int getRankIDByName(String name) {
        for (Ranks rank : ranks) {
            if (name.equalsIgnoreCase(rank.getRank())) {
                return rank.getRankid();
            }
        }
        return 0;
    }

    private short addAircraftGetEnabledAsInt() {
        if (addAircraftEnabledSlider.getValue() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    void suggestRoutesForAircraft(ActionEvent event) {
        try {
            int range = getAircraftRangeInt();
            String icaoToContain = addAircraftRoutesFilterICAOTextField.getText();
            if (!addAircraftFilterCoutesCheckBox.isSelected()) {
                icaoToContain = "";
            }
            addAircraftRoutesVBox.getChildren().clear();
            routeCheckBoxes = new ArrayList<CheckBox>();

            ResultSet rs = getSuggestedRoutes(range, icaoToContain);
            while (rs.next()) {
                String checkBoxString = rs.getString("depicao") + " - " + rs.getString("arricao");
                CheckBox create = new CheckBox(checkBoxString);
                create.setMinWidth(150);
                create.setMaxWidth(create.getMinWidth());
                Label count = new Label(rs.getString("count"));
                HBox routeSuggestion = new HBox(create, count);
                addAircraftRoutesVBox.getChildren().add(routeSuggestion);
                routeCheckBoxes.add(create);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private ResultSet getSuggestedRoutes(int range, String ICAOtoContain) throws SQLException {
        String part1 = "SELECT depicao, arricao, count(*) as count FROM schedules";
        String WHERE = " WHERE";
        String distance = " distance < " + range;
        String AND = " AND";
        String icao = " (depicao = '" + ICAOtoContain + "' OR arricao = '" + ICAOtoContain + "')";
        String part2 = " GROUP BY depicao,arricao ORDER BY count DESC ;";
        if (ICAOtoContain.isEmpty()) {
            AND = "";
            icao = "";
        }
        String sql = part1 + WHERE + distance + AND + icao + part2;
        return sqlHandler.getResult(sql);
    }

    void addAircraftCheckAllRoutes(ActionEvent event) {
        System.out.println("Unsupported Method: addAircraftCheckAllRoutes at worldwide.airline.route.editor.AddTabController"); //To change body of generated methods, choose Tools | Templates.
    }

}
