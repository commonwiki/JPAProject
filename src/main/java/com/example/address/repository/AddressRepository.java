package com.example.address.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Serializable>{
	
	public List<Address> findByPid (int pid);
	
	
}
