package com.ojas.module.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.module.model.Employee;
@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
