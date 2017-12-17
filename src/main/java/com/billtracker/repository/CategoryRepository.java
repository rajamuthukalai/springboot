package com.billtracker.repository;

import com.billtracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kgtl075 on 17/12/17.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
