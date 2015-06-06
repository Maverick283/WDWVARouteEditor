/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.io.Serializable;
import javafx.scene.image.Image;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "aircraft")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aircraft.findAll", query = "SELECT a FROM Aircraft a"),
    @NamedQuery(name = "Aircraft.findById", query = "SELECT a FROM Aircraft a WHERE a.id = :id"),
    @NamedQuery(name = "Aircraft.findByIcao", query = "SELECT a FROM Aircraft a WHERE a.icao = :icao"),
    @NamedQuery(name = "Aircraft.findByName", query = "SELECT a FROM Aircraft a WHERE a.name = :name"),
    @NamedQuery(name = "Aircraft.findByFullname", query = "SELECT a FROM Aircraft a WHERE a.fullname = :fullname"),
    @NamedQuery(name = "Aircraft.findByRegistration", query = "SELECT a FROM Aircraft a WHERE a.registration = :registration"),
    @NamedQuery(name = "Aircraft.findByRange", query = "SELECT a FROM Aircraft a WHERE a.range = :range"),
    @NamedQuery(name = "Aircraft.findByWeight", query = "SELECT a FROM Aircraft a WHERE a.weight = :weight"),
    @NamedQuery(name = "Aircraft.findByCruise", query = "SELECT a FROM Aircraft a WHERE a.cruise = :cruise"),
    @NamedQuery(name = "Aircraft.findByMaxpax", query = "SELECT a FROM Aircraft a WHERE a.maxpax = :maxpax"),
    @NamedQuery(name = "Aircraft.findByMaxcargo", query = "SELECT a FROM Aircraft a WHERE a.maxcargo = :maxcargo"),
    @NamedQuery(name = "Aircraft.findByMinrank", query = "SELECT a FROM Aircraft a WHERE a.minrank = :minrank"),
    @NamedQuery(name = "Aircraft.findByRanklevel", query = "SELECT a FROM Aircraft a WHERE a.ranklevel = :ranklevel"),
    @NamedQuery(name = "Aircraft.findByEnabled", query = "SELECT a FROM Aircraft a WHERE a.enabled = :enabled")})
public class Aircraft implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "icao")
    private String icao;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "fullname")
    private String fullname;
    @Basic(optional = false)
    @Column(name = "registration")
    private String registration;
    @Basic(optional = false)
    @Lob
    @Column(name = "downloadlink")
    private String downloadlink;
    @Basic(optional = false)
    @Lob
    @Column(name = "imagelink")
    private String imagelink;
    @Basic(optional = false)
    @Column(name = "range")
    private String range;
    @Basic(optional = false)
    @Column(name = "weight")
    private String weight;
    @Basic(optional = false)
    @Column(name = "cruise")
    private String cruise;
    @Basic(optional = false)
    @Column(name = "maxpax")
    private float maxpax;
    @Basic(optional = false)
    @Column(name = "maxcargo")
    private float maxcargo;
    @Basic(optional = false)
    @Column(name = "minrank")
    private int minrank;
    @Basic(optional = false)
    @Column(name = "ranklevel")
    private int ranklevel;
    @Basic(optional = false)
    @Column(name = "enabled")
    private short enabled;
    private Image thumbnail;

    public Aircraft() {
    }

    public Aircraft(Integer id) {
        this.id = id;
    }

    public Aircraft(Integer id, String range) {
        this.id = id;
        this.range = range;
    }

    public Aircraft(Integer id, String range, String name) {
        this.id = id;
        this.range = range;
        this.name = name;
    }

    public Aircraft(Integer id, String icao, String name, String fullname, String registration, String downloadlink, String imagelink, String range, String weight, String cruise, float maxpax, float maxcargo, int minrank, int ranklevel, short enabled) {
        this.id = id;
        this.icao = icao;
        this.name = name;
        this.fullname = fullname;
        this.registration = registration;
        this.downloadlink = downloadlink;
        this.imagelink = imagelink;
        this.range = range;
        this.weight = weight;
        this.cruise = cruise;
        this.maxpax = maxpax;
        this.maxcargo = maxcargo;
        this.minrank = minrank;
        this.ranklevel = ranklevel;
        this.enabled = enabled;
        /*  creates a new picture for each aircraft... This as it is now takes a lot of time...
         try{
            
         this.thumbnail = new Image(imagelink);
         }
         catch(Exception e){
         e.printStackTrace(System.err);
         }*/
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getDownloadlink() {
        return downloadlink;
    }

    public void setDownloadlink(String downloadlink) {
        this.downloadlink = downloadlink;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCruise() {
        return cruise;
    }

    public void setCruise(String cruise) {
        this.cruise = cruise;
    }

    public float getMaxpax() {
        return maxpax;
    }

    public void setMaxpax(float maxpax) {
        this.maxpax = maxpax;
    }

    public float getMaxcargo() {
        return maxcargo;
    }

    public void setMaxcargo(float maxcargo) {
        this.maxcargo = maxcargo;
    }

    public int getMinrank() {
        return minrank;
    }

    public void setMinrank(int minrank) {
        this.minrank = minrank;
    }

    public int getRanklevel() {
        return ranklevel;
    }

    public void setRanklevel(int ranklevel) {
        this.ranklevel = ranklevel;
    }

    public short getEnabled() {
        return enabled;
    }

    public void setEnabled(short enabled) {
        this.enabled = enabled;
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
        if (!(object instanceof Aircraft)) {
            return false;
        }
        Aircraft other = (Aircraft) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Aircraft[ id=" + id + " ]";
    }

    public Object icaoLabel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Image getImage() {
        return thumbnail;
    }

}
