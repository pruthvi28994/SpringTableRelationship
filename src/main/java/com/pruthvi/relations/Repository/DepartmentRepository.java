package com.pruthvi.relations.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruthvi.relations.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
