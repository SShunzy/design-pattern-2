package com.brynckmanthys.bean;

import java.util.ArrayList;

public class NPVBean {
    private float initialInvestment;
    private int numberOfPeriod;
    private float discountRate;
    private float npvValue;
    private float[] cashFlowValues;

    public NPVBean() {
        initialInvestment = 0;
        numberOfPeriod = 0;
        discountRate = 0;
        npvValue = 0;
        cashFlowValues = null;

    }

    public String getInitialInvestment() {
        return Float.toString(initialInvestment);
    }

    public void setInitialInvestment(final String initialInvestment) {
        this.initialInvestment = Float.parseFloat(initialInvestment);
    }

    public String getDiscountRate(){
        return Float.toString(discountRate);
    }

    public void setDiscountRate(final String discountRate){
        this.discountRate = Float.parseFloat(discountRate);
    }

    public String getNumberOfPeriod() {
        return Integer.toString(numberOfPeriod);
    }

    public void setNumberOfPeriod(final String numberOfPeriod) {
        this.numberOfPeriod = Integer.parseInt(numberOfPeriod);
    }

    public String getNpvValue() {
        return Float.toString(npvValue);
    }

    public void setNpvValue(final String npvValue) {
        this.npvValue = Float.parseFloat(npvValue);
    }

    public float[] getCashFlowValues() {
        return cashFlowValues;
    }

    public void calculateNPV(){
        float tempNPV = - initialInvestment;
        for(int i = 0; i < numberOfPeriod; i++){
            tempNPV += cashFlowValues[i] / Math.pow(1 + discountRate, i+1);
        }
        this.npvValue = tempNPV;
    }

    public void setCashFlowValues(float[] cashFlowValues) {
        this.cashFlowValues = cashFlowValues;
    }
}