package com.monisha.sms.service;

import com.monisha.sms.controller.dto.ProfessorRegistrationDto;
import com.monisha.sms.entity.Professor;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ProfessorService extends UserDetailsService {
    Professor save(ProfessorRegistrationDto registrationDto);
}
