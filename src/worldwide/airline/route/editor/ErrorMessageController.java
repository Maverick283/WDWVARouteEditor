/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author patrickburkart
 */
public class ErrorMessageController implements Initializable {

    @FXML
    private Label errorMessage;
    @FXML
    private Button cancelButton;
    @FXML
    private Button gotItButton;

    private Parent parent;
    private Scene scene;
    private Stage stage;
    MainUIController father;
    private boolean tryAgain;
    private boolean expectsResponse;
    Method toCall;

    public ErrorMessageController(MainUIController father) {
        this.father = father;
        tryAgain = false;
        expectsResponse = false;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorMessage.fxml"));
        fxmlLoader.setController(this);
        try {
            parent = (Parent) fxmlLoader.load();
            scene = new Scene(parent, 400, 200);
            this.stage = new Stage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void launchErrorMessage(String message) {
        this.stage = new Stage();
        stage.setTitle("Error!");
        stage.setScene(scene);
        stage.setResizable(false);
        errorMessage.setText(message);
        stage.show();
    }
    
    public void launchErrorMessage(String message, Method toCall){
        expectsResponse = true;
        this.toCall = toCall;
        launchErrorMessage(message);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cancel(ActionEvent event) {
        stage.close();
    }

    @FXML
    private void gotIt(ActionEvent event) {
        tryAgain = true;
        cancel(event);
        try {
            toCall.invoke(this, "");
        } catch (Exception ex) {
            
        }
    }
    
    public boolean tryAgain(){
        boolean toReturn = tryAgain;
        tryAgain = false;
        return toReturn;
    }

}
