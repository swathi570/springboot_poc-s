package com.ojas.poc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ojas.poc.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{
	
	public Optional<Job> findById(Integer id);
	
	public List<Job> findByJobType(String jobType);
	
	public List<Job> findByExperience(Integer experience);

	public List<Job> findByCountry(String country);
	
	public List<Job> findByAvailability(String availability);
	
	public List<Job> findByLanguage(String language);
	
	public List<Job> findBySkills(String skills);
	
//	@Query(value = "SELECT * from poc_4.job where pay_rate between 21 and 23;", nativeQuery = true)
//	@Query(value = "SELECT * from job j where j.pay_rate between low =?1 and high =?2", nativeQuery = true)
	public List<Job> findByPayRateBetween(int low, int high);
	
	public List<Job> findAll();
}
