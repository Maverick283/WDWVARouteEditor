/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import externalDB.Airports;
import externalDB.ExternalDBManager;
import externalDB.Routes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sql.Acarschat;
import sql.Aircraft;
import sql.Airlines;
import sql.Schedules;

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

    AircraftTab aircraftTab;
    ChatTab chatTab;
    ExternalDBTab externalDBTab;
    ProbelmaticRouteTab probelmaticRouteTab;
    @FXML
    private ImageView aircraftImage;
    @FXML
    private VBox listBox;

    ArrayList<Aircraft> aircraftList;
    @FXML
    private Slider enabledSlider;
    @FXML
    private Button toggleAircraftEnabledButton;
    @FXML
    private Label connectingInfoLabel;
    @FXML
    private TableView<Schedules> problematicRouteTable;
    private ArrayList<Acarschat> chatList;
    @FXML
    private ListView<?> messageList;
    @FXML
    private CheckBox showSystemMessagsCheckBox;
    private ArrayList<Schedules> faultySchedulesList;
    @FXML
    private Button refreshExternalDatabasesButton;
    private ExternalDBManager externalDB;
    @FXML
    private TableView<externalDB.Airlines> externalDBAirlinesTableView;
    @FXML
    private Button problematicRoutesRefreshButton;
    @FXML
    private TableView<Routes> externalDBRoutesTableView;
    @FXML
    private TableView<Airports> externalDBAirportsTableView;
    private ArrayList<Schedules> allSchedulesList;
    @FXML
    private TextField dbQueryTextArea;
    @FXML
    private Button submitQueryToDBButton;
    @FXML
    private Button createMissingRoutesButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new File("/" + calc.getTempPath()).mkdirs();
        errorWindow = new ErrorMessageController(this);
        placeSideLabel(14, 80);
        setConnectingInfoText("");
        dbQueryTextArea.setDisable(true);
        submitQueryToDBButton.setDisable(true);
        createMissingRoutesButton.setDisable(true);
        checkLogin();

        String ROUTES = calc.getTempPath() + "/routes.dat";
        String AIRLINES = calc.getTempPath() + "/airlines.dat";
        String AIRPORTS = calc.getTempPath() + "/airports.dat";
        externalDB = new ExternalDBManager(this, ROUTES, AIRPORTS, AIRLINES);
        aircraftTab = new AircraftTab(this, listBox, idLabel, icaoLabel, nameLabel, fullnameLabel, registrationLabel, downloadlinkLabel, imagelinkLabel, rangeLabel, weightLabel, cruiseLabel, maxpaxLabel, maxcargoLabel, minrankLabel, ranklevelLabel, aircraftImage, enabledSlider, toggleAircraftEnabledButton);
        probelmaticRouteTab = new ProbelmaticRouteTab(problematicRouteTable, this);
        chatTab = new ChatTab(messageList, showSystemMessagsCheckBox);
        externalDBTab = new ExternalDBTab(this, externalDB.getRoutes(), externalDB.getAirports(), externalDB.getAirlines(), externalDBRoutesTableView, externalDBAirlinesTableView, externalDBAirportsTableView);

        allSchedulesList = new ArrayList<Schedules>();
    }

    @FXML
    public void connectToDB() {
        setConnectingInfoText("Opening Connection... This will take a bit...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            dbQueryTextArea.setDisable(false);
            submitQueryToDBButton.setDisable(false);
            createMissingRoutesButton.setDisable(false);
            Platform.runLater(() -> {
                try {
                    getAircrafts();
                    getChat();
                } catch (SQLException ex) {
                    setConnectingInfoText("Error!");
                    ex.printStackTrace(System.err);
                }
            });
            setConnectingInfoText("Connected");
            connectToDBButton.setText("Disconnect");
            loginStatusLabel.setText("Connected as " + USERNAME);
            connectToDBButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    disconnectFromDB();
                }
            });

        } catch (SQLException | ClassNotFoundException ex) {
            setConnectingInfoText("Error!");
            ex.printStackTrace(System.err);
        }
    }

    public void setConnectingInfoText(String text) {

        Platform.runLater(() -> {
            connectingInfoLabel.setText(text);
        });
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
        aircraftList = new ArrayList();
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
        aircraftTab.createList(aircraftList);
        checkAllRoutesForErrors(aircraftList);

        //STEP 6: Clean-up environment
        rs.close();
        stmt.close();
    }

    private void checkAllRoutesForErrors(ArrayList<Aircraft> aircraftList) {
        //Checks for Aircraft Compatibility Issues
        try {
            Statement stmt = con.createStatement();
            String sql;
            sql = "SELECT * FROM schedules";
            ResultSet rs = stmt.executeQuery(sql);
            faultySchedulesList = new ArrayList();
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve Data                
                int id = rs.getInt("id");
                int aircraftID = rs.getInt("aircraft");
                String distance = rs.getString("distance");
                String flightnum = rs.getString("flightnum");
                String depicao = rs.getString("depicao");
                String arricao = rs.getString("arricao");
                String route = rs.getString("route");
                String routeDetails = rs.getString("route_details");
                String aircraft = rs.getString("aircraft");
                String flightlevel = rs.getString("flightlevel");
                String deptime = rs.getString("deptime");
                String arrtime = rs.getString("arrtime");
                float flighttime = rs.getFloat("flighttime");
                String daysofweek = rs.getString("daysofweek");
                float price = rs.getFloat("price");
                String flighttype = rs.getString("flighttype");
                int timesflown = rs.getInt("timesflown");
                String notes = rs.getString("notes");
                int enabled = rs.getInt("enabled");
                int bidid = rs.getInt("bidid");

                Schedules schedule = new Schedules(id, flightnum, depicao, arricao, route, routeDetails, aircraft, flightlevel, price, deptime, arrtime, flighttime, daysofweek, price, flighttype, timesflown, notes, enabled, bidid);
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

                        schedule.setIssue("Aircraft can't handle the distance");
                        faultySchedulesList.add(schedule);
                        System.out.print("Route distance: " + String.valueOf(distanceInt) + "nm  \t" + "Aircraft type: " + aircraftNAME + "  \tRange of aircraft: " + String.valueOf(rangeInt) + "nm\t");
                        System.out.println("Route with the ID " + id + " has a Problem!");
                    }
                } catch (NumberFormatException e) {
                    //catches Parse Errors, and outputs the strings that were tried to be parsed.
                    System.out.println("Error" + distance + "    " + range);
                }

                allSchedulesList.add(schedule);
            }

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();

            //Checks for real World Routes
            ArrayList<Schedules> nonExcistingSchedules = externalDB.checkForRealRoutes(allSchedulesList);
            for (Schedules nonExcistingSchedule : nonExcistingSchedules) {
                nonExcistingSchedule.setIssue("Not a real route");
            }
            faultySchedulesList.addAll(nonExcistingSchedules);

            probelmaticRouteTab.createList(faultySchedulesList);
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

        try {
            if (!URL.isEmpty()) {
                urlTextField.setText(URL);
            }
            if (!USERNAME.isEmpty()) {
                userTextField.setText(USERNAME);
            }
            if (!PASSWORD.isEmpty()) {
                pwBox.setText(PASSWORD);
            }
        } catch (NullPointerException e) {
            System.out.println("User Credentials Fail!");
            e.printStackTrace(System.err);
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
            e.printStackTrace(System.err);
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
            connectToDBButton.setText("Connect to databse");
            connectingInfoLabel.setText("Disconnected");
            loginStatusLabel.setText("Not looged in!");
            dbQueryTextArea.setDisable(true);
            submitQueryToDBButton.setDisable(true);
            createMissingRoutesButton.setDisable(true);
            connectToDBButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    connectToDB();
                }
            });
        } catch (SQLException | NullPointerException ex) {

        }
    }

    @FXML
    private void enableAircraftToggled(ActionEvent event) {
        aircraftTab.enableAircraftToggled(event);
    }

    private void getChat() throws SQLException {
        Statement stmt = con.createStatement();
        String sql;
        sql = "SELECT * FROM acarschat";
        ResultSet rs = stmt.executeQuery(sql);

        //STEP 5: Extract data from result set
        chatList = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt("id");
            int pilotid = rs.getInt("pilotid");
            String message = rs.getString("message");
            String time = rs.getString("time");
            String timestamp = rs.getString("timestamp");

            Acarschat chatMessage = new Acarschat(id, pilotid, message, time, timestamp);
            chatList.add(chatMessage);

        }
        chatTab.createChatHistory(chatList);
    }

    @FXML
    private void refreshChatHistory(ActionEvent event) {
        chatTab.refreshChatHistory(event);
    }

    @FXML
    private void refreshExternalDatabases(ActionEvent event) {
        String ROUTES = calc.getTempPath() + "/routes.dat";
        String AIRLINES = calc.getTempPath() + "/airlines.dat";
        String AIRPORTS = calc.getTempPath() + "/airports.dat";
        calc.saveFile("http://sourceforge.net/p/openflights/code/HEAD/tree/openflights/data/routes.dat?format=raw", ROUTES);
        calc.saveFile("http://sourceforge.net/p/openflights/code/HEAD/tree/openflights/data/airlines.dat?format=raw", AIRLINES);
        calc.saveFile("http://sourceforge.net/p/openflights/code/HEAD/tree/openflights/data/airports.dat?format=raw", AIRPORTS);
        externalDB.refreshData();
        externalDBTab.refresh();
    }

    @FXML
    private void refreshProblematicRoutes(ActionEvent event) {
        probelmaticRouteTab.refresh(event);
    }

    @FXML
    private void submitQueryToDB(ActionEvent event) {
        try {
            Statement statement = con.createStatement();
            // Result set get the result of the SQL query
            PreparedStatement preparedStatement = con.prepareStatement(dbQueryTextArea.getText());
            preparedStatement.execute();

            preparedStatement.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            ;
        }
    }

    void submitQuery(String sql) {
        try {
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
            System.out.println(sql);
            stat.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    @FXML
    private void createMissingRoutes(ActionEvent event) {
        for (Schedules schedule : allSchedulesList) {
            String route = schedule.getRoute();
            if (route.contains("www.") || route.isEmpty()) {
                String[] routeInfo = findRoute(schedule.getDepicao(), schedule.getArricao());
                schedule.setRoute(routeInfo[0]);
                schedule.setNotes(routeInfo[1]);
                submitQuery("UPDATE schedules SET route = " + schedule.getRoute() +" WHERE id = " + schedule.getId() + ";");
                submitQuery("UPDATE schedules SET notes = " + schedule.getNotes() +" WHERE id = " + schedule.getId() + ";");
                System.out.println("Route WDW" + schedule.getFlightnum() + " changed to: " + schedule.getRoute());
            }
        }
    }

    private String[] findRoute(String depicao, String arricao) {
        try {
            String line = "";
            URL myUrl = null;
            BufferedReader in = null;
            myUrl = new URL("http://www.vatroute.net/web_showfp.php?dep=" + depicao + "&dest=" + arricao);
            in = new BufferedReader(new InputStreamReader(myUrl.openStream()));
            String route = "";
            String notes = "";
            while ((line = in.readLine()) != null) {
                //System.out.println(line);
                if (line.contains("class=\"tdcellspacing-right\">")) {
                    line = line.substring(line.indexOf("class=\"tdcellspacing-right\">") + 28);
                    line = line.substring(0, line.indexOf("</td>"));
                    line = line.replaceAll("<i></i>", "");
                    line = line.replaceAll("<b></b>", "");
                    line = line.replaceAll("<u></u>", "");
                    route = line;

                    line = in.readLine();
                    line = line.substring(line.indexOf("class=\"tdcellspacing\">") + 22);
                    line = line.substring(0, line.indexOf("<</td>"));
                    notes = line;
                }
            }
            
            String[] toReturn = new String[2];
            toReturn[0] = route;
            toReturn[1] = notes;
            
            return toReturn;
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return new String[] {"www.rfinder.asalink.net/free/"};
    }

}
