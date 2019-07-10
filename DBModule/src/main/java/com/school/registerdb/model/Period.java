package com.school.registerdb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author jhonny
 */
@Entity
@Table(name="period"
    ,catalog="register_db"
)
public class Period  implements java.io.Serializable {

     private Long id;
     private Loan loan;
     private Integer periodMin;
     private Integer periodMax;
     private String interestRate;

    public Period() {
    }

    public Period(Long id, Loan loan) {
        this.id = id;
        this.loan = loan;
    }

    public Period(Long id, Loan loan, Integer periodMin, Integer periodMax, String interestRate) {
       this.id = id;
       this.loan = loan;
       this.periodMin = periodMin;
       this.periodMax = periodMax;
       this.interestRate = interestRate;
    }

    public Period(Loan loan, Integer periodMin, Integer periodMax, String interestRate) {
        this.loan = loan;
        this.periodMin = periodMin;
        this.periodMax = periodMax;
        this.interestRate = interestRate;
    }
   
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="loan_id", nullable=false)
    public Loan getLoan() {
        return this.loan;
    }
    
    public void setLoan(Loan loan) {
        this.loan = loan;
    }
    
    @Column(name="period_min")
    public Integer getPeriodMin() {
        return this.periodMin;
    }
    
    public void setPeriodMin(Integer periodMin) {
        this.periodMin = periodMin;
    }
    
    @Column(name="period_max")
    public Integer getPeriodMax() {
        return this.periodMax;
    }
    
    public void setPeriodMax(Integer periodMax) {
        this.periodMax = periodMax;
    }
    
    @Column(name="interest_rate", length=45)
    public String getInterestRate() {
        return this.interestRate;
    }
    
    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Period{" +
                "id=" + id +
                ", loan=" + loan +
                ", periodMin=" + periodMin +
                ", periodMax=" + periodMax +
                ", interestRate='" + interestRate + '\'' +
                '}';
    }
}