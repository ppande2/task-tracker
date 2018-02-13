package com.tt.services.api;

import com.tt.domain.User;

public interface LoginService {
	
	public User validate(String userId, String password);


}
