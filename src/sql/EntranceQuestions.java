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
@Table(name = "entrance_questions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntranceQuestions.findAll", query = "SELECT e FROM EntranceQuestions e"),
    @NamedQuery(name = "EntranceQuestions.findById", query = "SELECT e FROM EntranceQuestions e WHERE e.id = :id"),
    @NamedQuery(name = "EntranceQuestions.findByCorrectAnswer", query = "SELECT e FROM EntranceQuestions e WHERE e.correctAnswer = :correctAnswer"),
    @NamedQuery(name = "EntranceQuestions.findByActive", query = "SELECT e FROM EntranceQuestions e WHERE e.active = :active")})
public class EntranceQuestions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "question")
    private String question;
    @Basic(optional = false)
    @Lob
    @Column(name = "answer_1")
    private String answer1;
    @Basic(optional = false)
    @Lob
    @Column(name = "answer_2")
    private String answer2;
    @Basic(optional = false)
    @Lob
    @Column(name = "answer_3")
    private String answer3;
    @Basic(optional = false)
    @Lob
    @Column(name = "answer_4")
    private String answer4;
    @Basic(optional = false)
    @Column(name = "correct_answer")
    private int correctAnswer;
    @Basic(optional = false)
    @Column(name = "active")
    private int active;

    public EntranceQuestions() {
    }

    public EntranceQuestions(Integer id) {
        this.id = id;
    }

    public EntranceQuestions(Integer id, String question, String answer1, String answer2, String answer3, String answer4, int correctAnswer, int active) {
        this.id = id;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
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
        if (!(object instanceof EntranceQuestions)) {
            return false;
        }
        EntranceQuestions other = (EntranceQuestions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.EntranceQuestions[ id=" + id + " ]";
    }
    
}
