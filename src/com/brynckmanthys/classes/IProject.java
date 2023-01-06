package com.brynckmanthys.classes;

import com.brynckmanthys.utils.file.FileVisitor;

public interface IProject {
    Boolean accept(FileVisitor visitor, String path);
}
