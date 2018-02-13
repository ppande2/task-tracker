package com.tt.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tt.dao.api.UserDAO;
import com.tt.domain.User;
import com.tt.services.api.RegisterService;

@Service
@Transactional
public class RegisterServiceImp implements RegisterService {
	
	@Autowired
	UserDAO usrdao;
	
	//@Autowired
	//UserDAOJdbc usrdaojdbc;
	
	public User save(User usr){
		
		User user=usrdao.save(usr);
		return user;
	
		
	}
	

	
}
