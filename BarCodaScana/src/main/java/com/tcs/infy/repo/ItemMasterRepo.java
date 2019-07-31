package com.tcs.infy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.infy.entity.ItemMaster;

@Repository
public interface ItemMasterRepo extends JpaRepository<ItemMaster, Long>{

}
