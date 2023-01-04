package com.brynckmanthys.gui;

import com.brynckmanthys.bean.NPVBean;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton npvButton;
    private JPanel discountRatePanel;
    private JLabel discountRateLabel;
    private JTextField discountRateTextField;

    private NPVBean npvBean;

    public NewTabPanel() {
        npvBean = new NPVBean();
        setData(npvBean);
        setCashFlowTable(null);
        addPeriodsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCashFlowTable(null);
            }
        });
        npvButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getData(npvBean);
                float[] cashFlowValues = new float[Integer.parseInt(numberOfPeriodTextField.getText())];
                for(int i = 0; i < cashFlowValues.length; i++){
                    cashFlowValues[i] = Float.parseFloat((String) cashFlowTable.getValueAt(i,1));
                }
                npvBean.setCashFlowValues(cashFlowValues);
                npvBean.calculateNPV();
                setData(npvBean);
            }
        });
    }

    public JPanel getMainPanel(){ return mainPanel;}

    public void setCashFlowTable(float[] cashFlowValues){
        int numberOfPeriods = Integer.parseInt(numberOfPeriodTextField.getText());
        Object[][] data = new Object[numberOfPeriods][2];
        for(int i = 0; i < numberOfPeriods; i++){
            data[i][0] = i+1;
            if(cashFlowValues != null && i < cashFlowValues.length)
                data[i][1] = cashFlowValues[i];
        }
        cashFlowTable.setModel(new DefaultTableModel(
            data, new String[]{"Number","Cash Flow"}
        ));
    }

    public void setData(NPVBean data) {
        npvTextField.setText(data.getNpvValue());
        initialInvestmentTextField.setText(data.getInitialInvestment());
        numberOfPeriodTextField.setText(data.getNumberOfPeriod());
        discountRateTextField.setText(data.getDiscountRate());
    }

    public void getData(NPVBean data) {
        data.setNpvValue(npvTextField.getText());
        data.setInitialInvestment(initialInvestmentTextField.getText());
        data.setNumberOfPeriod(numberOfPeriodTextField.getText());
        data.setDiscountRate(discountRateTextField.getText());
    }

    public boolean isModified(NPVBean data) {
        if (npvTextField.getText() != null ? !npvTextField.getText().equals(data.getNpvValue()) : data.getNpvValue() != null)
            return true;
        if (initialInvestmentTextField.getText() != null ? !initialInvestmentTextField.getText().equals(data.getInitialInvestment()) : data.getInitialInvestment() != null)
            return true;
        if (numberOfPeriodTextField.getText() != null ? !numberOfPeriodTextField.getText().equals(data.getNumberOfPeriod()) : data.getNumberOfPeriod() != null)
            return true;
        if (discountRateTextField.getText() != null ? !discountRateTextField.getText().equals(data.getDiscountRate()) : data.getDiscountRate() != null)
            return true;
        return false;
    }
}
