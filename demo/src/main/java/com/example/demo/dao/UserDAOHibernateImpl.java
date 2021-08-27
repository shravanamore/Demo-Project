package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;

@Repository
public class UserDAOHibernateImpl implements UserDAO {

	@Override
	@Transactional
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
