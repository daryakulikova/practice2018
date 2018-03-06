package Entities;

import javax.persistence.*;

@Entity
@Table(name = "calculator", schema = "practice", catalog = "")
public class CalculatorEntity {
    private int id;
    private Double firstOperand;
    private Double secondOperand;
    private String operation;
    private Double answer;

    public CalculatorEntity(){}

    public CalculatorEntity(Double firstOperand,
                            Double secondOperand, String operation, Double answer){
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
        this.answer=answer;
    }
    public CalculatorEntity(Integer id, Double firstOperand,
                            Double secondOperand, String operation, Double answer){
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
        this.answer=answer;
        this.id = id;
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
    @Column(name = "firstOperand")
    public Double getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(Double firstOperand) {
        this.firstOperand = firstOperand;
    }

    @Basic
    @Column(name = "secondOperand")
    public Double getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(Double secondOperand) {
        this.secondOperand = secondOperand;
    }

    @Basic
    @Column(name = "operation")
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalculatorEntity that = (CalculatorEntity) o;

        if (id != that.id) return false;
        if (firstOperand != null ? !firstOperand.equals(that.firstOperand) : that.firstOperand != null) return false;
        if (secondOperand != null ? !secondOperand.equals(that.secondOperand) : that.secondOperand != null)
            return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstOperand != null ? firstOperand.hashCode() : 0);
        result = 31 * result + (secondOperand != null ? secondOperand.hashCode() : 0);
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "answer")
    public Double getAnswer() {
        return answer;
    }

    public void setAnswer(Double answer) {
        this.answer = answer;
    }
}
