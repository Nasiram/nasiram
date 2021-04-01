package com.ul.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ul.api.entity.Projects;
import com.ul.api.entity.StatusEnum;

@SpringBootTest
@AutoConfigureMockMvc
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void save() throws Exception {
        Projects projects = createProjects();
        mockMvc.perform(post("/projects").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(projects)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ram"));
    }

    @Test
    void update() throws Exception {
        Projects projects = createProjects();
        mockMvc.perform(post("/projects").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(projects)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ram"));
        projects.setId(1l);
        projects.setName("ram update");
        mockMvc.perform(put("/projects/{id}",1).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(projects)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ram update"));


    }

    @Test
    void findAll() throws Exception  {
        Projects projects = createProjects();
        List<Projects> projectsList = new ArrayList<>();
        projectsList.add(projects);
        mockMvc.perform(post("/projects").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(projects)))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/projects").contentType(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(projects)))
                .andExpect(status().isOk());


    }
    private Projects createProjects(){
        Projects projects = new Projects();
        projects.setName("ram");
        projects.setStatus(StatusEnum.IN_PROGRESS);
        projects.setDateCreated(LocalDateTime.now());
        projects.setArchived(false);
        return projects;
    }
}