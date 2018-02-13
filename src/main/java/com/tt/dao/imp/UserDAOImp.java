package com.tt.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tt.dao.api.UserDAO;
import com.tt.domain.User;

@Repository("UserDAO")
public class UserDAOImp implements UserDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	
	
	User usr;
	
/*	UserDAOImp(){
		usr=new User();
		usr.setUserId("Pankaj");
		usr.setPasssword("Pandey");
		usr.setRole("ADMIN");
	}*/
	
	
	
	public User getUser(String userId,String password)
	{
		
		TypedQuery<User> typedQuery=entityManager.createQuery("select u from User u where u.userId=:userId",User.class);
		typedQuery.setParameter("userId",userId);
		List<User> users = typedQuery.getResultList(); 
		if (!users.isEmpty() && users.get(0).getPassword().equals(password))
		{
			System.out.println("The data is" + users.get(0).getUserId());
			return users.get(0);
		}
		else return null;
		//if ((userId.equals(usr.getUserId()) && password.equals(usr.getPasssword())))
			//return usr;
		//else 
			//return null;
		
	}
	
	public User save(User usr){
		
		TypedQuery<User> typedQuery=entityManager.createQuery("select u from User u where u.userId=:userId",User.class);
		typedQuery.setParameter("userId",usr.getUserId());
		List<User> users = typedQuery.getResultList(); 
		if(!users.isEmpty())
		{
			return null;
		}		
		
		entityManager.persist(usr);	
		return usr;
		
	}

}
