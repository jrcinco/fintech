package com.school.automation.payload;

import java.util.List;

/**
 * @author jhonny
 */
public class LoanPeriodPayload implements java.io.Serializable {

    private Long loanAmountMin;
    private Long loanAmountMax;
    private Long loanInterest;
    private List<PeriodPayload> periods;

    public LoanPeriodPayload() {
    }

    public LoanPeriodPayload(Long loanAmountMin, Long loanAmountMax, Long loanInterest, List<PeriodPayload> periods) {
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

    public List<PeriodPayload> getPeriods() {
        return this.periods;
    }
    
    public void setPeriods(List<PeriodPayload> periods) {
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

    public static class PeriodPayload {

        private Integer periodMin;
        private Integer periodMax;
        private String interestRate;

        public PeriodPayload() {
        }

        public PeriodPayload(Integer periodMin, Integer periodMax, String interestRate) {
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
            return "PeriodPayload{" +
                    "periodMin=" + periodMin +
                    ", periodMax=" + periodMax +
                    ", interestRate='" + interestRate + '\'' +
                    '}';
        }
    }
}