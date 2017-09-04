package ua.kiev.inspector.model.dao.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.kiev.inspector.model.dao.InspectorRegionDao;
import ua.kiev.inspector.model.dao.InspectorStatusObjectDao;
import ua.kiev.inspector.model.dao.InspectorStatusDao;
import ua.kiev.inspector.model.dao.InspectorTaskDao;
import ua.kiev.inspector.model.dao.InspectorTypeObjectDao;
import ua.kiev.inspector.model.dao.UserDao;

@Configuration
public class ConfigurationDao {
	
	@Bean
	public InspectorRegionDao inspectorRegionDao() {
		return new InspectorRegionDaoImpl();
	}
	
	@Bean
	public InspectorTypeObjectDao inspectorTypeObjectDao() {
		return new InspectorTypeObjectDaoImpl();
	}
	
	@Bean
	public InspectorStatusObjectDao inspectorStatusObjectDao() {
		return new InspectorStatusObjectDaoImpl();
	}
	
	@Bean InspectorTaskDao inspectorTaskDao() {
		return new InspecptorTaskDaoImpl();
	}

	@Bean UserDao userDao() {
		return new UserDaoImpl();
	}
	
	@Bean InspectorStatusDao inspectorStatysDao() {
		return new InspectorStatusDaoImpl();
	}
}
