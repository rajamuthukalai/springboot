package com.billtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.billtracker.model.Biller;

public interface BiilerRepository extends JpaRepository<Biller, Long> {

}