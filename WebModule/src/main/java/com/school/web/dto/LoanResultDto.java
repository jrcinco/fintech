package com.school.web.dto;

public class LoanResultDto {
    private Double emi;
    private Double interest;

    public LoanResultDto() {}

    public LoanResultDto(Double emi, Double interest) {
        this.emi = emi;
        this.interest = interest;
    }

    public Double getEmi() {
        return emi;
    }

    public void setEmi(Double emi) {
        this.emi = emi;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "LoanResultDto{" +
                "emi=" + emi +
                ", interest=" + interest +
                '}';
    }
}
