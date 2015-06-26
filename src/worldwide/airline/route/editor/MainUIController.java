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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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
import sql.Pilots;
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

    AircraftTabController aircraftTab;
    ChatTabController chatTab;
    ExternalDBTabController externalDBTab;
    ProbelmaticRouteTabController probelmaticRouteTab;
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
    @FXML
    private TableView<Schedules> routeTable;
    @FXML
    private Button routesRefreshButton;
    private RoutesTabController routesTab;
    private SQLHandler sqlHandler;
    @FXML
    private Label addFlightnumLabel;
    private ScrollBar addFlightNumScrollBar;
    @FXML
    private TextField addDepICAOTextArea;
    @FXML
    private TextField addArrICAOTextArea;
    @FXML
    private TextArea addRouteTextArea;
    @FXML
    private ComboBox<String> addFlightlevelComboBox;
    @FXML
    private TextField addDistanceTextField;
    @FXML
    private TextField addPriceTextField;
    @FXML
    private ChoiceBox<String> addFlighttypeComboBox;
    @FXML
    private TextField addDepTimeHourTextField;
    @FXML
    private TextField addDepTimeMinutesTextArea;
    @FXML
    private ChoiceBox<String> addDepTimeZoneComboBox;
    @FXML
    private TextField addFlighttimeTextArea;
    @FXML
    private VBox addSchedulesAirplaneVBox;
    @FXML
    private CheckBox addDOWAllCheckBox;
    @FXML
    private CheckBox addDOWMondayCheckBox;
    @FXML
    private CheckBox addDOWThursdayCheckBox;
    @FXML
    private CheckBox addDOWWednesdayCheckBox;
    @FXML
    private CheckBox addDOWTuesdayCheckBox;
    @FXML
    private CheckBox addDOWSaturdayCheckBox;
    @FXML
    private CheckBox addDOWFridayCheckBox;
    @FXML
    private CheckBox addDOWSundayCheckBox;
    @FXML
    private Button addAddScheduleButton;
    @FXML
    private Button clearScheduleButton;
    @FXML
    private Label addScheduleMessageLabel;

    AddTabController addTab;
    Tab[] databaseTabs;
    @FXML
    private Tab mainTAB;
    @FXML
    private Tab airplanesTAB;
    @FXML
    private Tab routesTAB;
    @FXML
    private Tab problematicRoutesTAB;
    @FXML
    private Tab chatTAB;
    @FXML
    private Tab externalDBTAB;
    @FXML
    private Tab addTAB;
    @FXML
    private Tab pilotsTAB;
    private PilotsTabController pilotsTab;
    @FXML
    private TableView<Pilots> pilotsTable;
    private ArrayList<Pilots> pilotsList;
    @FXML
    private TextField addAircraftICAO;
    @FXML
    private TextField addAircraftType;
    @FXML
    private TextField addAircraftName;
    @FXML
    private TextField addAircraftRegistration;
    @FXML
    private TextField addAircraftMAXPax;
    @FXML
    private TextField addAircraftMaxCargo;
    @FXML
    private TextField addAircraftDownloadLink;
    @FXML
    private TextField addAircraftImageLink;
    @FXML
    private TextField addAircraftRange;
    @FXML
    private TextField addAircraftWeight;
    @FXML
    private TextField addAircraftCruise;
    @FXML
    private ComboBox<String> addAircraftMinRank;
    @FXML
    private Slider addAircraftEnabledSlider;
    @FXML
    private Button addAircraftEnabledButton;
    @FXML
    private ImageView addAircraftImageView;
    @FXML
    private VBox addAircraftRoutesVBox;
    @FXML
    private CheckBox addAircraftFilterCoutesCheckBox;
    @FXML
    private TextField addAircraftRoutesFilterICAOTextField;
    @FXML
    private Button addAircraftAddPlusRoute;
    @FXML
    private Button addAircraftAircraftONLY;
    @FXML
    private Button addAircraftClear;
    @FXML
    private Label addAircraftMessageLabel;
    @FXML
    private CheckBox addAircraftCheckAll;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new File("/" + calc.getTempPath()).mkdirs();
        errorWindow = new ErrorMessageController(this);
        sqlHandler = new SQLHandler(this);
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
        aircraftTab = new AircraftTabController(this, listBox, idLabel, icaoLabel, nameLabel, fullnameLabel, registrationLabel, downloadlinkLabel, imagelinkLabel,
                rangeLabel, weightLabel, cruiseLabel, maxpaxLabel, maxcargoLabel, minrankLabel, ranklevelLabel, aircraftImage, enabledSlider, toggleAircraftEnabledButton);
        pilotsTab = new PilotsTabController(this, pilotsTable, sqlHandler);
        probelmaticRouteTab = new ProbelmaticRouteTabController(problematicRouteTable, this, sqlHandler);
        chatTab = new ChatTabController(messageList, showSystemMessagsCheckBox);
        externalDBTab = new ExternalDBTabController(this, externalDB.getRoutes(), externalDB.getAirports(), externalDB.getAirlines(), externalDBRoutesTableView,
                externalDBAirlinesTableView, externalDBAirportsTableView);
        routesTab = new RoutesTabController(this, routeTable, sqlHandler);
        addTab = new AddTabController(this, sqlHandler, addDepICAOTextArea, addArrICAOTextArea, addAddScheduleButton, clearScheduleButton, addDOWAllCheckBox, addDOWFridayCheckBox,
                addDOWMondayCheckBox, addDOWSaturdayCheckBox, addDOWSundayCheckBox, addDOWThursdayCheckBox, addDOWTuesdayCheckBox, addDOWWednesdayCheckBox,
                addDepTimeHourTextField, addDepTimeMinutesTextArea, addDepTimeZoneComboBox, addDistanceTextField, addFlightNumScrollBar, addFlightlevelComboBox,
                addFlightnumLabel, addFlighttimeTextArea, addFlighttypeComboBox, addPriceTextField, addRouteTextArea, addScheduleMessageLabel, addSchedulesAirplaneVBox,
                addAircraftICAO, addAircraftType, addAircraftName, addAircraftRegistration, addAircraftMAXPax, addAircraftMaxCargo, addAircraftDownloadLink, addAircraftImageLink,
                addAircraftRange, addAircraftWeight, addAircraftCruise, addAircraftMinRank, addAircraftEnabledSlider, addAircraftEnabledButton, addAircraftImageView,
                addAircraftRoutesVBox, addAircraftFilterCoutesCheckBox, addAircraftRoutesFilterICAOTextField, addAircraftAddPlusRoute, addAircraftAircraftONLY, addAircraftClear,
                addAircraftMessageLabel);

        allSchedulesList = new ArrayList<Schedules>();
        databaseTabs = new Tab[]{airplanesTAB, routesTAB, pilotsTAB, problematicRoutesTAB, chatTAB, addTAB};
        connectionChanged(false);
    }

    @FXML
    public void connectToDB() {
        connectToDBButton.setText("Connecting...");
        connectToDBButton.setDisable(true);
        setConnectingInfoText("Opening Connection... This will take a bit...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Platform.runLater(() -> {
                try {
                    //internal changes
                    sqlHandler.setConnection(con);
                    getAircrafts();
                    getChat();
                    getPilotsFromDataBase();
                    addTab.initWithData();
                    //ui changes
                    connectionChanged(sqlHandler.connectionAvail());
                    loginStatusLabel.setText("Connected as " + USERNAME);
                    setConnectingInfoText("Connected");
                    dbQueryTextArea.setDisable(false);
                    submitQueryToDBButton.setDisable(false);
                    createMissingRoutesButton.setDisable(false);
                } catch (SQLException ex) {
                    setConnectingInfoText("Error!");
                    ex.printStackTrace(System.err);
                }
            });
            connectToDBButton.setText("Disconnect");
            connectToDBButton.setDisable(false);
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
        String sql = "SELECT * FROM aircraft";
        ResultSet rs = sqlHandler.getResult(sql);

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
        getRoutesFromDataBase();
        routesTab.initTableView(allSchedulesList);
        checkAllRoutesForErrors(aircraftList);

        //STEP 6: Clean-up environment
        rs.close();
    }

    private void getRoutesFromDataBase() {
        try {
            String sql = "SELECT * FROM schedules";
            ResultSet rs = sqlHandler.getResult(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve Data                
                int id = rs.getInt("id");
                int aircraftID = rs.getInt("aircraft");
                float distance = rs.getFloat("distance");
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

                Schedules schedule = new Schedules(id, flightnum, depicao, arricao, route, routeDetails, aircraft, flightlevel, distance, deptime, arrtime, flighttime, daysofweek, price, flighttype, timesflown, notes, enabled, bidid);

                allSchedulesList.add(schedule);
            }

            //STEP 6: Clean-up environment
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    private void checkAllRoutesForErrors(ArrayList<Aircraft> aircraftList) {
        faultySchedulesList = new ArrayList<Schedules>();
        //Checks for Aircraft Compatibility Issues
        for (int i = 0; i < allSchedulesList.size(); i++) {

            Schedules current = allSchedulesList.get(i);
            int aircraftID = Integer.parseInt(current.getAircraft()) - 1;
            String aircraftNAME = aircraftList.get(aircraftID).getName();
            float distance = current.getDistance();
            //Unneccesary String operation. Might use again for locality issues:     distance = distance.replaceAll("[^\\d.]", "");

            String range = aircraftList.get(aircraftID).getRange();
            range = range.replaceAll("[^\\d.]", "");
            try {
                //parse Strings to Ints
                int distanceInt = (int) distance;
                int rangeInt = (int) Double.parseDouble(range);
                //catch Strings like "3000-3400nm" and take the longer range
                if (rangeInt > 10000) {
                    rangeInt = (int) Double.parseDouble(range.substring(3, range.length()));

                }

                //compare aircraft range to route distance
                if (rangeInt < distanceInt) {
                    //print message if needed

                    current.setIssue("Aircraft can't handle the distance");
                    faultySchedulesList.add(current);
                    //System.out.print("Route distance: " + String.valueOf(distanceInt) + "nm  \t" + "Aircraft type: " + aircraftNAME + "  \tRange of aircraft: " + String.valueOf(rangeInt) + "nm\t");
                    //System.out.println("Route with the ID " + id + " has a Problem!");
                }
            } catch (NumberFormatException e) {
                //catches Parse Errors, and outputs the strings that were tried to be parsed.
                System.out.println("Error" + distance + "    " + range);
            }
        }

        //Checks for real World Routes
        ArrayList<Schedules> nonExcistingSchedules = externalDB.checkForRealRoutes(allSchedulesList);
        for (Schedules nonExcistingSchedule : nonExcistingSchedules) {
            nonExcistingSchedule.setIssue("Not a real route");
        }
        faultySchedulesList.addAll(nonExcistingSchedules);

        probelmaticRouteTab.createList(faultySchedulesList);
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
            sqlHandler.closeConnection();
            connectToDBButton.setText("Connect to databse");
            connectingInfoLabel.setText("Disconnected");
            loginStatusLabel.setText("Not looged in!");
            dbQueryTextArea.setDisable(true);
            submitQueryToDBButton.setDisable(true);
            createMissingRoutesButton.setDisable(true);
            deleteAllDBData();
            connectToDBButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    connectToDB();
                }
            });
            connectionChanged(sqlHandler.connectionAvail());
        } catch (SQLException | NullPointerException ex) {

        }
    }

    @FXML
    private void enableAircraftToggled(ActionEvent event) {
        aircraftTab.enableAircraftToggled(event);
    }

    private void getChat() throws SQLException {
        String sql = "SELECT * FROM acarschat";
        ResultSet rs = sqlHandler.getResult(sql);

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
        submitQuery(dbQueryTextArea.getText());
    }

    void submitQuery(String sql) {
        sqlHandler.executeUpdate(sql);
    }

    @FXML
    private void createMissingRoutes(ActionEvent event) {
        for (Schedules schedule : allSchedulesList) {
            String route = schedule.getRoute();
            if (route.contains("www.") || route.isEmpty() || route.equalsIgnoreCase("Direct")) {
                String[] routeInfo = findRoute(schedule.getDepicao(), schedule.getArricao());
                try {
                    schedule.setRoute(routeInfo[0]);
                    schedule.setNotes(routeInfo[1]);
                    submitQuery("UPDATE schedules SET route = '" + schedule.getRoute() + "' WHERE id = " + schedule.getId() + ";");
                    submitQuery("UPDATE schedules SET notes = '" + schedule.getNotes() + "' WHERE id = " + schedule.getId() + ";");
                    System.out.println("Route WDW" + schedule.getFlightnum() + " changed to: " + schedule.getRoute());
                } catch (ArrayIndexOutOfBoundsException e) {

                }
            }
        }
    }

    public String[] findRoute(String depicao, String arricao) {
        try {
            String line = "";
            String route = "";
            String notes = "";
            String distance = "";
            URL myUrl = null;
            BufferedReader in = null;
            String[] toReturn = new String[3];
            myUrl = new URL("http://www.vatroute.net/web_showfp.php?dep=" + depicao + "&dest=" + arricao);
            in = new BufferedReader(new InputStreamReader(myUrl.openStream()));
            while ((line = in.readLine()) != null) {
                //System.out.println(line);
                if (line.contains("class=\"tdcellspacing-right\">")) {
                    line = line.substring(line.indexOf("class=\"tdcellspacing-right\">") + 28);
                    line = line.substring(0, line.indexOf("</td>"));
                    line = line.replaceAll("<i></i>", "");
                    line = line.replaceAll("<b></b>", "");
                    line = line.replaceAll("<u></u>", "");
                    route = line;

                    try {
                        line = in.readLine();

                        line = line.substring(line.indexOf("class=\"tdcellspacing\">") + 22);
                        line = line.substring(0, line.indexOf("</td>"));
                        line = line.replaceAll("<i></i>", "");
                        line = line.replaceAll("<b></b>", "");
                        line = line.replaceAll("<u></u>", "");
                        notes = line;
                    } catch (StringIndexOutOfBoundsException e) {
                    }
                    toReturn[0] = route;
                    toReturn[1] = notes;
                }
                if (line.contains("Great circle distance:")) {
                    distance = line.substring(line.indexOf("Great circle distance:</b>") + 26, line.length() - 5).trim();
                    toReturn[2] = distance;
                }
            }
            if (route.isEmpty() || distance.isEmpty()) {
                return new String[]{"www.rfinder.asalink.net/free/"};
            }

            return toReturn;

        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return new String[]{"www.rfinder.asalink.net/free/"
        };
    }

    @FXML
    private void refreshRoutes(ActionEvent event) {
        getRoutesFromDataBase();
    }

    @FXML
    private void checkAllDOWCheckboxes(ActionEvent event) {
        addTab.checkAllDOWChecboxes(event);
    }

    @FXML
    private void addSchedule(ActionEvent event) {
        if (!addTab.addSchedule(event)) {
            System.out.println("Schedule could not be added!");
        }
    }

    @FXML
    private void clearSchedule(ActionEvent event) {
        addTab.clearSchedule(event);
    }

    ArrayList getAllUnavailFlightnum() {
        ArrayList<Integer> toReturn = new ArrayList<>();
        try {
            for (Schedules schedule : allSchedulesList) {
                toReturn.add(Integer.parseInt(schedule.getFlightnum()));
            }
        } catch (NullPointerException e) {

        }
        return toReturn;
    }

    @FXML
    private void addFlightNumberUp(ActionEvent event) {
        addTab.flightnumberUp(event);
    }

    @FXML
    private void addFlightNumberDown(ActionEvent event) {
        addTab.flightnumberDown(event);
    }

    @FXML
    private void addICAOEntered(Event event) {
        addTab.iCAOEntered(event);
    }

    @FXML
    private void addRecalcDOWBoxes(ActionEvent event) {
        addTab.recalcDOWBoxes(event);
    }

    void connectionChanged(boolean connectionAvail) {
        for (int i = 0; i < databaseTabs.length; i++) {
            databaseTabs[i].setDisable(!connectionAvail);
        }
    }

    int getAircraftIDByRegistration(String registration) {
        for (int i = 0; i < aircraftList.size(); i++) {
            if (registration.equalsIgnoreCase(aircraftList.get(i).getRegistration())) {
                return i + 1;
            }
        }
        return 0;
    }

    public void getPilotsFromDataBase() throws SQLException {

        String sql = "SELECT * FROM pilots";
        ResultSet rs = sqlHandler.getResult(sql);

        //STEP 5: Extract data from result set
        pilotsList = new ArrayList();
        while (rs.next()) {
            int pilotid = rs.getInt("pilotid");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String email = rs.getString("email");
            String location = rs.getString("location");
            String hub = rs.getString("hub");
            String password = rs.getString("password");
            String salt = rs.getString("salt");
            String bgimage = rs.getString("bgimage");
            Date lastlogin;
            try {
                lastlogin = rs.getDate("lastlogin");
            } catch (SQLException e) {
                lastlogin = new Date(0);
            }
            int totalflights = rs.getInt("totalflights");
            float totalhours = rs.getFloat("totalhours");
            float totalpay = rs.getFloat("totalpay");
            float transferhours = rs.getFloat("transferhours");
            int rankid = rs.getInt("rankid");
            String rank = rs.getString("rank");
            int ranklevel = rs.getInt("ranklevel");
            short confirmed = rs.getShort("confirmed");
            short retired = rs.getShort("retired");
            Date joindate;
            try {
                joindate = rs.getDate("joindate");
            } catch (SQLException e) {
                joindate = new Date(0);
            }
            Date lastpirep;
            try {
                lastpirep = rs.getDate("lastpirep");
            } catch (SQLException e) {
                lastpirep = new Date(0);
            }
            Date lastclient = sqlHandler.getLastClientLoginByPilotID(pilotid);
            int vatsimid = sqlHandler.getVatsimIDByPilotID(pilotid);

            Pilots pilot = new Pilots(pilotid, firstname, lastname, email, location, hub, password, salt, bgimage, lastlogin, totalflights, totalhours, totalpay, transferhours, rankid, rank, ranklevel, confirmed, retired, joindate, lastpirep, lastclient, vatsimid);
            pilotsList.add(pilot);

        }
        pilotsTab.createList(pilotsList);
    }

    private void deleteAllDBData() {
        allSchedulesList.clear();
        aircraftList.clear();
        pilotsList.clear();
        chatList.clear();
        faultySchedulesList.clear();
    }

    public boolean createNewSchedule(Schedules schedule) {
        String[] fi = new String[15];
        fi[0] = schedule.getFlightnum();
        fi[1] = schedule.getDepicao();
        fi[2] = schedule.getArricao();
        fi[3] = schedule.getRoute();
        fi[4] = schedule.getRouteDetails();
        fi[5] = schedule.getAircraft();
        fi[6] = schedule.getFlightlevel();
        fi[7] = String.valueOf(schedule.getDistance());
        fi[8] = schedule.getDeptime();
        fi[9] = schedule.getArrtime();
        fi[10] = String.valueOf(schedule.getFlighttime());
        fi[11] = schedule.getDaysofweek();
        fi[12] = String.valueOf(schedule.getPrice());
        fi[13] = schedule.getFlighttype();
        fi[14] = schedule.getNotes();

        //returns true if sql operation is succesfull, false if not
        boolean scheduleAdded = sqlHandler.executeQuery("INSERT INTO wdwvacom_wdw.schedules (code, flightnum, depicao, arricao, route, route_details, aircraft, flightlevel, distance, deptime, arrtime, flighttime, daysofweek, price, flighttype, timesflown, notes, enabled, bidid) \n"
                + "	VALUES ('WDW', '" + fi[0] + "', '" + fi[1] + "', '" + fi[2] + "', '" + fi[3] + "', '" + fi[4] + "', '" + fi[5] + "', '" + fi[6] + "', " + fi[7] + ", '" + fi[8] + "', '" + fi[9] + "', " + fi[10] + ", '" + fi[11] + "', " + fi[12] + ", '" + fi[13] + "', DEFAULT, '" + fi[14] + "', DEFAULT, DEFAULT);");

        if (scheduleAdded) {
            schedule.setId(sqlHandler.getIDOfScheduleByFlightnum(schedule.getFlightnum()));
            allSchedulesList.add(schedule);
        }
        return scheduleAdded;
    }

    public boolean createNewAircraft(Aircraft aircraft) {
        boolean registrationAvailable = true;
        for (Aircraft instance : aircraftList) {
            if (instance.getRegistration().equalsIgnoreCase(aircraft.getRegistration())) {
                registrationAvailable = false;
            }
        }
        if(registrationAvailable){
        String[] ai = new String[13];
        ai[0] = aircraft.getIcao();
        ai[1] = aircraft.getName();
        ai[2] = aircraft.getFullname();
        ai[3] = aircraft.getRegistration();
        ai[4] = aircraft.getDownloadlink();
        ai[5] = aircraft.getImagelink();
        ai[6] = aircraft.getRange();
        ai[7] = aircraft.getWeight();
        ai[8] = aircraft.getCruise();
        ai[9] = String.valueOf(aircraft.getMaxpax());
        ai[10] = String.valueOf(aircraft.getMaxcargo());
        ai[11] = String.valueOf(aircraft.getMinrank());
        ai[12] = String.valueOf(aircraft.getEnabled());

        boolean aircraftAdded = sqlHandler.executeQuery("INSERT INTO wdwvacom_wdw.aircraft (icao, `name`, fullname, registration, downloadlink, imagelink, `range`, weight, cruise, maxpax, maxcargo, minrank, ranklevel, enabled) \n"
                + "	VALUES ('" + ai[0] + "', '" + ai[1] + "', '" + ai[2] + "', '" + ai[3] + "', '" + ai[4] + "', '" + ai[5] + "', '" + ai[6] + "', '" + ai[7] + "', '" + ai[8] + "', " + ai[9] + ", " + ai[10] + ", " + ai[11] + ", DEFAULT, " + ai[12] + ")");

        if (aircraftAdded) {
            aircraft.setId(sqlHandler.getIDOfAircraftByRegistration(aircraft.getRegistration()));
            aircraftList.add(aircraft);
        }
        return aircraftAdded;}
        else{
            return false;
        }
    }

    @FXML
    private void addAircraftImageLinkEntered(ActionEvent event) {
        addTab.addAircraftImageLinkEntered(event);
    }

    @FXML
    private void onlyShowRoutesContainingOnAction(ActionEvent event) {
        addTab.onlyShowRoutesContainingOnAction(event);
    }

    @FXML
    private void onlyShowRoutesICAOOnAction(ActionEvent event) {
        addTab.onlyShowRoutesICAOOnAction(event);
    }

    @FXML
    private void addAircraftAndRoutePressed(ActionEvent event) {
        addTab.addAircraftAndRoutePressed(event);
    }

    @FXML
    private void addAircraftAircraftONLYPressed(ActionEvent event) {
        addTab.addAircraftAircraftONLYPressed(event);
    }

    @FXML
    private void addAircraftClearPressed(ActionEvent event) {
        addTab.addAircraftClearPressed(event);
    }

    @FXML
    private void addAircraftEnableToggled(ActionEvent event) {
        addTab.enableAircraftToggled(event);
    }
    
    @FXML
    private void suggestRoutesForAircraft(ActionEvent event){
        addTab.suggestRoutesForAircraft(event);
    }

    @FXML
    private void addAircraftCheckAllRoutes(ActionEvent event) {
        addTab.addAircraftCheckAllRoutes(event);
    }

}
