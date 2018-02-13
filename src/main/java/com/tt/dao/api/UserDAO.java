package com.tt.dao.api;


import com.tt.domain.User;


public interface UserDAO {
	
	public User getUser(String userId, String password);
		
	public User save(User usr);

}
