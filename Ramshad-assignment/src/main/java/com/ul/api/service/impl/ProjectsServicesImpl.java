package com.ul.api.service.impl;

import com.ul.api.entity.Projects;
import com.ul.api.entity.StatusEnum;
import com.ul.api.repository.ProjectsRepository;
import com.ul.api.service.ProjectsServices;
import com.ul.api.service.error.ProjectNotFoundErrorHandler;
import com.ul.api.service.error.ProjectsNotFound;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ProjectsServicesImpl implements ProjectsServices {

    private final ProjectsRepository projectsRepository;

    public ProjectsServicesImpl(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    @Override
    public List<Projects> findAll() {
        List<Projects> projects = (List) projectsRepository.findAll();
        if (projects.size() == 0 || projects == null)
            throw new ProjectsNotFound();
        return projects;
    }

    @Override
    public Projects save(Projects projects) {
        projects.setDateCreated(LocalDateTime.now());
        projects.setArchived(false);
        return projectsRepository.save(projects);
    }

    @Override
    public Projects update(long id, Projects projects) {
        Projects projectUpdate = projectsRepository.findById(id).get();
        projectUpdate.setName(projects.getName());
        projectUpdate.setStatus(StatusEnum.UPDATED);
        projectUpdate.setDateCreated( LocalDateTime.now());
        projectUpdate.setArchived(false);
        projectsRepository.save(projectUpdate) ;
        return projectUpdate;
    }
}
