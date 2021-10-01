package net.nik.security.controller;


import net.nik.security.domain.Developer;
import net.nik.security.domain.Project;
import net.nik.security.service.DeveloperService;
import net.nik.security.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/auth/")
public class SuccessController {

  private final DeveloperService developerService;
  private final ProjectService projectService;

  @Autowired
    public SuccessController(DeveloperService developerService, ProjectService projectService) {
        this.developerService = developerService;
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public String allGenres(Model model){
        List<Project> projectList=projectService.listAll();
        model.addAttribute("prodList",projectList);
        return "project";
    }

    @GetMapping("/success")
    public String getSuccessPage(Model model) {
        List<Developer> developerList=developerService.listAll();
        model.addAttribute("devList",developerList);
        return "success";
    }
}
