/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

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
    private final ComboBox<?> flightlevelComboBox;
    private final TextField distanceTextField;
    private final TextField priceTextField;
    private final ChoiceBox<?> flighttypeComboBox;
    private final TextField depTimeHourTextField;
    private final TextField depTimeMinutesTextArea;
    private final ComboBox<?> depTimeZoneComboBox;
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

    AddTab(MainUIController father, SQLHandler sqlHandler, TextField DepICAOTextArea, TextField ArrICAOTextArea, Button AddScheduleButton, Button ClearScheduleButton,
            CheckBox DOWAllCheckBox, CheckBox DOWFridayCheckBox, CheckBox DOWMondayCheckBox, CheckBox DOWSaturdayCheckBox, CheckBox DOWSundayCheckBox,
            CheckBox DOWThursdayCheckBox, CheckBox DOWTuesdayCheckBox, CheckBox DOWWednesdayCheckBox, TextField DepTimeHourTextField,
            TextField DepTimeMinutesTextArea, ComboBox<?> DepTimeZoneComboBox, TextField DistanceTextField, ScrollBar FlightNumScrollBar, ComboBox<?> FlightlevelComboBox,
            Label FlightnumLabel, TextField FlighttimeTextArea, ChoiceBox<?> FlighttypeComboBox, TextField PriceTextField, TextArea RouteTextArea, Label ScheduleMessageLabel,
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
    }

}
