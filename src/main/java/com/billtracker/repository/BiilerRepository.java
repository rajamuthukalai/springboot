package com.billtracker.repository;

import com.billtracker.model.Biller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kgtl075 on 17/12/17.
 */

public interface BiilerRepository extends JpaRepository<Biller, Long> {
}
