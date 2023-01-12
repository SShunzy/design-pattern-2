package com.brynckmanthys.visitor;

import com.brynckmanthys.bean.NPVBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CSVImportVisitor implements FileVisitor {
    @Override
    public Boolean visitNPVBean(NPVBean npvBean, String path) {
        try {
            Scanner scanner;
            File file = new File(path);
            npvBean.setProjectTitle(file.getName());
            scanner = new Scanner(file);
            scanner.useDelimiter(",");

            if (scanner.hasNext()) {
                npvBean.setInitialInvestment(scanner.next());
            }

            if (scanner.hasNext()) {
                npvBean.setDiscountRate(scanner.next());
            }

            ArrayList<Float> cashFlowValues = new ArrayList<>();
            while (scanner.hasNextFloat()) {
                cashFlowValues.add(scanner.nextFloat());
            }

            float[] cashFlowArray = new float[cashFlowValues.size()];
            for (int i = 0 ; i < cashFlowValues.size() ; i++) {
                cashFlowArray[i] = cashFlowValues.get(i);
            }

            npvBean.setCashFlowValues(cashFlowArray);
            npvBean.setNumberOfPeriod(cashFlowValues.size());

            scanner.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
