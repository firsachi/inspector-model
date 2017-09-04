package ua.kiev.inspector.model.dao;

import org.springframework.stereotype.Component;

@Component
public abstract class DaoFactory {
	
	public abstract InspectorRegionDao createInspectorRegionDao();
	public abstract InspectorTypeObjectDao createInspectorTypeObjectDao();
	public abstract InspectorStatusObjectDao createInspectorStatusObjectDao();
	public abstract InspectorTaskDao createInspectorTaskDao();
	public abstract UserDao createuUserDao();
	public abstract InspectorStatusDao createInspectorStatusDao();

	public static DaoFactory getInstance(){
		try {
            Class<?> clazz = Class.forName("ua.kiev.inspector.model.dao.impl.MainDaoFactory");
            return (DaoFactory) clazz.newInstance();
        } catch (Exception ex){
            return null;
        }

	}
}
