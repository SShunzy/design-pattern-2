package com.brynckmanthys.bean;

import com.brynckmanthys.interfaces.IProject;
import com.brynckmanthys.interfaces.IRRAlgorithm;
import com.brynckmanthys.strategy.IRREcheanceMoyenneAlgorithm;
import com.brynckmanthys.visitor.FileVisitor;

public class NPVBean implements IProject {
    private String projectTitle;
    private float initialInvestment;
    private int numberOfPeriod;
    private float discountRate;
    private float npvValue;
    private float[] cashFlowValues;

    private IRRAlgorithm irrStrategy;

    public NPVBean() {
        projectTitle = "New project";
        initialInvestment = 0;
        numberOfPeriod = 0;
        discountRate = 0;
        npvValue = 0;
        cashFlowValues = null;
        irrStrategy = new IRREcheanceMoyenneAlgorithm();
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

    public void setNumberOfPeriod(int numberOfPeriod) {
        this.numberOfPeriod = numberOfPeriod;
    }

    public void setIrrStrategy(IRRAlgorithm irrStrategy) {
        this.irrStrategy = irrStrategy;
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
            System.out.println("tempNPV = "+ tempNPV);
            tempNPV += cashFlowValues[i] / Math.pow(1 + discountRate, i+1);
        }
        System.out.println("finalNPV = "+tempNPV);
        this.npvValue = tempNPV;
    }

    public double calculateIRR(){
        return irrStrategy.calculateIRR(this);
    }

    public void setCashFlowValues(float[] cashFlowValues) {
        this.cashFlowValues = cashFlowValues;
    }

    @Override
    public Boolean accept(FileVisitor visitor, String path) {
        return visitor.visitNPVBean(this, path);
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }
}