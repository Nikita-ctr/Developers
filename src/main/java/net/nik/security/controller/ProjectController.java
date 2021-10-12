package net.nik.security.controller;

import net.nik.security.domain.Project;
import net.nik.security.service.ProjectService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/allProd")
    public String allProjects(Model model) {
        List<Project> projectList = projectService.listAll();
        model.addAttribute("prodList", projectList);
        return "project";
    }

         @GetMapping("/prod-create")
                public String createProjectForm(Project project){
            return "project-create";
        }

        @PostMapping("/prod-create")
        public String createProject(Project project){
        projectService.save(project);
        return "redirect:/allProd";
        }

        @GetMapping("prod-delete/{id}")
        public String deleteProd(@PathVariable("id") Long id){
        projectService.delete(id);
        return "redirect:/allProd";
        }

        @GetMapping("/prod-update/{id}")
    public String updateProjectForm(@PathVariable ("id") Long id,Model model){
            Project project=projectService.get(id);
            model.addAttribute("project",project);
            return "/project-update";
        }

        @PostMapping("/prod-update")
    public String updateProject(Project project){
        projectService.save(project);
        return "redirect:/allProd";
        }

}
