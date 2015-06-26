/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import sql.Airlines;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "schedules")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedules.findAll", query = "SELECT s FROM Schedules s"),
    @NamedQuery(name = "Schedules.findById", query = "SELECT s FROM Schedules s WHERE s.id = :id"),
    @NamedQuery(name = "Schedules.findByFlightnum", query = "SELECT s FROM Schedules s WHERE s.flightnum = :flightnum"),
    @NamedQuery(name = "Schedules.findByDepicao", query = "SELECT s FROM Schedules s WHERE s.depicao = :depicao"),
    @NamedQuery(name = "Schedules.findByArricao", query = "SELECT s FROM Schedules s WHERE s.arricao = :arricao"),
    @NamedQuery(name = "Schedules.findByFlightlevel", query = "SELECT s FROM Schedules s WHERE s.flightlevel = :flightlevel"),
    @NamedQuery(name = "Schedules.findByDistance", query = "SELECT s FROM Schedules s WHERE s.distance = :distance"),
    @NamedQuery(name = "Schedules.findByDeptime", query = "SELECT s FROM Schedules s WHERE s.deptime = :deptime"),
    @NamedQuery(name = "Schedules.findByArrtime", query = "SELECT s FROM Schedules s WHERE s.arrtime = :arrtime"),
    @NamedQuery(name = "Schedules.findByFlighttime", query = "SELECT s FROM Schedules s WHERE s.flighttime = :flighttime"),
    @NamedQuery(name = "Schedules.findByDaysofweek", query = "SELECT s FROM Schedules s WHERE s.daysofweek = :daysofweek"),
    @NamedQuery(name = "Schedules.findByPrice", query = "SELECT s FROM Schedules s WHERE s.price = :price"),
    @NamedQuery(name = "Schedules.findByFlighttype", query = "SELECT s FROM Schedules s WHERE s.flighttype = :flighttype"),
    @NamedQuery(name = "Schedules.findByTimesflown", query = "SELECT s FROM Schedules s WHERE s.timesflown = :timesflown"),
    @NamedQuery(name = "Schedules.findByEnabled", query = "SELECT s FROM Schedules s WHERE s.enabled = :enabled"),
    @NamedQuery(name = "Schedules.findByBidid", query = "SELECT s FROM Schedules s WHERE s.bidid = :bidid")})
