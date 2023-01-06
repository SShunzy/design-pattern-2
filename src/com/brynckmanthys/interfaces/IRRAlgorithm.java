package com.brynckmanthys.interfaces;

import com.brynckmanthys.bean.NPVBean;

public interface IRRAlgorithm {
    public double calculateIRR(NPVBean npvBean);
}
