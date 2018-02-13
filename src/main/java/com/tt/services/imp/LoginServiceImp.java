package com.tt.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tt.dao.api.UserDAO;
import com.tt.dao.api.UserDAOJdbc;
import com.tt.domain.User;
import com.tt.services.api.LoginService;

@Service
public class LoginServiceImp implements LoginService {
	
	@Autowired
	UserDAO usrdao;
	
	//@Autowired
	//UserDAOJdbc usrdaojdbc;
	
	public User validate(String userId,String password){
		
		User usr=usrdao.getUser(userId, password);
		return usr;
	
		
	}
	

}
