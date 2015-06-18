/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sql.Aircraft;

/**
 *
 * @author Patrick
 */
public class AircraftTabController {

    private final Label idLabel;
    private final Label icaoLabel;
    private final Label nameLabel;
    private final Label fullnameLabel;
    private final Label registrationLabel;
    private final Label downloadlinkLabel;
    private final Label imagelinkLabel;
    private final Label rangeLabel;
    private final Label weightLabel;
    private final Label cruiseLabel;
    private final Label maxpaxLabel;
    private final Label maxcargoLabel;
    private final Label minrankLabel;
    private final Label ranklevelLabel;
    private final ImageView aircraftImage;
    private final VBox listBox;
    private final Button toggleAircraftEnabledButton;
    private final Slider enabledSlider;
    private final MainUIController father;
    private ArrayList<Aircraft> aircraftList;
    private boolean editModeEnabled;

    HBox currentlyDisplayedHBox;

    AircraftTabController(MainUIController father, VBox listBox, Label idLabel, Label icaoLabel, Label nameLabel, Label fullnameLabel, Label registrationLabel, Label downloadlinkLabel, Label imagelinkLabel, Label rangeLabel, Label weightLabel, Label cruiseLabel, Label maxpaxLabel, Label maxcargoLabel, Label minrankLabel, Label ranklevelLabel, ImageView aircraftImage, Slider enabledSlider, Button toggleAircraftEnabledButton) {
        this.father = father;
        this.listBox = listBox;
        this.idLabel = idLabel;
        this.icaoLabel = icaoLabel;
        this.nameLabel = nameLabel;
        this.fullnameLabel = fullnameLabel;
        this.registrationLabel = registrationLabel;
        this.downloadlinkLabel = downloadlinkLabel;
        this.imagelinkLabel = imagelinkLabel;
        this.rangeLabel = rangeLabel;
        this.weightLabel = weightLabel;
        this.cruiseLabel = cruiseLabel;
        this.maxpaxLabel = maxpaxLabel;
        this.maxcargoLabel = maxcargoLabel;
        this.minrankLabel = minrankLabel;
        this.ranklevelLabel = ranklevelLabel;
        this.aircraftImage = aircraftImage;
        this.enabledSlider = enabledSlider;
        this.toggleAircraftEnabledButton = toggleAircraftEnabledButton;
        toggleAircraftEnabledButton.setStyle(STYLE.setBackgroundTransparent());

        editModeEnabled = false;
        currentlyDisplayedHBox = new HBox();
    }

    public void createList(ArrayList<Aircraft> aircraftList) {
        for (Aircraft aircraft : aircraftList) {
            HBox element = new HBox();
            element.setMinWidth(480);
            Label name = new Label(aircraft.getName());
            name.setMinWidth(120);
            Label registration = new Label(aircraft.getRegistration());
            registration.setMinWidth(60);
            element.getChildren().addAll(name, registration);
            element.setOnMouseClicked((MouseEvent event) -> {
                currentlyDisplayedHBox.setStyle(STYLE.setBackgroundTransparent());
                currentlyDisplayedHBox = element;
                currentlyDisplayedHBox.setStyle(STYLE.setBackground("78B7FF"));
                displayByID(aircraft);
            });
            listBox.getChildren().add(element);
        }
    }

    private void displayByID(Aircraft aircraft) {
        idLabel.setText(String.valueOf(aircraft.getId()));
        icaoLabel.setText(String.valueOf(aircraft.getIcao()));
        nameLabel.setText(String.valueOf(aircraft.getName()));
        fullnameLabel.setText(String.valueOf(aircraft.getFullname()));
        registrationLabel.setText(String.valueOf(aircraft.getRegistration()));
        downloadlinkLabel.setText(String.valueOf(aircraft.getDownloadlink()));
        imagelinkLabel.setText(String.valueOf(aircraft.getImagelink()));
        rangeLabel.setText(aircraft.getRange());
        weightLabel.setText(String.valueOf(aircraft.getWeight()));
        cruiseLabel.setText(String.valueOf(aircraft.getCruise()));
        maxpaxLabel.setText(String.valueOf(aircraft.getMaxpax()));
        maxcargoLabel.setText(String.valueOf(aircraft.getMaxcargo()));
        minrankLabel.setText(String.valueOf(aircraft.getMinrank()));
        ranklevelLabel.setText(String.valueOf(aircraft.getRanklevel()));
        aircraftImage.setImage(aircraft.getImage());
        initEnabled(aircraft.getEnabled() == 1);
    }

    private void initEnabled(boolean isEnabled) {
        setSliderValue(isEnabled);
    }

    void enableAircraftToggled(ActionEvent event) {
        if (editModeEnabled) {
            if (getSliderValue()) {
                enabledSlider.setValue(1);
            } else {
                enabledSlider.setValue(0);
            }
        }
    }

    void setSliderValue(boolean value) {
        if (value) {
            enabledSlider.setValue(0);
        } else {
            enabledSlider.setValue(1);
        }
    }

    boolean getSliderValue() {
        return enabledSlider.getValue() == 0.0;
    }

}