public class Schedules implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "flightnum")
    private String flightnum;
    @Basic(optional = false)
    @Column(name = "depicao")
    private String depicao;
    @Basic(optional = false)
    @Column(name = "arricao")
    private String arricao;
    @Basic(optional = false)
    @Lob
    @Column(name = "route")
    private String route;
    @Basic(optional = false)
    @Lob
    @Column(name = "route_details")
    private String routeDetails;
    @Basic(optional = false)
    @Lob
    @Column(name = "aircraft")
    private String aircraft;
    @Basic(optional = false)
    @Column(name = "flightlevel")
    private String flightlevel;
    @Basic(optional = false)
    @Column(name = "distance")
    private float distance;
    @Basic(optional = false)
    @Column(name = "deptime")
    private String deptime;
    @Basic(optional = false)
    @Column(name = "arrtime")
    private String arrtime;
    @Basic(optional = false)
    @Column(name = "flighttime")
    private float flighttime;
    @Basic(optional = false)
    @Column(name = "daysofweek")
    private String daysofweek;
    @Basic(optional = false)
    @Column(name = "price")
    private float price;
    @Basic(optional = false)
    @Column(name = "flighttype")
    private String flighttype;
    @Basic(optional = false)
    @Column(name = "timesflown")
    private int timesflown;
    @Basic(optional = false)
    @Lob
    @Column(name = "notes")
    private String notes;
    @Basic(optional = false)
    @Column(name = "enabled")
    private int enabled;
    @Basic(optional = false)
    @Column(name = "bidid")
    private int bidid;
    @JoinColumn(name = "code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Airlines code;

    String issue;

    public Schedules() {
    }

    public Schedules(Integer id) {
        this.id = id;
    }

    public Schedules(Integer id, String flightnum, String depicao, String arricao, String route, String routeDetails, String aircraft, String flightlevel, float distance, String deptime, String arrtime, float flighttime, String daysofweek, float price, String flighttype, int timesflown, String notes, int enabled, int bidid) {
        this.id = id;
        this.flightnum = flightnum;
        this.depicao = depicao;
        this.arricao = arricao;
        this.route = route;
        this.routeDetails = routeDetails;
        this.aircraft = aircraft;
        this.flightlevel = flightlevel;
        this.distance = distance;
        this.deptime = deptime.trim().replaceAll("\\d([A-Z])", "$0 $1");
        this.arrtime = arrtime.trim().replaceAll("\\d([A-Z])", "$0 $1");
        this.flighttime = flighttime;
        this.daysofweek = daysofweek;
        this.price = price;
        this.flighttype = flighttype;
        this.timesflown = timesflown;
        this.notes = notes;
        this.enabled = enabled;
        this.bidid = bidid;
    }

    public Schedules(Integer id, String flightnum, String depicao, String arricao, String route, String routeDetails, String aircraft, String flightlevel, float distance, String deptime, String arrtime, float flighttime, String daysofweek, float price, String flighttype, String notes) {
        this.id = id;
        this.flightnum = flightnum;
        this.depicao = depicao;
        this.arricao = arricao;
        this.route = route;
        this.routeDetails = routeDetails;
        this.aircraft = aircraft;
        this.flightlevel = flightlevel;
        this.distance = distance;
        this.deptime = deptime.trim().replaceAll("\\d([A-Z])", "$0 $1");
        this.arrtime = arrtime.trim().replaceAll("\\d([A-Z])", "$0 $1");
        this.flighttime = flighttime;
        this.daysofweek = daysofweek;
        this.price = price;
        this.flighttype = flighttype;
        this.timesflown = 0;
        this.notes = notes;
        this.enabled = 1;
        this.bidid = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightnum() {
        return flightnum;
    }

    public void setFlightnum(String flightnum) {
        this.flightnum = flightnum;
    }

    public String getDepicao() {
        return depicao;
    }

    public void setDepicao(String depicao) {
        this.depicao = depicao;
    }

    public String getArricao() {
        return arricao;
    }

    public void setArricao(String arricao) {
        this.arricao = arricao;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRouteDetails() {
        return routeDetails;
    }

    public void setRouteDetails(String routeDetails) {
        this.routeDetails = routeDetails;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getFlightlevel() {
        return flightlevel;
    }

    public void setFlightlevel(String flightlevel) {
        this.flightlevel = flightlevel;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getDeptime() {
        return deptime;
    }

    public void setDeptime(String deptime) {
        this.deptime = deptime;
    }

    public String getArrtime() {
        return arrtime;
    }

    public void setArrtime(String arrtime) {
        this.arrtime = arrtime;
    }

    public float getFlighttime() {
        return flighttime;
    }

    public void setFlighttime(float flighttime) {
        this.flighttime = flighttime;
    }

    public String getDaysofweek() {
        return daysofweek;
    }

    public void setDaysofweek(String daysofweek) {
        this.daysofweek = daysofweek;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getFlighttype() {
        return flighttype;
    }

    public void setFlighttype(String flighttype) {
        this.flighttype = flighttype;
    }

    public int getTimesflown() {
        return timesflown;
    }

    public void setTimesflown(int timesflown) {
        this.timesflown = timesflown;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getBidid() {
        return bidid;
    }

    public void setBidid(int bidid) {
        this.bidid = bidid;
    }

    public Airlines getCode() {
        return code;
    }

    public String getIssue() {
        return issue;
    }

    public void setCode(Airlines code) {
        this.code = code;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedules)) {
            return false;
        }
        Schedules other = (Schedules) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Schedules[ id=" + id + " ]";
    }

}
