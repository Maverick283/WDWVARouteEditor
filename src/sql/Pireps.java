/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "pireps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pireps.findAll", query = "SELECT p FROM Pireps p"),
    @NamedQuery(name = "Pireps.findByPirepid", query = "SELECT p FROM Pireps p WHERE p.pirepid = :pirepid"),
    @NamedQuery(name = "Pireps.findByPilotid", query = "SELECT p FROM Pireps p WHERE p.pilotid = :pilotid"),
    @NamedQuery(name = "Pireps.findByCode", query = "SELECT p FROM Pireps p WHERE p.code = :code"),
    @NamedQuery(name = "Pireps.findByFlightnum", query = "SELECT p FROM Pireps p WHERE p.flightnum = :flightnum"),
    @NamedQuery(name = "Pireps.findByDepicao", query = "SELECT p FROM Pireps p WHERE p.depicao = :depicao"),
    @NamedQuery(name = "Pireps.findByArricao", query = "SELECT p FROM Pireps p WHERE p.arricao = :arricao"),
    @NamedQuery(name = "Pireps.findByAircraft", query = "SELECT p FROM Pireps p WHERE p.aircraft = :aircraft"),
    @NamedQuery(name = "Pireps.findByFlighttime", query = "SELECT p FROM Pireps p WHERE p.flighttime = :flighttime"),
    @NamedQuery(name = "Pireps.findByFlighttimeStamp", query = "SELECT p FROM Pireps p WHERE p.flighttimeStamp = :flighttimeStamp"),
    @NamedQuery(name = "Pireps.findByDistance", query = "SELECT p FROM Pireps p WHERE p.distance = :distance"),
    @NamedQuery(name = "Pireps.findByLandingrate", query = "SELECT p FROM Pireps p WHERE p.landingrate = :landingrate"),
    @NamedQuery(name = "Pireps.findBySubmitdate", query = "SELECT p FROM Pireps p WHERE p.submitdate = :submitdate"),
    @NamedQuery(name = "Pireps.findByAccepted", query = "SELECT p FROM Pireps p WHERE p.accepted = :accepted"),
    @NamedQuery(name = "Pireps.findByLoad", query = "SELECT p FROM Pireps p WHERE p.load = :load"),
    @NamedQuery(name = "Pireps.findByFuelused", query = "SELECT p FROM Pireps p WHERE p.fuelused = :fuelused"),
    @NamedQuery(name = "Pireps.findByFuelunitcost", query = "SELECT p FROM Pireps p WHERE p.fuelunitcost = :fuelunitcost"),
    @NamedQuery(name = "Pireps.findByFuelprice", query = "SELECT p FROM Pireps p WHERE p.fuelprice = :fuelprice"),
    @NamedQuery(name = "Pireps.findByPrice", query = "SELECT p FROM Pireps p WHERE p.price = :price"),
    @NamedQuery(name = "Pireps.findByFlighttype", query = "SELECT p FROM Pireps p WHERE p.flighttype = :flighttype"),
    @NamedQuery(name = "Pireps.findByGross", query = "SELECT p FROM Pireps p WHERE p.gross = :gross"),
    @NamedQuery(name = "Pireps.findByPilotpay", query = "SELECT p FROM Pireps p WHERE p.pilotpay = :pilotpay"),
    @NamedQuery(name = "Pireps.findByExpenses", query = "SELECT p FROM Pireps p WHERE p.expenses = :expenses"),
    @NamedQuery(name = "Pireps.findByRevenue", query = "SELECT p FROM Pireps p WHERE p.revenue = :revenue"),
    @NamedQuery(name = "Pireps.findBySource", query = "SELECT p FROM Pireps p WHERE p.source = :source"),
    @NamedQuery(name = "Pireps.findByExported", query = "SELECT p FROM Pireps p WHERE p.exported = :exported")})
