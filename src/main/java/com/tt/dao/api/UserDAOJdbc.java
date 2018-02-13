package com.tt.dao.api;

import com.tt.domain.User;

public interface UserDAOJdbc {
	

	public User getUser(String userId, String password);

}
