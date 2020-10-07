package com.ojas.poc.serviceimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.poc.exception.CustomException;
import com.ojas.poc.model.User;
import com.ojas.poc.repositories.UserRepository;
import com.ojas.poc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	static Logger log = Logger.getLogger(UserServiceImpl.class.getName());

	@Override
	public ResponseEntity<Object> saveUser(User user) throws CustomException {
		log.debug("Incoming request user service : " + user);

//		try {

		if (user == null) {
			log.error("Invalid request");
			throw new CustomException("invalid request " + user);
		}

		if (user.getUserName() == null || user.getUserName().isEmpty()) {
			log.error("Fields should not be null");
//				return new ResponseEntity<>(new CustomException(),HttpStatus.UNPROCESSABLE_ENTITY);
			throw new CustomException("Invalid fields & must not be null " + user.getUserName());
		}

		User save = userRepo.save(user);
		return new ResponseEntity<>(save, HttpStatus.OK);

////		} catch (Exception e) {
//			log.error("Exception caught : " + e.getMessage());
//			String message = e.getMessage();
//			return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
	}

}

//}
