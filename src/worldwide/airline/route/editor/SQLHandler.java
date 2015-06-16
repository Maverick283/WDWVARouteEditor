/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Patrick
 */
public class SQLHandler {

    private Connection con;

    public SQLHandler(Connection con) {
        this.con = con;
    }

    public SQLHandler() {
        con = null;
    }

    ResultSet getResult(String sql) throws SQLException {
        Statement stmt = con.createStatement();
        return stmt.executeQuery(sql);
    }

    void closeConnection() throws SQLException {
        con.close();
    }

    void submitQuery(String sql) throws SQLException {
        Statement stat = con.createStatement();
        stat.executeUpdate(sql);
        System.out.println(sql);
        stat.close();
    }

    void changeFlightNum(int editedID, String newFlightNum) {
        try {
            submitQuery(" UPDATE schedules SET flightnum = " + newFlightNum + " WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changeArricao(int editedID, String newArricao) {
        try {
            submitQuery(" UPDATE schedules SET arricao = '" + newArricao + "' WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changeDepicao(int editedID, String newDepicao) {
        try {
            submitQuery(" UPDATE schedules SET depicao = '" + newDepicao + "' WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changeRoute(int editedID, String newRoute) {
        try {
            submitQuery(" UPDATE schedules SET route = '" + newRoute + "' WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changeRouteDetails(int editedID, String newRouteDetails) {
        try {
            submitQuery(" UPDATE schedules SET route_details = '" + newRouteDetails + "' WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changeAircraft(int editedID, String newAircraft) {
        try {
            submitQuery(" UPDATE schedules SET aircraft = '" + newAircraft + "' WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changeFlightlevel(int editedID, String newFlightlevel) {
        try {
            submitQuery(" UPDATE schedules SET flightlevel = '" + newFlightlevel + "' WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changeDistance(int editedID, Float newDistance) {
        try {
            submitQuery(" UPDATE schedules SET distance = " + newDistance + " WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changeDeptime(int editedID, String newDeptime) {
        try {
            submitQuery(" UPDATE schedules SET deptime = '" + newDeptime + "' WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changeArrtime(int editedID, String arrTime) {
        try {
            submitQuery(" UPDATE schedules SET arrtime = '" + arrTime + "' WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changeFlightime(int editedID, Float newFlightime) {
        try {
            submitQuery(" UPDATE schedules SET flighttime = " + newFlightime + " WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changeDaysofweek(int editedID, String newDaysofweek) {
        try {
            submitQuery(" UPDATE schedules SET daysofweek = '" + newDaysofweek + "' WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changePrice(int editedID, Float newPrice) {
        try {
            submitQuery(" UPDATE schedules SET price = " + newPrice + " WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changeFlighttype(int editedID, String newFlighttype) {
        try {
            submitQuery(" UPDATE schedules SET flighttype = " + newFlighttype + " WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changeTimesflown(int editedID, int newTimesflown) {
        try {
            submitQuery(" UPDATE schedules SET timesflown = " + newTimesflown + " WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changeNotes(int editedID, String newNotes) {
        try {
            submitQuery(" UPDATE schedules SET notes = '" + newNotes + "' WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void changeEnabled(int editedID, int newEnabled) {
        try {
            submitQuery(" UPDATE schedules SET enabled = " + newEnabled + " WHERE id = " + String.valueOf(editedID) + "; ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    void setConnection(Connection con) {
        this.con = con;
    }
}
