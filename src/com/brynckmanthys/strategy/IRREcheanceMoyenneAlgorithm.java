package com.brynckmanthys.strategy;

import com.brynckmanthys.bean.NPVBean;
import com.brynckmanthys.interfaces.IRRAlgorithm;

public class IRREcheanceMoyenneAlgorithm implements IRRAlgorithm {
    @Override
    public double calculateIRR(NPVBean npvBean) {
        double precision = 0.0001;
        double startValue = 0;
        double nextValue = 0.01;
        double nu = 0;
        double deliveryDate = 0;


        float investmentValue = Float.parseFloat(npvBean.getInitialInvestment());
        float totalCashFlowValues = 0;
        for(int i = 0; i < npvBean.getCashFlowValues().length; i++){
            totalCashFlowValues += npvBean.getCashFlowValues()[i];
        }
        System.out.println("invesmentValue = "+investmentValue);
        System.out.println("totalCashFlowValues = "+totalCashFlowValues);

        do{
            startValue = nextValue;
            System.out.println("startValue = "+startValue);
            double numerator = 0;
            nu = 1 / ( 1 + startValue);
            System.out.println("nu = "+nu);
            // U sera toujours égal à 0 car l'équation finira toujours par être multipliée par 0 vu que l'on a qu'un seul investissement
            for(int i = 0; i < npvBean.getCashFlowValues().length; i++){
                numerator += npvBean.getCashFlowValues()[i] * Math.pow(nu,i+1);
            }
            deliveryDate = (1/ Math.log(nu)) * Math.log(numerator / totalCashFlowValues);
            System.out.println("deliveryDate = "+deliveryDate);
            double base = totalCashFlowValues / investmentValue;
            System.out.println("base = "+base);
            double exponent = 1/deliveryDate;
            System.out.println("exponent = "+exponent);
            nextValue = Math.pow(base,exponent) - 1;
            System.out.println("nextValue = "+nextValue);
        }while((nextValue - startValue) > precision);

        return nextValue;
    }
}
