package ua.kiev.inspector.model.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.inspector.model.dao.InspectorStatusDao;
import ua.kiev.inspector.model.entity.InspectorStatus;

class InspectorStatusDaoImpl implements InspectorStatusDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<InspectorStatus> getListStatys() {
		Session session = sessionFactory.getCurrentSession();
		String query = "SELECT s FROM InspectorStatus s ORDER BY s.name";
		TypedQuery<InspectorStatus> typedQuery = session.createQuery(query, InspectorStatus.class);
		return typedQuery.getResultList();
	}

}
