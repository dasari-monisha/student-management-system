package com.monisha.sms.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "professor", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;

//    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinTable(name = "professor_students",
//                joinColumns = @JoinColumn(name = "professor_id",referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id") )
//    private Collection<Student> students;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "professor_roles",
            joinColumns = @JoinColumn(name = "professor_id",referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id") )
    private Collection<Role> roles;

    public Professor() {
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

//    public Professor(Long id, String firstName, String lastName, String email, String password,Collection<Role> roles) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.roles = roles;
//    }

    public Professor(String firstName, String lastName, String email, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

//    public Professor(String firstName, String lastName, String email, String password, Collection<Student> students) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.students = students;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Collection<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(Collection<Student> students) {
//        this.students = students;
//    }
}
