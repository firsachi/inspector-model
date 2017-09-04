package ua.kiev.inspector.model.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ua.kiev.inspector.model.dao.InspectorTypeObjectDao;
import ua.kiev.inspector.model.entity.InspectorTypeObject;

class InspectorTypeObjectDaoImpl implements InspectorTypeObjectDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<InspectorTypeObject> allTypeObject() {
		Session session = sessionFactory.getCurrentSession();
		String query = "SELECT t FROM InspectorTypeObject t order by t.name";
		TypedQuery<InspectorTypeObject> typedQuery = session.createQuery(query, InspectorTypeObject.class);
		return typedQuery.getResultList();
	}

}
