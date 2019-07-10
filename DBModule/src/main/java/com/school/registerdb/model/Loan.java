package com.school.registerdb.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author jhonny
 */
@Entity
@Table(name="loan"
    ,catalog="register_db"
)
public class Loan implements java.io.Serializable {

     private Long id;
     private Long loanAmountMin;
     private Long loanAmountMax;
     private Long loanInterest;
     private Set<Period> periods = new HashSet<Period>(0);

    public Loan() {
    }

    public Loan(Long id) {
        this.id = id;
    }

    public Loan(Long id, Long loanAmountMin, Long loanAmountMax, Long loanInterest, Set<Period> periods) {
       this.id = id;
       this.loanAmountMin = loanAmountMin;
       this.loanAmountMax = loanAmountMax;
       this.loanInterest = loanInterest;
       this.periods = periods;
    }

    public Loan(Long loanAmountMin, Long loanAmountMax, Long loanInterest, Set<Period> periods) {
        this.loanAmountMin = loanAmountMin;
        this.loanAmountMax = loanAmountMax;
        this.loanInterest = loanInterest;
        this.periods = periods;
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
    
    @Column(name="loan_amount_min", precision=10, scale=0)
    public Long getLoanAmountMin() {
        return this.loanAmountMin;
    }
    
    public void setLoanAmountMin(Long loanAmountMin) {
        this.loanAmountMin = loanAmountMin;
    }
    
    @Column(name="loan_amount_max", precision=10, scale=0)
    public Long getLoanAmountMax() {
        return this.loanAmountMax;
    }
    
    public void setLoanAmountMax(Long loanAmountMax) {
        this.loanAmountMax = loanAmountMax;
    }
    
    @Column(name="loan_interest", precision=10, scale=0)
    public Long getLoanInterest() {
        return this.loanInterest;
    }
    
    public void setLoanInterest(Long loanInterest) {
        this.loanInterest = loanInterest;
    }

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="loan")
    public Set<Period> getPeriods() {
        return this.periods;
    }
    
    public void setPeriods(Set<Period> periods) {
        this.periods = periods;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanAmountMin=" + loanAmountMin +
                ", loanAmountMax=" + loanAmountMax +
                ", loanInterest=" + loanInterest +
                '}';
    }
}