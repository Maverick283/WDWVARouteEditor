/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "navdata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Navdata.findAll", query = "SELECT n FROM Navdata n"),
    @NamedQuery(name = "Navdata.findById", query = "SELECT n FROM Navdata n WHERE n.id = :id"),
    @NamedQuery(name = "Navdata.findByName", query = "SELECT n FROM Navdata n WHERE n.name = :name"),
    @NamedQuery(name = "Navdata.findByTitle", query = "SELECT n FROM Navdata n WHERE n.title = :title"),
    @NamedQuery(name = "Navdata.findByAirway", query = "SELECT n FROM Navdata n WHERE n.airway = :airway"),
    @NamedQuery(name = "Navdata.findByAirwayType", query = "SELECT n FROM Navdata n WHERE n.airwayType = :airwayType"),
    @NamedQuery(name = "Navdata.findBySeq", query = "SELECT n FROM Navdata n WHERE n.seq = :seq"),
    @NamedQuery(name = "Navdata.findByLoc", query = "SELECT n FROM Navdata n WHERE n.loc = :loc"),
    @NamedQuery(name = "Navdata.findByLat", query = "SELECT n FROM Navdata n WHERE n.lat = :lat"),
    @NamedQuery(name = "Navdata.findByLng", query = "SELECT n FROM Navdata n WHERE n.lng = :lng"),
    @NamedQuery(name = "Navdata.findByFreq", query = "SELECT n FROM Navdata n WHERE n.freq = :freq"),
    @NamedQuery(name = "Navdata.findByType", query = "SELECT n FROM Navdata n WHERE n.type = :type")})
public class Navdata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "airway")
    private String airway;
    @Column(name = "airway_type")
    private String airwayType;
    @Basic(optional = false)
    @Column(name = "seq")
    private int seq;
    @Basic(optional = false)
    @Column(name = "loc")
    private String loc;
    @Basic(optional = false)
    @Column(name = "lat")
    private float lat;
    @Basic(optional = false)
    @Column(name = "lng")
    private float lng;
    @Basic(optional = false)
    @Column(name = "freq")
    private String freq;
    @Basic(optional = false)
    @Column(name = "type")
    private int type;

    public Navdata() {
    }

    public Navdata(Integer id) {
        this.id = id;
    }

    public Navdata(Integer id, String name, String title, int seq, String loc, float lat, float lng, String freq, int type) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.seq = seq;
        this.loc = loc;
        this.lat = lat;
        this.lng = lng;
        this.freq = freq;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAirway() {
        return airway;
    }

    public void setAirway(String airway) {
        this.airway = airway;
    }

    public String getAirwayType() {
        return airwayType;
    }

    public void setAirwayType(String airwayType) {
        this.airwayType = airwayType;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
        if (!(object instanceof Navdata)) {
            return false;
        }
        Navdata other = (Navdata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Navdata[ id=" + id + " ]";
    }
    
}
