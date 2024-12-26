package com.student.repository;

import com.student.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository <Home, Long> {
}
