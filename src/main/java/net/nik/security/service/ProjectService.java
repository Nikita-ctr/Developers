package net.nik.security.service;

import net.nik.security.domain.Project;
import net.nik.security.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void save(Project project){
        projectRepository.save(project);
    }

    public List<Project> listAll(){
       return projectRepository.findAll();
    }
    public Project get(Long id){
        return projectRepository.getById(id);
    }
    public void delete(Long id){
        projectRepository.deleteById(id);
    }

}
