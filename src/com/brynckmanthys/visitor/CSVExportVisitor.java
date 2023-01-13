package com.brynckmanthys.visitor;

import com.brynckmanthys.bean.NPVBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSVExportVisitor implements FileVisitor {
    @Override
    public Boolean visitNPVBean(NPVBean npvBean, String path) {
        String[] allStrings = new String[2 + npvBean.getCashFlowValues().length];
        allStrings[0] = npvBean.getInitialInvestment();
        allStrings[1] = npvBean.getDiscountRate();

        for (int i = 0 ; i < npvBean.getCashFlowValues().length ; i++) {
            allStrings[2 + i] = Float.toString(npvBean.getCashFlowValues()[i]);
        }

        String finalString = String.join(",", allStrings);

        File csvOutputFile = new File(path);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.println(finalString);

            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
