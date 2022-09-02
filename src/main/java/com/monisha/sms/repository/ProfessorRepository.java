package com.monisha.sms.repository;

import com.monisha.sms.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {
    Professor findByEmail(String email);//JPA create the method based on the text
}
