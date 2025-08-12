package org.alaa.entityrelations.service;

import lombok.RequiredArgsConstructor;
import org.alaa.entityrelations.model.Project;
import org.alaa.entityrelations.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;


    public Project crateProject(Project project) {
        return projectRepository.save(project);
    }
}
