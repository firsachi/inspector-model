package ua.kiev.inspector.model.dao;

import ua.kiev.inspector.model.entity.User;

public interface UserDao {
	
	void add(User user);
	void update(User user);
	User byId(int id);
	User findByUserName(String username);
}
