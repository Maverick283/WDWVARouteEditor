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
@Table(name = "screenshots")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Screenshots.findAll", query = "SELECT s FROM Screenshots s"),
    @NamedQuery(name = "Screenshots.findById", query = "SELECT s FROM Screenshots s WHERE s.id = :id"),
    @NamedQuery(name = "Screenshots.findByFileName", query = "SELECT s FROM Screenshots s WHERE s.fileName = :fileName"),
    @NamedQuery(name = "Screenshots.findByFileDescription", query = "SELECT s FROM Screenshots s WHERE s.fileDescription = :fileDescription"),
    @NamedQuery(name = "Screenshots.findByPilotId", query = "SELECT s FROM Screenshots s WHERE s.pilotId = :pilotId"),
    @NamedQuery(name = "Screenshots.findByDateUploaded", query = "SELECT s FROM Screenshots s WHERE s.dateUploaded = :dateUploaded"),
    @NamedQuery(name = "Screenshots.findByFileApproved", query = "SELECT s FROM Screenshots s WHERE s.fileApproved = :fileApproved"),
    @NamedQuery(name = "Screenshots.findByViews", query = "SELECT s FROM Screenshots s WHERE s.views = :views"),
    @NamedQuery(name = "Screenshots.findByRating", query = "SELECT s FROM Screenshots s WHERE s.rating = :rating")})
public class Screenshots implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "file_name")
    private String fileName;
    @Basic(optional = false)
    @Column(name = "file_description")
    private String fileDescription;
    @Basic(optional = false)
    @Column(name = "pilot_id")
    private int pilotId;
    @Basic(optional = false)
    @Column(name = "date_uploaded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUploaded;
    @Basic(optional = false)
    @Column(name = "file_approved")
    private int fileApproved;
    @Basic(optional = false)
    @Column(name = "views")
    private int views;
    @Basic(optional = false)
    @Column(name = "rating")
    private int rating;

    public Screenshots() {
    }

    public Screenshots(Integer id) {
        this.id = id;
    }

    public Screenshots(Integer id, String fileName, String fileDescription, int pilotId, Date dateUploaded, int fileApproved, int views, int rating) {
        this.id = id;
        this.fileName = fileName;
        this.fileDescription = fileDescription;
        this.pilotId = pilotId;
        this.dateUploaded = dateUploaded;
        this.fileApproved = fileApproved;
        this.views = views;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    public Date getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(Date dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public int getFileApproved() {
        return fileApproved;
    }

    public void setFileApproved(int fileApproved) {
        this.fileApproved = fileApproved;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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
        if (!(object instanceof Screenshots)) {
            return false;
        }
        Screenshots other = (Screenshots) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Screenshots[ id=" + id + " ]";
    }
    
}
