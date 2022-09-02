package com.monisha.sms.service.impl;

import com.monisha.sms.controller.dto.ProfessorRegistrationDto;
import com.monisha.sms.entity.Professor;
import com.monisha.sms.entity.Role;
import com.monisha.sms.entity.Student;
import com.monisha.sms.repository.ProfessorRepository;
import com.monisha.sms.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private ProfessorRepository professorRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public Professor save(ProfessorRegistrationDto registrationDto) {
        Professor professor = new Professor(registrationDto.getFirstName(),registrationDto.getLastName(), registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
        return professorRepository.save(professor);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Professor professor = professorRepository.findByEmail(username);
        if(professor == null){
            throw new UsernameNotFoundException("Invalid email or password ");
        }
        return new User(professor.getEmail(),professor.getPassword(),mapRolesToAuthorities(professor.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
