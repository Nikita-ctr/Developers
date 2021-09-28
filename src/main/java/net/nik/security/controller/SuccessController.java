package net.nik.security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/")
public class SuccessController {

    @GetMapping("/success")
    public String getSuccessPage(Model model) {
        return "success";
    }
}
