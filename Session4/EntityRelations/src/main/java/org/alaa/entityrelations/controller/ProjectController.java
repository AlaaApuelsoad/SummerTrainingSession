package org.alaa.entityrelations.controller;

import lombok.RequiredArgsConstructor;
import org.alaa.entityrelations.model.Project;
import org.alaa.entityrelations.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {


    private final ProjectService projectService;


    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return new ResponseEntity<>(projectService.crateProject(project), HttpStatus.CREATED);
    }
}
