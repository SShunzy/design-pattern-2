package com.brynckmanthys.gui;

import com.brynckmanthys.bean.NPVBean;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NewTabPanel {
    private JPanel initialInvestmentPanel;
    private JLabel initialInvestmentLabel;
    private JTextField initialInvestmentTextField;
    private JTextField numberOfPeriodTextField;
    private JLabel numberOfPeriodLabel;
    private JPanel numberOfPeriodPanel;
    private JPanel cashFlowPanel;
    private JPanel npvPanel;
    private JLabel npvLabel;
    private JTextField npvTextField;
    private JPanel mainPanel;
    private JTable cashFlowTable;
    private JScrollPane cashFlowScrollPanel;
    private JPanel addPeriodsPanel;
    private JPanel headerPanel;
    private JButton addPeriodsButton;

    private int numberOfCashFlow;

    public NewTabPanel() {
        numberOfPeriodTextField.setText("0");
        setCashFlowTable();
        addPeriodsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCashFlowTable();
            }
        });
    }

    public JPanel getMainPanel(){ return mainPanel;}

    public NewTabPanel getNewTabPanel(){return this;}

    public void setNumberOfCashFlow(int number){
        this.numberOfCashFlow = number;
    }

    public int getNumberOfCashFlow(){return numberOfCashFlow;}

    public void setData(NPVBean data) {
        initialInvestmentTextField.setText(data.getInitialInvestment());
        numberOfPeriodTextField.setText(data.getNumberOfPeriod());
        npvTextField.setText(data.getNpvValue());
    }

    public void getData(NPVBean data) {
        data.setInitialInvestment(initialInvestmentTextField.getText());
        data.setNumberOfPeriod(numberOfPeriodTextField.getText());
        data.setNpvValue(npvTextField.getText());
    }

    public boolean isModified(NPVBean data) {
        if (initialInvestmentTextField.getText() != null ? !initialInvestmentTextField.getText().equals(data.getInitialInvestment()) : data.getInitialInvestment() != null)
            return true;
        if (numberOfPeriodTextField.getText() != null ? !numberOfPeriodTextField.getText().equals(data.getNumberOfPeriod()) : data.getNumberOfPeriod() != null)
            return true;
        if (npvTextField.getText() != null ? !npvTextField.getText().equals(data.getNpvValue()) : data.getNpvValue() != null)
            return true;
        return false;
    }

    public void removeCashFlow(int cashFlowIndex){
        System.out.println("Remove Cash Flow n°"+cashFlowIndex);
    }

    public void setCashFlowTable(){
        int numberOfPeriods = Integer.parseInt(numberOfPeriodTextField.getText());
        Object[][] data = new Object[numberOfPeriods][2];
        for(int i = 0; i < numberOfPeriods; i++)
            data[i][0] = i;
        cashFlowTable.setModel(new DefaultTableModel(
            data, new String[]{"Number","Cash Flow"}
        ));
    }
}
