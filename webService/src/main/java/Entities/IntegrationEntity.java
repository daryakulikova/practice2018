package Entities;

import javax.persistence.*;

@Entity
@Table(name = "Integration", schema = "practice", catalog = "")
public class IntegrationEntity {
    private int id;
    private Double cX3;
    private Double cX2;
    private Double cX;
    private Double c;
    private Integer numSteps;
    private Double leftLimit;
    private Double rightLimit;
    private Double answer;

    public IntegrationEntity(){}

    public IntegrationEntity(Double cX3, Double cX2, Double cX,
                             Double c, Integer numSteps, Double leftLimit,
                             Double rightLimit, Double answer){
        this.cX3=cX3;
        this.cX2=cX2;
        this.cX=cX;
        this.c=c;
        this.numSteps=numSteps;
        this.leftLimit=leftLimit;
        this.rightLimit=rightLimit;
        this.answer=answer;
    }

    public IntegrationEntity(Integer id, Double cX3, Double cX2, Double cX,
                            Double c, Integer numSteps, Double leftLimit,
                            Double rightLimit, Double answer){
        this.id=id;
        this.cX3=cX3;
        this.cX2=cX2;
        this.cX=cX;
        this.c=c;
        this.numSteps=numSteps;
        this.leftLimit=leftLimit;
        this.rightLimit=rightLimit;
        this.answer=answer;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "c_x3")
    public Double getcX3() {
        return cX3;
    }

    public void setcX3(Double cX3) {
        this.cX3 = cX3;
    }

    @Basic
    @Column(name = "c_x2")
    public Double getcX2() {
        return cX2;
    }

    public void setcX2(Double cX2) {
        this.cX2 = cX2;
    }

    @Basic
    @Column(name = "c_x")
    public Double getcX() {
        return cX;
    }

    public void setcX(Double cX) {
        this.cX = cX;
    }

    @Basic
    @Column(name = "c")
    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    @Basic
    @Column(name = "numSteps")
    public Integer getNumSteps() {
        return numSteps;
    }

    public void setNumSteps(Integer numSteps) {
        this.numSteps = numSteps;
    }

    @Basic
    @Column(name = "leftLimit")
    public Double getLeftLimit() {
        return leftLimit;
    }

    public void setLeftLimit(Double leftLimit) {
        this.leftLimit = leftLimit;
    }

    @Basic
    @Column(name = "rightLimit")
    public Double getRightLimit() {
        return rightLimit;
    }

    public void setRightLimit(Double rightLimit) {
        this.rightLimit = rightLimit;
    }

    @Basic
    @Column(name = "answer")
    public Double getAnswer() {
        return answer;
    }

    public void setAnswer(Double answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntegrationEntity that = (IntegrationEntity) o;

        if (id != that.id) return false;
        if (cX3 != null ? !cX3.equals(that.cX3) : that.cX3 != null) return false;
        if (cX2 != null ? !cX2.equals(that.cX2) : that.cX2 != null) return false;
        if (cX != null ? !cX.equals(that.cX) : that.cX != null) return false;
        if (c != null ? !c.equals(that.c) : that.c != null) return false;
        if (numSteps != null ? !numSteps.equals(that.numSteps) : that.numSteps != null) return false;
        if (leftLimit != null ? !leftLimit.equals(that.leftLimit) : that.leftLimit != null) return false;
        if (rightLimit != null ? !rightLimit.equals(that.rightLimit) : that.rightLimit != null) return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cX3 != null ? cX3.hashCode() : 0);
        result = 31 * result + (cX2 != null ? cX2.hashCode() : 0);
        result = 31 * result + (cX != null ? cX.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        result = 31 * result + (numSteps != null ? numSteps.hashCode() : 0);
        result = 31 * result + (leftLimit != null ? leftLimit.hashCode() : 0);
        result = 31 * result + (rightLimit != null ? rightLimit.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        return result;
    }
}
