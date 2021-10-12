package net.nik.security.controller;

import net.nik.security.domain.Developer;
import net.nik.security.domain.Project;
import net.nik.security.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DeveloperController {

    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }


    @GetMapping("/allDev")
    public String allProjects(Model model) {
        List<Developer> developerList = developerService.listAll();
        model.addAttribute("devList", developerList);
        return "developer";
    }

        @GetMapping("/dev-create")
        public String createDeveloperForm(Developer developer){
            return "developer-create";
        }

        @PostMapping("/dev-create")
        public String createDeveloper (Developer developer){
            developerService.save(developer);
            return "redirect:/allDev";
        }

        @GetMapping("dev-delete/{id}")
        public String deleteDev(@PathVariable("id") Long id){
            developerService.delete(id);
            return "redirect:/allDev";
        }

        @GetMapping("/dev-update/{id}")
        public String updateDeveloperForm (@PathVariable("id") Long id, Model model){
            Developer developer = developerService.get(id);
            model.addAttribute("project", developer);
            return "/developer-update";
        }

        @PostMapping("/dev-update")
        public String updateDeveloper (Developer developer){
            developerService.save(developer);
            return "redirect:/allDev";
        }

    }
