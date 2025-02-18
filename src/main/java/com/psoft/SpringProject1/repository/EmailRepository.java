package com.psoft.SpringProject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psoft.SpringProject1.entity.EmailStatus;

@Repository
public interface EmailRepository extends JpaRepository<EmailStatus, String> {}
