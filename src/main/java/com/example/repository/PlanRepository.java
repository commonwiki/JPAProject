package com.example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Serializable>{

}
