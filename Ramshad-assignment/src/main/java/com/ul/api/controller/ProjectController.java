package com.ul.api.controller;

import com.ul.api.entity.Projects;
import com.ul.api.service.ProjectsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectsServices projectsServices;

    public ProjectController(ProjectsServices projectsServices) {
        this.projectsServices = projectsServices;
    }

    @GetMapping
    public ResponseEntity<List<Projects>> findAll(){
        List<Projects> projectsList = projectsServices.findAll();
        return new ResponseEntity<>(projectsList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Projects> save(@RequestBody Projects projects){
        Projects projectsSaved = projectsServices.save(projects);
        return new ResponseEntity<>(projectsSaved, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Projects> update(@PathVariable long id,  @RequestBody Projects projects){
        Projects projectsUpdated= projectsServices.update(id,projects);
        return new ResponseEntity<>(projectsUpdated, HttpStatus.CREATED);
    }
}
