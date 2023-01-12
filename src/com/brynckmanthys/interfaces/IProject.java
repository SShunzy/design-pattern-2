package com.brynckmanthys.interfaces;

import com.brynckmanthys.visitor.FileVisitor;

public interface IProject {
    Boolean accept(FileVisitor visitor, String path);
}
