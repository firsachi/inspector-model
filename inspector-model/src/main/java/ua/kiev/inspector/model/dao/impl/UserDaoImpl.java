package ua.kiev.inspector.model.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.inspector.model.dao.UserDao;
import ua.kiev.inspector.model.entity.User;

class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}

	@Override
	@Transactional
	public User byId(int id) {
		Session session = sessionFactory.getCurrentSession();
		String query = "SELECT u FROM User u WHERE u.usersId = :usersId";
		TypedQuery<User> typedQuery = session.createQuery(query, User.class);
		typedQuery.setParameter("usersId", id);
		return typedQuery.getSingleResult();
	}

	@Override
	@Transactional
	public User findByUserName(String username) {
		Session session = sessionFactory.getCurrentSession();
		String query = "SELECT u FROM User u WHERE u.mail = :username";
		TypedQuery<User> typedQuery = session.createQuery(query, User.class);
		typedQuery.setParameter("username", username);
		List<User> users = typedQuery.getResultList();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

}
