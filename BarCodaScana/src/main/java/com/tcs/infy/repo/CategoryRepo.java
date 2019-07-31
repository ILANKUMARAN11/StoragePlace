package com.tcs.infy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.infy.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{

}
