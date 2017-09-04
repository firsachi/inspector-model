package ua.kiev.inspector.model.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.inspector.model.dao.InspectorStatusObjectDao;
import ua.kiev.inspector.model.entity.InspectorStatusObject;

class InspectorStatusObjectDaoImpl implements InspectorStatusObjectDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<InspectorStatusObject> allInspectorStatusObject() {
		Session session = sessionFactory.getCurrentSession();
		String query = "SELECT s FROM InspectorStatusObject s ORDER BY s.name";
		TypedQuery<InspectorStatusObject> typedQuery = session.createQuery(query, InspectorStatusObject.class);
		return typedQuery.getResultList();
	}

}
