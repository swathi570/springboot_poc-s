package com.ojas.poc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.poc.model.Job;
import com.ojas.poc.repositories.JobRepository;
import com.ojas.poc.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepo;

	static Logger log = Logger.getLogger(JobServiceImpl.class.getName());

	@Override
	public ResponseEntity<Object> saveJob(Job job) {
		log.debug("Incoming request job service : " + job);

		try {
			if (job == null) {
				log.error("Invalid request");
				return new ResponseEntity<>("Invalid request data ", HttpStatus.UNPROCESSABLE_ENTITY);
			}

			if ((job.getJobType() == null || job.getJobType().isEmpty())
					|| (job.getJobTitle() == null || job.getJobTitle().isEmpty())
					|| (job.getExperience() == null || job.getExperience() == 0)
					|| (job.getAvailability() == null || job.getAvailability().isEmpty())
					|| (job.getJobDescription() == null || job.getJobDescription().isEmpty())
					|| (job.getCountry() == null || job.getCountry().isEmpty())
					|| (job.getLanguage() == null || job.getLanguage().isEmpty())
					|| (job.getState() == null || job.getState().isEmpty())
					|| (job.getReplyRate() == null || job.getReplyRate() == 0)
					|| (job.getSkills() == null || job.getSkills().isEmpty()) || (job.getUserInfo() == null)
					|| (job.getPayRate() == 0)) {
				log.error("Fields should not be null");
				return new ResponseEntity<>(" Fields should not be null ", HttpStatus.UNPROCESSABLE_ENTITY);
			}

			Job save = jobRepo.save(job);
			return new ResponseEntity<>(save, HttpStatus.OK);

		} catch (Exception e) {
			log.error("Exception caught : " + e.getMessage());
			String message = e.getMessage();
			return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

	@Override
	public ResponseEntity<Object> getByJobId(Integer id) {
		log.debug("Incoming request job service id method : " + id);
		try {
			if (id == null || id == 0) {
				log.error("Invalid request");
				return new ResponseEntity<>("Invalid request data ", HttpStatus.UNPROCESSABLE_ENTITY);
			}
			Optional<Job> findById = jobRepo.findById(id);
			return new ResponseEntity<>(findById, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception caught : " + e.getMessage());
			String message = e.getMessage();
			return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@Override
	public ResponseEntity<Object> getByJobType(String jobType) {
		log.debug("Incoming request job service type method : " + jobType);

		try {
			if (jobType == null || jobType.isEmpty()) {
				log.error("Invalid request");
				return new ResponseEntity<>("Invalid request data ", HttpStatus.UNPROCESSABLE_ENTITY);
			}

			List<Job> findByJobType = jobRepo.findByJobType(jobType);
			return new ResponseEntity<>(findByJobType, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception caught : " + e.getMessage());
			String message = e.getMessage();
			return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@Override
	public ResponseEntity<Object> getByExperience(Integer experience) {
		log.debug("Incoming request job service experience method : " + experience);

		try {
			if (experience == null || experience == 0) {
				log.error("Invalid request");
				return new ResponseEntity<>("Invalid request data ", HttpStatus.UNPROCESSABLE_ENTITY);
			}
			List<Job> findByExperience = jobRepo.findByExperience(experience);
			return new ResponseEntity<>(findByExperience, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception caught : " + e.getMessage());
			String message = e.getMessage();
			return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@Override
	public ResponseEntity<Object> getByCountry(String country) {
		log.debug("Incoming request job service country method : " + country);

		try {
			if (country == null || country.isEmpty()) {
				log.error("Invalid request");
				return new ResponseEntity<>("Invalid request data ", HttpStatus.UNPROCESSABLE_ENTITY);
			}
			List<Job> findByCountry = jobRepo.findByCountry(country);
			return new ResponseEntity<>(findByCountry, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception caught : " + e.getMessage());
			String message = e.getMessage();
			return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@Override
	public ResponseEntity<Object> getByAvailability(String availability) {
		log.debug("Incoming request job service availability method : " + availability);
		try {
			if (availability == null || availability.isEmpty()) {
				log.error("Invalid request");
				return new ResponseEntity<>("Invalid request data ", HttpStatus.UNPROCESSABLE_ENTITY);
			}
			List<Job> findByAvailability = jobRepo.findByAvailability(availability);
			return new ResponseEntity<>(findByAvailability, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception caught : " + e.getMessage());
			String message = e.getMessage();
			return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@Override
	public ResponseEntity<Object> getByLanguage(String language) {
		log.debug("Incoming request job service language method : " + language);

		try {
			if (language == null || language.isEmpty()) {
				log.error("Invalid request");
				return new ResponseEntity<>("Invalid request data ", HttpStatus.UNPROCESSABLE_ENTITY);
			}
			List<Job> findByLanguage = jobRepo.findByLanguage(language);
			return new ResponseEntity<>(findByLanguage, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception caught : " + e.getMessage());
			String message = e.getMessage();
			return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@Override
	public ResponseEntity<Object> getAllJobs() {
		log.debug("Incoming request job service getalljob method ");

		try {
			List<Job> findAllJobs = jobRepo.findAll();
			return new ResponseEntity<>(findAllJobs, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception caught : " + e.getMessage());
			String message = e.getMessage();
			return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@Override
	public ResponseEntity<Object> getBySkills(String skills) {
		log.debug("Incoming request job service skills method : " + skills);
		try {
			if (skills == null || skills.isEmpty()) {
				log.error("Invalid request");
				return new ResponseEntity<>("Invalid request data ", HttpStatus.UNPROCESSABLE_ENTITY);
			}
			List<Job> findBySkills = jobRepo.findBySkills(skills);
			return new ResponseEntity<>(findBySkills, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception caught : " + e.getMessage());
			String message = e.getMessage();
			return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

	@Override
	public ResponseEntity<Object> getByPayRate(int low, int high) {
		log.debug("Incoming request job service payrate method : " + low + high);
		try {
			if (low == 0 || high == 0) {
				log.error("Invalid request");
				return new ResponseEntity<>("Invalid request data ", HttpStatus.UNPROCESSABLE_ENTITY);
			}
			List<Job> findByPayRate = jobRepo.findByPayRateBetween(low, high);
			return new ResponseEntity<>(findByPayRate, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception caught : " + e.getMessage());
			String message = e.getMessage();
			return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

}
