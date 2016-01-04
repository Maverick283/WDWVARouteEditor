/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;


import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patrick
 */
public class SQLHandler {

    private Connection con;
    MainUIController mainUI;

    public SQLHandler(MainUIController mainUI, Connection con) {
        this.mainUI = mainUI;
        this.con = con;
    }

    public SQLHandler(MainUIController mainUI) {
        this.mainUI = mainUI;
        con = null;
    }

    ResultSet getResult(String sql) throws SQLException {
        Statement stmt = con.createStatement();
        return stmt.executeQuery(sql);
    }

    void closeConnection() throws SQLException {
        con.close();
    }

    boolean executeUpdate(String sql) {
        try {
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
            System.out.println(sql);
            stat.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Couldn't submit query " + sql);
            ex.printStackTrace(System.out);
            return false;
        }
    }

    boolean executeQuery(String sql) {
        return executeQuery(sql, true);
    }

    boolean executeQuery(String sql, boolean printQuery) {
        try {
            Statement stat = con.createStatement();
            stat.execute(sql);
            if (printQuery) {
                System.out.println(sql);
            }
            stat.close();
            return true;
        } catch (MySQLNonTransientConnectionException ex) {
            return false;
        } catch (SQLException ex) {
            System.out.println("Couldn't submit query " + sql);
            ex.printStackTrace(System.out);
            return false;
        }
    }

    void changeFlightNum(int editedID, String newFlightNum) {
        executeUpdate(" UPDATE schedules SET flightnum = " + newFlightNum + " WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changeArricao(int editedID, String newArricao) {
        executeUpdate(" UPDATE schedules SET arricao = '" + newArricao + "' WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changeDepicao(int editedID, String newDepicao) {
        executeUpdate(" UPDATE schedules SET depicao = '" + newDepicao + "' WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changeRoute(int editedID, String newRoute) {
        executeUpdate(" UPDATE schedules SET route = '" + newRoute + "' WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changeRouteDetails(int editedID, String newRouteDetails) {
        executeUpdate(" UPDATE schedules SET route_details = '" + newRouteDetails + "' WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changeAircraft(int editedID, String newAircraft) {
        executeUpdate(" UPDATE schedules SET aircraft = '" + newAircraft + "' WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changeFlightlevel(int editedID, String newFlightlevel) {
        executeUpdate(" UPDATE schedules SET flightlevel = '" + newFlightlevel + "' WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changeDistance(int editedID, Float newDistance) {
        executeUpdate(" UPDATE schedules SET distance = " + newDistance + " WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changeDeptime(int editedID, String newDeptime) {
        executeUpdate(" UPDATE schedules SET deptime = '" + newDeptime + "' WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changeArrtime(int editedID, String arrTime) {
        executeUpdate(" UPDATE schedules SET arrtime = '" + arrTime + "' WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changeFlightime(int editedID, Float newFlightime) {
        executeUpdate(" UPDATE schedules SET flighttime = " + newFlightime + " WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changeDaysofweek(int editedID, String newDaysofweek) {
        executeUpdate(" UPDATE schedules SET daysofweek = '" + newDaysofweek + "' WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changePrice(int editedID, Float newPrice) {
        executeUpdate(" UPDATE schedules SET price = " + newPrice + " WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changeFlighttype(int editedID, String newFlighttype) {
        executeUpdate(" UPDATE schedules SET flighttype = " + newFlighttype + " WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changeTimesflown(int editedID, int newTimesflown) {
        executeUpdate(" UPDATE schedules SET timesflown = " + newTimesflown + " WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changeNotes(int editedID, String newNotes) {
        executeUpdate(" UPDATE schedules SET notes = '" + newNotes + "' WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void changeEnabled(int editedID, int newEnabled) {
        executeUpdate(" UPDATE schedules SET enabled = " + newEnabled + " WHERE id = " + String.valueOf(editedID) + "; ");
    }

    void setConnection(Connection con) {
        this.con = con;
    }

    boolean connectionAvail() {
        try {
            return executeQuery("select * from loa WHERE id = 1;", false);
        } catch (NullPointerException e) {
            return false;
        }
    }

    void changePilotFirstName(int editedID, String newFirstName) {
        System.out.println("Unsupported Method: changePilotFirstName at worldwide.airline.route.editor.SQLHandler"); //To change body of generated methods, choose Tools | Templates.
    }

    void changePilotLastName(int editedID, String newLastName) {
        System.out.println("Unsupported Method: changePilotLastName at worldwide.airline.route.editor.SQLHandler"); //To change body of generated methods, choose Tools | Templates.
    }

    void changePilotEmail(int editedID, String newEmail) {
        System.out.println("Unsupported Method: changePilotEmail at worldwide.airline.route.editor.SQLHandler"); //To change body of generated methods, choose Tools | Templates.
    }

    void changePilotHub(int editedID, String newHub) {
        System.out.println("Unsupported Method: changePilotHub at worldwide.airline.route.editor.SQLHandler"); //To change body of generated methods, choose Tools | Templates.
    }

    Date getLastClientLoginByPilotID(int pilotid) {
        String column = "logintime";
        String sql = "SELECT " + column + " FROM sessions WHERE pilotid = " + pilotid + " ORDER BY logintime DESC LIMIT 1;";
        try {
            ResultSet rs = getResult(sql);
            rs.next();
            return rs.getDate(column);
        } catch (SQLException | NullPointerException ex) {
            return new Date(0);
        }
    }

    int getVatsimIDByPilotID(int pilotid) {
        String column = "value";
        String table = "fieldvalues";
        try {
            ResultSet rs = getResult("select " + column + " from " + table + " WHERE pilotid = " + pilotid + ";");
            rs.next();
            return rs.getInt(column);
        } catch (SQLException | NullPointerException ex) {
            return 0;
        }
    }

    Integer getIDOfScheduleByFlightnum(String flightnum) {
        String column = "id";
        String table = "schedules";
        try {
            ResultSet rs = getResult("select " + column + " from " + table + " WHERE flightnum = " + flightnum + ";");
            rs.next();
            return rs.getInt(column);
        } catch (SQLException | NullPointerException ex) {
            return 0;
        }
    }

    Integer getIDOfAircraftByRegistration(String registration) {
        String column = "id";
        String table = "aircraft";
        try {
            ResultSet rs = getResult("select " + column + " from " + table + " WHERE registration = '" + registration + "';");
            rs.next();
            return rs.getInt(column);
        } catch (SQLException | NullPointerException ex) {
            return 0;
        }
    }
}
