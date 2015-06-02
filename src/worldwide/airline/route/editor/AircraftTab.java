/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import sql.Aircraft;

/**
 *
 * @author Patrick
 */
public class AircraftTab {

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
    private final MainUIController father;
    private ArrayList<Aircraft> aircraftList;

    AircraftTab(MainUIController father, VBox listBox, Label idLabel, Label icaoLabel, Label nameLabel, Label fullnameLabel, Label registrationLabel, Label downloadlinkLabel, Label imagelinkLabel, Label rangeLabel, Label weightLabel, Label cruiseLabel, Label maxpaxLabel, Label maxcargoLabel, Label minrankLabel, Label ranklevelLabel, ImageView aircraftImage) {
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
        createList(father.aircraftList);
    }

    private void createList(ArrayList<Aircraft> aircraftList) {
        for (Aircraft aircraft : aircraftList) {
            Label name = new Label(aircraft.getName());
            name.setOnMouseClicked((MouseEvent event) -> {
                displayByID(aircraft.getId());
            });
            listBox.getChildren().add(name);
        }
    }

    private void displayByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
