package ua.kiev.inspector.model.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ua.kiev.inspector.model.dao.InspectorRegionDao;
import ua.kiev.inspector.model.entity.InspectorRegion;

class InspectorRegionDaoImpl implements InspectorRegionDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<InspectorRegion> allInspectorRegion() {
		Session session = sessionFactory.getCurrentSession();
		String query = "SELECT i FROM InspectorRegion i";
		TypedQuery<InspectorRegion> typedQuery = session.createQuery(query, InspectorRegion.class);
		return typedQuery.getResultList();
	}

}
