package com.ul.api.service;

import com.ul.api.entity.Projects;

import java.util.List;

public interface ProjectsServices {
    List<Projects> findAll();
    Projects save(Projects projects);
    Projects update(long id, Projects projects);
}
