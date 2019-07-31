package com.tcs.infy.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.infy.entity.EANcode;

@Repository
public interface ItemEanCodeRepo extends JpaRepository<EANcode, Long>{
	
	Optional<EANcode> findByEanCode(String id);
	
	
	
	

}
