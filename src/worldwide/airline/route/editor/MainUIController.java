/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sql.Aircraft;

/**
 *
 * @author patrickburkart, eduardsvilnis
 *
 */
public class MainUIController implements Initializable {

    @FXML
    private AnchorPane mainPanel;
    private Button importButton;
    private Button downloadButton;
    final FileChooser fileChooser = new FileChooser();
    private ErrorMessageController errorWindow;
    private HBox sideLabels;
    private RouteOrganizer routes;
    private String aircraftTYPE;

    Connection con;

    private String URL;
    private String USERNAME;
    private String PASSWORD;
    @FXML
    private Button connectToDBButton;
    @FXML
    private Label idLabel;
    @FXML
    private Label icaoLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label fullnameLabel;
    @FXML
    private Label registrationLabel;
    @FXML
    private Label downloadlinkLabel;
    @FXML
    private Label imagelinkLabel;
    @FXML
    private Label rangeLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label cruiseLabel;
    @FXML
    private Label maxpaxLabel;
    @FXML
    private Label maxcargoLabel;
    @FXML
    private Label minrankLabel;
    @FXML
    private Label ranklevelLabel;
    @FXML
    private Label loginStatusLabel;
    @FXML
    private Button changeLoginCredentialsButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorWindow = new ErrorMessageController(this);
        placeSideLabel(14, 80);
        checkLogin();
    }

    @FXML
    public void connectToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            loginStatusLabel.setText("Connected as " + USERNAME);
            getAircrafts();

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(System.err);
        }
    }

    private void openFileChooser() {
        fileChooser.setTitle("Open .csv File");
        Stage fileChooserStage = new Stage();
        File file = fileChooser.showOpenDialog(fileChooserStage);
        if (file != null) {
            try {
                readFile(file);
            } catch (IOException ex) {
                errorWindow.launchErrorMessage("This does not seem to be a .csv File!\n Please make sure to select a .csv File!");
            }
        }
    }

    private void readFile(File file) throws IOException {
        csvReader reader = new csvReader(file.getPath());
        routes = reader.read();
        recaluclateStats();
    }

    private void placeSideLabel(int x, int y) {
        sideLabels = new HBox();
        sideLabels.setLayoutX(x);
        sideLabels.setLayoutY(y);
        sideLabels.setSpacing(5);
        mainPanel.getChildren().add(sideLabels);
    }

    public void recaluclateStats() {
        VBox labelPart = new VBox();
        Label label1 = new Label("Routes registered:");
        Label label2 = new Label("Total distance:");
        Label label3 = new Label("Total planes:");
        labelPart.getChildren().addAll(label1, label2, label3);

        VBox numberPart = new VBox();
        Label label4 = new Label(String.valueOf(routes.getTotalAmount()));
        Label label5 = new Label(String.valueOf(routes.getTotalDistance()));
        Label label6 = new Label(String.valueOf(routes.numberOfAircrafts()));
        numberPart.getChildren().addAll(label4, label5, label6);
        sideLabels.getChildren().addAll(labelPart, numberPart);
    }

    private void getAircrafts() throws SQLException {
        Statement stmt = con.createStatement();
        String sql;
        sql = "SELECT * FROM aircraft";
        ResultSet rs = stmt.executeQuery(sql);

        //STEP 5: Extract data from result set
        ArrayList<Aircraft> aircraftList = new ArrayList();
        while (rs.next()) {
            //Retrieve all aircraft information           
            int id = rs.getInt("id");
            String icao = rs.getString("icao");
            String name = rs.getString("name");
            String fullname = rs.getString("fullname");
            String registration = rs.getString("registration");
            String downloadlink = rs.getString("downloadlink");
            String imagelink = rs.getString("imagelink");
            String range = rs.getString("range");
            String weight = rs.getString("weight");
            String cruise = rs.getString("cruise");
            float maxpax = rs.getFloat("maxpax");
            float maxcargo = rs.getFloat("maxcargo");          
            int minrank = rs.getInt("minrank");          
            int ranklevel = rs.getInt("ranklevel");
            short enabled = rs.getShort("enabled");

            aircraftList.add(new Aircraft(id, icao, name, fullname, registration, downloadlink, imagelink, range, weight, cruise, maxpax, maxcargo, minrank, ranklevel, enabled));

        }
        checkAllRoutesForAircraftCompatibility(aircraftList);

        //STEP 6: Clean-up environment
        rs.close();
        stmt.close();
    }

    private void checkAllRoutesForAircraftCompatibility(ArrayList<Aircraft> aircraftList) {
        try {
            Statement stmt = con.createStatement();
            String sql;
            sql = "SELECT * FROM schedules";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve Data                
                int id = rs.getInt("id");
                int aircraftID = rs.getInt("aircraft");
                String distance = rs.getString("distance");
                String aircraftNAME = aircraftList.get(aircraftID - 1).getName();
                //Get Data to a string that can be parsed
                distance = distance.replaceAll("[^\\d.]", "");

                String range = aircraftList.get(aircraftID - 1).getRange();
                range = range.replaceAll("[^\\d.]", "");
                try {
                    //parse Strings to Ints
                    int distanceInt = (int) Double.parseDouble(distance);
                    int rangeInt = (int) Double.parseDouble(range);
                    //catch Strings like "3000-3400nm" and take the longer range
                    if (rangeInt > 10000) {
                        rangeInt = (int) Double.parseDouble(range.substring(3, range.length()));

                    }

                    //compare aircraft range to route distance
                    if (rangeInt < distanceInt) {
                        //print message if needed
                        System.out.print("Route distance: " + String.valueOf(distanceInt) + "nm  \t" + "Aircraft type: " + aircraftNAME + "  \tRange of aircraft: " + String.valueOf(rangeInt) + "nm\t");
                        System.out.println("Route with the ID " + id + " has a Problem!");
                    }
                } catch (NumberFormatException e) {
                    //catches Parse Errors, and outputs the strings that were tried to be parsed.
                    System.out.println("Error" + distance + "    " + range);
                }

            }

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    private void checkLogin() {
        String tempPath = calc.getTempPath() + "/WDWVALogin.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(tempPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String rep = line.substring(0, line.indexOf("=") - 1).trim();
                String value = line.substring(line.indexOf("=") + 1, line.length()).trim();
                switch (rep) {
                    case "URL":
                        URL = value;
                        System.out.println("URL = " + URL);
                        break;
                    case "USERNAME":
                        USERNAME = value;
                        System.out.println("USERNAME = " + USERNAME);
                        break;
                    case "PASSWORD":
                        PASSWORD = value;
                        System.out.println("PASSWORD = " + PASSWORD);
                        break;
                    default:
                        System.out.println("Login data not complete...");
                        break;

                }
            }
        } catch (IOException e) {
            System.out.println("No previous login data found");
            getLoginCredentials();
        }
    }

    @FXML
    private void getLoginCredentials() {
        Stage loginStage = new Stage();
        loginStage.setTitle("Login to MySQL");
        loginStage.show();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Label url = new Label("URL:");
        grid.add(url, 0, 3);

        TextField urlTextField = new TextField();
        grid.add(urlTextField, 1, 3);
        
        if(!URL.isEmpty()){
            urlTextField.setText(URL);
        }
        if(!USERNAME.isEmpty()){
            userTextField.setText(USERNAME);
        }
        if(!PASSWORD.isEmpty()){
            pwBox.setText(PASSWORD);
        }

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                URL = urlTextField.getText();
                USERNAME = userTextField.getText();
                PASSWORD = pwBox.getText();
                loginStage.close();
                saveLoginData();
            }

        });

        Scene scene = new Scene(grid, 300, 275);
        loginStage.setScene(scene);
    }

    private void saveLoginData() {
        BufferedWriter writer = null;
        try {
            File logFile = new File(calc.getTempPath() + "/WDWVALogin.txt");

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write("URL = " + URL);
            writer.newLine();
            writer.write("USERNAME = " + USERNAME);
            writer.newLine();
            writer.write("PASSWORD = " + PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }

    void disconnectFromDB() {
        try {
            con.close();
        } catch (SQLException ex) {

        }
    }

}
