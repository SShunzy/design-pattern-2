package com.brynckmanthys.visitor;

import com.brynckmanthys.bean.NPVBean;

public interface FileVisitor {
    Boolean visitNPVBean(NPVBean npvBean, String path);
}
