package com.school.web.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jhonny
 */
public class LoanPeriodDto implements java.io.Serializable {

    private Long loanAmountMin;
    private Long loanAmountMax;
    private Long loanInterest;
    private List<PeriodDto> periods;

    public LoanPeriodDto() {
    }

    public LoanPeriodDto(Long loanAmountMin, Long loanAmountMax, Long loanInterest, List<PeriodDto> periods) {
        this.loanAmountMin = loanAmountMin;
        this.loanAmountMax = loanAmountMax;
        this.loanInterest = loanInterest;
        this.periods = periods;
    }

    public Long getLoanAmountMin() {
        return this.loanAmountMin;
    }
    
    public void setLoanAmountMin(Long loanAmountMin) {
        this.loanAmountMin = loanAmountMin;
    }

    public Long getLoanAmountMax() {
        return this.loanAmountMax;
    }
    
    public void setLoanAmountMax(Long loanAmountMax) {
        this.loanAmountMax = loanAmountMax;
    }

    public Long getLoanInterest() {
        return this.loanInterest;
    }
    
    public void setLoanInterest(Long loanInterest) {
        this.loanInterest = loanInterest;
    }

    public List<PeriodDto> getPeriods() {
        return this.periods;
    }
    
    public void setPeriods(List<PeriodDto> periods) {
        this.periods = periods;
    }

    @Override
    public String toString() {
        return "Loan{" +
                ", loanAmountMin=" + loanAmountMin +
                ", loanAmountMax=" + loanAmountMax +
                ", loanInterest=" + loanInterest +
                '}';
    }

    public static class PeriodDto {

        private Integer periodMin;
        private Integer periodMax;
        private String interestRate;

        public PeriodDto() {
        }

        public PeriodDto(Integer periodMin, Integer periodMax, String interestRate) {
            this.periodMin = periodMin;
            this.periodMax = periodMax;
            this.interestRate = interestRate;
        }

        public Integer getPeriodMin() {
            return periodMin;
        }

        public void setPeriodMin(Integer periodMin) {
            this.periodMin = periodMin;
        }

        public Integer getPeriodMax() {
            return periodMax;
        }

        public void setPeriodMax(Integer periodMax) {
            this.periodMax = periodMax;
        }

        public String getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(String interestRate) {
            this.interestRate = interestRate;
        }

        @Override
        public String toString() {
            return "PeriodDto{" +
                    "periodMin=" + periodMin +
                    ", periodMax=" + periodMax +
                    ", interestRate='" + interestRate + '\'' +
                    '}';
        }
    }
}