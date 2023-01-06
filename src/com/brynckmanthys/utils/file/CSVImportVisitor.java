package com.brynckmanthys.utils.file;

import com.brynckmanthys.classes.Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVImportVisitor implements FileVisitor {
    @Override
    public Boolean visitProject(Project project, String path) {
        try {
            Scanner scanner;
            File file = new File(path);
            project.setProjectName(file.getName());
            scanner = new Scanner(file);
            scanner.useDelimiter(",");

            if (scanner.hasNextFloat()) {
                project.setInitialInvestment(scanner.nextFloat());
            }

            ArrayList<Float> cashFlowValues = new ArrayList<>();
            while (scanner.hasNextFloat()) {
                cashFlowValues.add(scanner.nextFloat());
            }
            scanner.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
