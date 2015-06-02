/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "acarsdata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acarsdata.findAll", query = "SELECT a FROM Acarsdata a"),
    @NamedQuery(name = "Acarsdata.findById", query = "SELECT a FROM Acarsdata a WHERE a.id = :id"),
    @NamedQuery(name = "Acarsdata.findByPilotid", query = "SELECT a FROM Acarsdata a WHERE a.pilotid = :pilotid"),
    @NamedQuery(name = "Acarsdata.findByFlightnum", query = "SELECT a FROM Acarsdata a WHERE a.flightnum = :flightnum"),
    @NamedQuery(name = "Acarsdata.findByPilotname", query = "SELECT a FROM Acarsdata a WHERE a.pilotname = :pilotname"),
    @NamedQuery(name = "Acarsdata.findByAircraft", query = "SELECT a FROM Acarsdata a WHERE a.aircraft = :aircraft"),
    @NamedQuery(name = "Acarsdata.findByLat", query = "SELECT a FROM Acarsdata a WHERE a.lat = :lat"),
    @NamedQuery(name = "Acarsdata.findByLng", query = "SELECT a FROM Acarsdata a WHERE a.lng = :lng"),
    @NamedQuery(name = "Acarsdata.findByHeading", query = "SELECT a FROM Acarsdata a WHERE a.heading = :heading"),
    @NamedQuery(name = "Acarsdata.findByAlt", query = "SELECT a FROM Acarsdata a WHERE a.alt = :alt"),
    @NamedQuery(name = "Acarsdata.findByGs", query = "SELECT a FROM Acarsdata a WHERE a.gs = :gs"),
    @NamedQuery(name = "Acarsdata.findByDepicao", query = "SELECT a FROM Acarsdata a WHERE a.depicao = :depicao"),
    @NamedQuery(name = "Acarsdata.findByDepapt", query = "SELECT a FROM Acarsdata a WHERE a.depapt = :depapt"),
    @NamedQuery(name = "Acarsdata.findByArricao", query = "SELECT a FROM Acarsdata a WHERE a.arricao = :arricao"),
    @NamedQuery(name = "Acarsdata.findByDeptime", query = "SELECT a FROM Acarsdata a WHERE a.deptime = :deptime"),
    @NamedQuery(name = "Acarsdata.findByTimeremaining", query = "SELECT a FROM Acarsdata a WHERE a.timeremaining = :timeremaining"),
    @NamedQuery(name = "Acarsdata.findByArrtime", query = "SELECT a FROM Acarsdata a WHERE a.arrtime = :arrtime"),
    @NamedQuery(name = "Acarsdata.findByDistremain", query = "SELECT a FROM Acarsdata a WHERE a.distremain = :distremain"),
    @NamedQuery(name = "Acarsdata.findByPhasedetail", query = "SELECT a FROM Acarsdata a WHERE a.phasedetail = :phasedetail"),
    @NamedQuery(name = "Acarsdata.findByOnline", query = "SELECT a FROM Acarsdata a WHERE a.online = :online"),
    @NamedQuery(name = "Acarsdata.findByLastupdate", query = "SELECT a FROM Acarsdata a WHERE a.lastupdate = :lastupdate"),
    @NamedQuery(name = "Acarsdata.findByClient", query = "SELECT a FROM Acarsdata a WHERE a.client = :client")})
