package com.brynckmanthys.bean;

import java.util.ArrayList;

public class NPVBean {
    private float initialInvestment;
    private int numberOfPeriod;
    private float npvValue;

    public NPVBean() {
    }

    public String getInitialInvestment() {
        return Float.toString(initialInvestment);
    }

    public void setInitialInvestment(final String initialInvestment) {
        this.initialInvestment = Float.parseFloat(initialInvestment);
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
}