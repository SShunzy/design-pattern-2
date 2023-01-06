package com.brynckmanthys.gui.listener;

import com.brynckmanthys.bean.NPVBean;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;

public class CashFlowComponentListener implements TableModelListener {

    private JTable parent;
    private NPVBean npvBean;

    public CashFlowComponentListener(NPVBean npvBean,JTable parent){
        this.npvBean = npvBean;
        this.parent = parent;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        if(parent.getRowCount() > 0){
            float cashFlowValues[] = new float[parent.getRowCount()];
            for(int i = 0; i < cashFlowValues.length; i++){
                String value = (String)parent.getValueAt(i,1);
                if(value == null || value.isEmpty())
                    cashFlowValues[i] = 0;
                else
                    cashFlowValues[i] = Float.parseFloat(value);
            }
            npvBean.setCashFlowValues(cashFlowValues);
        }
    }
}
