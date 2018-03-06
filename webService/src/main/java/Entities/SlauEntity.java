package Entities;

import javax.persistence.*;

@Entity
@Table(name = "slau", schema = "practice")
public class SlauEntity {
    private int id;
    private Integer sizeSlau;
    private String equations;
    private String answer;

    public SlauEntity(){}

    public SlauEntity(Integer id, Integer sizeSlau, String equations, String answer) {
        this.id = id;
        this.sizeSlau = sizeSlau;
        this.equations = equations;
        this.answer = answer;
    }
    public SlauEntity(Integer sizeSlau, String equations, String answer) {
        this.sizeSlau = sizeSlau;
        this.equations = equations;
        this.answer = answer;
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
    @Column(name = "sizeSlau")
    public Integer getSizeSlau() {
        return sizeSlau;
    }

    public void setSizeSlau(Integer sizeSlau) {
        this.sizeSlau = sizeSlau;
    }

    @Basic
    @Column(name = "equations")
    public String getEquations() {
        return equations;
    }

    public void setEquations(String equations) {
        this.equations = equations;
    }

    @Basic
    @Column(name = "answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SlauEntity that = (SlauEntity) o;

        if (id != that.id) return false;
        if (sizeSlau != null ? !sizeSlau.equals(that.sizeSlau) : that.sizeSlau != null) return false;
        if (equations != null ? !equations.equals(that.equations) : that.equations != null) return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sizeSlau != null ? sizeSlau.hashCode() : 0);
        result = 31 * result + (equations != null ? equations.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        return result;
    }
}
