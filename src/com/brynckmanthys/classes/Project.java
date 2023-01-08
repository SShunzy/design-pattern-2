package com.brynckmanthys.classes;

import com.brynckmanthys.utils.file.FileVisitor;

import java.util.ArrayList;

public class Project implements IProject {
    private String projectName;
    private float initialInvestment;
    private ArrayList<Float> cashFlowValues;

    public Project() {
        this.projectName = "";
        this.initialInvestment = 0;
        this.cashFlowValues = null;
    }

    public Project(String projectName, float initialInvestment, ArrayList<Float> cashFlowValues) {
        this.projectName = projectName;
        this.initialInvestment = initialInvestment;
        this.cashFlowValues = cashFlowValues;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public float getInitialInvestment() {
        return initialInvestment;
    }

    public void setInitialInvestment(float initialInvestment) {
        this.initialInvestment = initialInvestment;
    }

    public ArrayList<Float> getCashFlowValues() {
        return cashFlowValues;
    }

    public void setCashFlowValues(ArrayList<Float> cashFlowValues) {
        this.cashFlowValues = cashFlowValues;
    }

    @Override
    public Boolean accept(FileVisitor visitor, String path) {
        return visitor.visitProject(this, path);
    }
}