public class Acarsdata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "pilotid")
    private String pilotid;
    @Basic(optional = false)
    @Column(name = "flightnum")
    private String flightnum;
    @Basic(optional = false)
    @Column(name = "pilotname")
    private String pilotname;
    @Basic(optional = false)
    @Column(name = "aircraft")
    private String aircraft;
    @Basic(optional = false)
    @Column(name = "lat")
    private String lat;
    @Basic(optional = false)
    @Column(name = "lng")
    private String lng;
    @Basic(optional = false)
    @Column(name = "heading")
    private short heading;
    @Basic(optional = false)
    @Column(name = "alt")
    private String alt;
    @Basic(optional = false)
    @Column(name = "gs")
    private int gs;
    @Basic(optional = false)
    @Column(name = "depicao")
    private String depicao;
    @Basic(optional = false)
    @Column(name = "depapt")
    private String depapt;
    @Basic(optional = false)
    @Column(name = "arricao")
    private String arricao;
    @Basic(optional = false)
    @Lob
    @Column(name = "arrapt")
    private String arrapt;
    @Basic(optional = false)
    @Column(name = "deptime")
    @Temporal(TemporalType.TIME)
    private Date deptime;
    @Basic(optional = false)
    @Column(name = "timeremaining")
    private String timeremaining;
    @Basic(optional = false)
    @Column(name = "arrtime")
    @Temporal(TemporalType.TIME)
    private Date arrtime;
    @Basic(optional = false)
    @Lob
    @Column(name = "route")
    private String route;
    @Basic(optional = false)
    @Lob
    @Column(name = "route_details")
    private String routeDetails;
    @Basic(optional = false)
    @Column(name = "distremain")
    private String distremain;
    @Basic(optional = false)
    @Column(name = "phasedetail")
    private String phasedetail;
    @Basic(optional = false)
    @Column(name = "online")
    private String online;
    @Basic(optional = false)
    @Lob
    @Column(name = "messagelog")
    private String messagelog;
    @Basic(optional = false)
    @Column(name = "lastupdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdate;
    @Basic(optional = false)
    @Column(name = "client")
    private String client;

    public Acarsdata() {
    }

    public Acarsdata(Integer id) {
        this.id = id;
    }

    public Acarsdata(Integer id, String pilotid, String flightnum, String pilotname, String aircraft, String lat, String lng, short heading, String alt, int gs, String depicao, String depapt, String arricao, String arrapt, Date deptime, String timeremaining, Date arrtime, String route, String routeDetails, String distremain, String phasedetail, String online, String messagelog, Date lastupdate, String client) {
        this.id = id;
        this.pilotid = pilotid;
        this.flightnum = flightnum;
        this.pilotname = pilotname;
        this.aircraft = aircraft;
        this.lat = lat;
        this.lng = lng;
        this.heading = heading;
        this.alt = alt;
        this.gs = gs;
        this.depicao = depicao;
        this.depapt = depapt;
        this.arricao = arricao;
        this.arrapt = arrapt;
        this.deptime = deptime;
        this.timeremaining = timeremaining;
        this.arrtime = arrtime;
        this.route = route;
        this.routeDetails = routeDetails;
        this.distremain = distremain;
        this.phasedetail = phasedetail;
        this.online = online;
        this.messagelog = messagelog;
        this.lastupdate = lastupdate;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPilotid() {
        return pilotid;
    }

    public void setPilotid(String pilotid) {
        this.pilotid = pilotid;
    }

    public String getFlightnum() {
        return flightnum;
    }

    public void setFlightnum(String flightnum) {
        this.flightnum = flightnum;
    }

    public String getPilotname() {
        return pilotname;
    }

    public void setPilotname(String pilotname) {
        this.pilotname = pilotname;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public short getHeading() {
        return heading;
    }

    public void setHeading(short heading) {
        this.heading = heading;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public int getGs() {
        return gs;
    }

    public void setGs(int gs) {
        this.gs = gs;
    }

    public String getDepicao() {
        return depicao;
    }

    public void setDepicao(String depicao) {
        this.depicao = depicao;
    }

    public String getDepapt() {
        return depapt;
    }

    public void setDepapt(String depapt) {
        this.depapt = depapt;
    }

    public String getArricao() {
        return arricao;
    }

    public void setArricao(String arricao) {
        this.arricao = arricao;
    }

    public String getArrapt() {
        return arrapt;
    }

    public void setArrapt(String arrapt) {
        this.arrapt = arrapt;
    }

    public Date getDeptime() {
        return deptime;
    }

    public void setDeptime(Date deptime) {
        this.deptime = deptime;
    }

    public String getTimeremaining() {
        return timeremaining;
    }

    public void setTimeremaining(String timeremaining) {
        this.timeremaining = timeremaining;
    }

    public Date getArrtime() {
        return arrtime;
    }

    public void setArrtime(Date arrtime) {
        this.arrtime = arrtime;
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

    public String getDistremain() {
        return distremain;
    }

    public void setDistremain(String distremain) {
        this.distremain = distremain;
    }

    public String getPhasedetail() {
        return phasedetail;
    }

    public void setPhasedetail(String phasedetail) {
        this.phasedetail = phasedetail;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getMessagelog() {
        return messagelog;
    }

    public void setMessagelog(String messagelog) {
        this.messagelog = messagelog;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
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
        if (!(object instanceof Acarsdata)) {
            return false;
        }
        Acarsdata other = (Acarsdata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Acarsdata[ id=" + id + " ]";
    }
    
}
