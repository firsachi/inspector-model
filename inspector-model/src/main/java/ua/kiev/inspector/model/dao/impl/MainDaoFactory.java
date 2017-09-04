package ua.kiev.inspector.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.kiev.inspector.model.dao.DaoFactory;
import ua.kiev.inspector.model.dao.InspectorRegionDao;
import ua.kiev.inspector.model.dao.InspectorStatusObjectDao;
import ua.kiev.inspector.model.dao.InspectorStatusDao;
import ua.kiev.inspector.model.dao.InspectorTaskDao;
import ua.kiev.inspector.model.dao.InspectorTypeObjectDao;
import ua.kiev.inspector.model.dao.UserDao;

@Component
public class MainDaoFactory extends DaoFactory{
	
	@Autowired
	private InspectorRegionDao inspectorRegionDao;
	
	@Autowired
	private InspectorTypeObjectDao inspectorTypeObjectDao;
	
	@Autowired 
	private InspectorStatusObjectDao inspectorStatusObjectDao;
	
	@Autowired
	private InspectorTaskDao inspectorTaskDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private InspectorStatusDao inspectorStatusDao;

	@Override
	public InspectorRegionDao createInspectorRegionDao() {
		return inspectorRegionDao;
	}

	@Override
	public InspectorTypeObjectDao createInspectorTypeObjectDao() {
		return inspectorTypeObjectDao;
	}

	@Override
	public InspectorStatusObjectDao createInspectorStatusObjectDao() {
		return inspectorStatusObjectDao;
	}

	@Override
	public InspectorTaskDao createInspectorTaskDao() {
		return inspectorTaskDao;
	}

	@Override
	public UserDao createuUserDao() {
		return userDao;
	}

	@Override
	public InspectorStatusDao createInspectorStatusDao() {
		return inspectorStatusDao;
	}

}
