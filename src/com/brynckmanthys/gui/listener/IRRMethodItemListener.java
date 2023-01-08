package com.brynckmanthys.gui.listener;

import com.brynckmanthys.bean.NPVBean;
import com.brynckmanthys.strategy.IRREcheanceMoyenneAlgorithm;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class IRRMethodItemListener implements ItemListener {

    private NPVBean npvBean;

    public IRRMethodItemListener(NPVBean npvBean){
        this.npvBean = npvBean;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getItem().equals("Echéance Moyenne")){
            System.out.println("Strategy set to Echéance Moyenne");
            npvBean.setIrrStrategy(new IRREcheanceMoyenneAlgorithm());
        }
        else{
            System.out.println("Méthode non implémentée");
        }
    }
}
