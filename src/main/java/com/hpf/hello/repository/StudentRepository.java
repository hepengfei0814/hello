package com.hpf.hello.repository;

import com.hpf.hello.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Page<Student> findAll(Pageable pageable);
    Page<Student> findByAge(Integer age,Pageable pageable);

}