public class Pireps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pirepid")
    private Integer pirepid;
    @Basic(optional = false)
    @Column(name = "pilotid")
    private int pilotid;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
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
    @Column(name = "aircraft")
    private String aircraft;
    @Basic(optional = false)
    @Column(name = "flighttime")
    private String flighttime;
    @Basic(optional = false)
    @Column(name = "flighttime_stamp")
    @Temporal(TemporalType.TIME)
    private Date flighttimeStamp;
    @Basic(optional = false)
    @Column(name = "distance")
    private short distance;
    @Basic(optional = false)
    @Column(name = "landingrate")
    private float landingrate;
    @Basic(optional = false)
    @Column(name = "submitdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submitdate;
    @Basic(optional = false)
    @Column(name = "accepted")
    private short accepted;
    @Basic(optional = false)
    @Lob
    @Column(name = "log")
    private String log;
    @Basic(optional = false)
    @Column(name = "load")
    private int load;
    @Basic(optional = false)
    @Column(name = "fuelused")
    private float fuelused;
    @Basic(optional = false)
    @Column(name = "fuelunitcost")
    private float fuelunitcost;
    @Basic(optional = false)
    @Column(name = "fuelprice")
    private float fuelprice;
    @Basic(optional = false)
    @Column(name = "price")
    private float price;
    @Basic(optional = false)
    @Column(name = "flighttype")
    private String flighttype;
    @Basic(optional = false)
    @Column(name = "gross")
    private float gross;
    @Basic(optional = false)
    @Column(name = "pilotpay")
    private float pilotpay;
    @Basic(optional = false)
    @Column(name = "expenses")
    private float expenses;
    @Basic(optional = false)
    @Lob
    @Column(name = "expenselist")
    private byte[] expenselist;
    @Basic(optional = false)
    @Column(name = "revenue")
    private float revenue;
    @Basic(optional = false)
    @Column(name = "source")
    private String source;
    @Basic(optional = false)
    @Column(name = "exported")
    private short exported;
    @Basic(optional = false)
    @Lob
    @Column(name = "rawdata")
    private String rawdata;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pirepid")
    private Collection<Pirepcomments> pirepcommentsCollection;

    public Pireps() {
    }

    public Pireps(Integer pirepid) {
        this.pirepid = pirepid;
    }

    public Pireps(Integer pirepid, int pilotid, String code, String flightnum, String depicao, String arricao, String route, String routeDetails, String aircraft, String flighttime, Date flighttimeStamp, short distance, float landingrate, Date submitdate, short accepted, String log, int load, float fuelused, float fuelunitcost, float fuelprice, float price, String flighttype, float gross, float pilotpay, float expenses, byte[] expenselist, float revenue, String source, short exported, String rawdata) {
        this.pirepid = pirepid;
        this.pilotid = pilotid;
        this.code = code;
        this.flightnum = flightnum;
        this.depicao = depicao;
        this.arricao = arricao;
        this.route = route;
        this.routeDetails = routeDetails;
        this.aircraft = aircraft;
        this.flighttime = flighttime;
        this.flighttimeStamp = flighttimeStamp;
        this.distance = distance;
        this.landingrate = landingrate;
        this.submitdate = submitdate;
        this.accepted = accepted;
        this.log = log;
        this.load = load;
        this.fuelused = fuelused;
        this.fuelunitcost = fuelunitcost;
        this.fuelprice = fuelprice;
        this.price = price;
        this.flighttype = flighttype;
        this.gross = gross;
        this.pilotpay = pilotpay;
        this.expenses = expenses;
        this.expenselist = expenselist;
        this.revenue = revenue;
        this.source = source;
        this.exported = exported;
        this.rawdata = rawdata;
    }

    public Integer getPirepid() {
        return pirepid;
    }

    public void setPirepid(Integer pirepid) {
        this.pirepid = pirepid;
    }

    public int getPilotid() {
        return pilotid;
    }

    public void setPilotid(int pilotid) {
        this.pilotid = pilotid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getFlighttime() {
        return flighttime;
    }

    public void setFlighttime(String flighttime) {
        this.flighttime = flighttime;
    }

    public Date getFlighttimeStamp() {
        return flighttimeStamp;
    }

    public void setFlighttimeStamp(Date flighttimeStamp) {
        this.flighttimeStamp = flighttimeStamp;
    }

    public short getDistance() {
        return distance;
    }

    public void setDistance(short distance) {
        this.distance = distance;
    }

    public float getLandingrate() {
        return landingrate;
    }

    public void setLandingrate(float landingrate) {
        this.landingrate = landingrate;
    }

    public Date getSubmitdate() {
        return submitdate;
    }

    public void setSubmitdate(Date submitdate) {
        this.submitdate = submitdate;
    }

    public short getAccepted() {
        return accepted;
    }

    public void setAccepted(short accepted) {
        this.accepted = accepted;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public float getFuelused() {
        return fuelused;
    }

    public void setFuelused(float fuelused) {
        this.fuelused = fuelused;
    }

    public float getFuelunitcost() {
        return fuelunitcost;
    }

    public void setFuelunitcost(float fuelunitcost) {
        this.fuelunitcost = fuelunitcost;
    }

    public float getFuelprice() {
        return fuelprice;
    }

    public void setFuelprice(float fuelprice) {
        this.fuelprice = fuelprice;
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

    public float getGross() {
        return gross;
    }

    public void setGross(float gross) {
        this.gross = gross;
    }

    public float getPilotpay() {
        return pilotpay;
    }

    public void setPilotpay(float pilotpay) {
        this.pilotpay = pilotpay;
    }

    public float getExpenses() {
        return expenses;
    }

    public void setExpenses(float expenses) {
        this.expenses = expenses;
    }

    public byte[] getExpenselist() {
        return expenselist;
    }

    public void setExpenselist(byte[] expenselist) {
        this.expenselist = expenselist;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public short getExported() {
        return exported;
    }

    public void setExported(short exported) {
        this.exported = exported;
    }

    public String getRawdata() {
        return rawdata;
    }

    public void setRawdata(String rawdata) {
        this.rawdata = rawdata;
    }

    @XmlTransient
    public Collection<Pirepcomments> getPirepcommentsCollection() {
        return pirepcommentsCollection;
    }

    public void setPirepcommentsCollection(Collection<Pirepcomments> pirepcommentsCollection) {
        this.pirepcommentsCollection = pirepcommentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pirepid != null ? pirepid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pireps)) {
            return false;
        }
        Pireps other = (Pireps) object;
        if ((this.pirepid == null && other.pirepid != null) || (this.pirepid != null && !this.pirepid.equals(other.pirepid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Pireps[ pirepid=" + pirepid + " ]";
    }
    
}
