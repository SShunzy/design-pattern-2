package com.brynckmanthys.gui;

import com.brynckmanthys.bean.NPVBean;
import com.brynckmanthys.gui.listener.CashFlowComponentListener;
import com.brynckmanthys.gui.listener.IRRMethodItemListener;
import com.brynckmanthys.strategy.IRREcheanceMoyenneAlgorithm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NPVTabPanel {
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
    private JPanel irrPanel;
    private JLabel irrLabel;
    private JTextField irrTextField;
    private JButton IRRButton;
    private JPanel irrButtonPanel;
    private JComboBox irrMethodComboBox;
    private JLabel irrMethodLabel;

    private NPVBean npvBean;

    public NPVTabPanel() {
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
                npvBean.calculateNPV();
                setData(npvBean);
            }
        });
        IRRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getData(npvBean);
                irrTextField.setText(Double.toString(npvBean.calculateIRR()));
                setData(npvBean);
            }
        });
        irrMethodComboBox.addItem("Echéance Moyenne");
        irrMethodComboBox.addItem("...");
        irrMethodComboBox.addItemListener(new IRRMethodItemListener(npvBean));
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
        cashFlowTable.getModel().addTableModelListener(new CashFlowComponentListener(npvBean,cashFlowTable));
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
