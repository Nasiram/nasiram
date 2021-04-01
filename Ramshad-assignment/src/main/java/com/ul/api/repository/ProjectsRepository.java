package com.ul.api.repository;

import com.ul.api.entity.Projects;
import org.springframework.data.repository.CrudRepository;

public interface ProjectsRepository extends CrudRepository<Projects, Long> {
}
