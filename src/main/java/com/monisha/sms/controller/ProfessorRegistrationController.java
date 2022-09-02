package com.monisha.sms.controller;

import com.monisha.sms.controller.dto.ProfessorRegistrationDto;
import com.monisha.sms.service.ProfessorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class ProfessorRegistrationController {
    private ProfessorService professorService;

    public ProfessorRegistrationController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @ModelAttribute("professor")
    public ProfessorRegistrationDto professorRegistrationDto(){
        return new ProfessorRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping
    public String registerProfessorAccount(@ModelAttribute("professor")ProfessorRegistrationDto professorRegistrationDto){
        professorService.save(professorRegistrationDto);
        return "redirect:/registration?success";
    }
}
