package com.psoft.SpringProject1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psoft.SpringProject1.entity.Student;



@Repository
public interface Repository1 extends JpaRepository<Student, Integer> {
}

