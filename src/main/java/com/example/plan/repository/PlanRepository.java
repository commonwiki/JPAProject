package com.example.plan.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.plan.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Serializable>{

}
