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
@Table(name = "screenshots_comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScreenshotsComments.findAll", query = "SELECT s FROM ScreenshotsComments s"),
    @NamedQuery(name = "ScreenshotsComments.findById", query = "SELECT s FROM ScreenshotsComments s WHERE s.id = :id"),
    @NamedQuery(name = "ScreenshotsComments.findByPilotId", query = "SELECT s FROM ScreenshotsComments s WHERE s.pilotId = :pilotId"),
    @NamedQuery(name = "ScreenshotsComments.findBySsId", query = "SELECT s FROM ScreenshotsComments s WHERE s.ssId = :ssId"),
    @NamedQuery(name = "ScreenshotsComments.findByComment", query = "SELECT s FROM ScreenshotsComments s WHERE s.comment = :comment")})
public class ScreenshotsComments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "pilot_id")
    private int pilotId;
    @Basic(optional = false)
    @Column(name = "ss_id")
    private int ssId;
    @Basic(optional = false)
    @Column(name = "comment")
    private String comment;

    public ScreenshotsComments() {
    }

    public ScreenshotsComments(Integer id) {
        this.id = id;
    }

    public ScreenshotsComments(Integer id, int pilotId, int ssId, String comment) {
        this.id = id;
        this.pilotId = pilotId;
        this.ssId = ssId;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    public int getSsId() {
        return ssId;
    }

    public void setSsId(int ssId) {
        this.ssId = ssId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        if (!(object instanceof ScreenshotsComments)) {
            return false;
        }
        ScreenshotsComments other = (ScreenshotsComments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.ScreenshotsComments[ id=" + id + " ]";
    }
    
}
