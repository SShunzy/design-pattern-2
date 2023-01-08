package com.brynckmanthys.utils.file;

import com.brynckmanthys.classes.Project;

public interface FileVisitor {
    Boolean visitProject(Project project, String path);
}
