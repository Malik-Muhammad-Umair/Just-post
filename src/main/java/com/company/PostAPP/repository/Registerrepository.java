package com.company.PostAPP.repository;

import com.company.PostAPP.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Registerrepository extends JpaRepository<Register,Long> {
}
