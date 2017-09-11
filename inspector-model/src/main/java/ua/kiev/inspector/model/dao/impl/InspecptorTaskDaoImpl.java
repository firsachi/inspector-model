package ua.kiev.inspector.model.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.inspector.model.dao.InspectorTaskDao;
import ua.kiev.inspector.model.entity.InspectorTask;


public class InspecptorTaskDaoImpl implements InspectorTaskDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<InspectorTask> getListTask(String email) {
		Session session = sessionFactory.getCurrentSession();
		String query = "SELECT r FROM InspectorTask r WHERE r.inspector.email = :email";
		TypedQuery<InspectorTask> typedQuery = session.createQuery(query, InspectorTask.class);
		typedQuery.setParameter("email", email);
		return typedQuery.getResultList();
	}

	@Transactional
	@Override
	public InspectorTask byTask(int id, String email) {
		Session session = sessionFactory.getCurrentSession();
		String query = "SELECT r FROM InspectorTask r WHERE r.inspector.email = :email AND r.id = :id";
		TypedQuery<InspectorTask> typedQuery = session.createQuery(query, InspectorTask.class);
		typedQuery.setParameter("email", email);
		typedQuery.setParameter("id", id);
		return typedQuery.getSingleResult();
	}

}
