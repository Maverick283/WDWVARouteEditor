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
@Table(name = "ranks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ranks.findAll", query = "SELECT r FROM Ranks r"),
    @NamedQuery(name = "Ranks.findByRankid", query = "SELECT r FROM Ranks r WHERE r.rankid = :rankid"),
    @NamedQuery(name = "Ranks.findByRank", query = "SELECT r FROM Ranks r WHERE r.rank = :rank"),
    @NamedQuery(name = "Ranks.findByMinhours", query = "SELECT r FROM Ranks r WHERE r.minhours = :minhours"),
    @NamedQuery(name = "Ranks.findByPayrate", query = "SELECT r FROM Ranks r WHERE r.payrate = :payrate")})
public class Ranks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rankid")
    private Integer rankid;
    @Basic(optional = false)
    @Column(name = "rank")
    private String rank;
    @Basic(optional = false)
    @Lob
    @Column(name = "rankimage")
    private String rankimage;
    @Basic(optional = false)
    @Column(name = "minhours")
    private short minhours;
    @Basic(optional = false)
    @Column(name = "payrate")
    private float payrate;

    public Ranks() {
    }

    public Ranks(Integer rankid) {
        this.rankid = rankid;
    }

    public Ranks(Integer rankid, String rank, String rankimage, short minhours, float payrate) {
        this.rankid = rankid;
        this.rank = rank;
        this.rankimage = rankimage;
        this.minhours = minhours;
        this.payrate = payrate;
    }

    public Integer getRankid() {
        return rankid;
    }

    public void setRankid(Integer rankid) {
        this.rankid = rankid;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRankimage() {
        return rankimage;
    }

    public void setRankimage(String rankimage) {
        this.rankimage = rankimage;
    }

    public short getMinhours() {
        return minhours;
    }

    public void setMinhours(short minhours) {
        this.minhours = minhours;
    }

    public float getPayrate() {
        return payrate;
    }

    public void setPayrate(float payrate) {
        this.payrate = payrate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rankid != null ? rankid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ranks)) {
            return false;
        }
        Ranks other = (Ranks) object;
        if ((this.rankid == null && other.rankid != null) || (this.rankid != null && !this.rankid.equals(other.rankid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Ranks[ rankid=" + rankid + " ]";
    }
    
}
