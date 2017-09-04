package ua.kiev.inspector.model;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.kiev.inspector.model.configuration.AppConfigInspectorModel;
import ua.kiev.inspector.model.dao.DaoFactory;
import ua.kiev.inspector.model.dao.InspectorRegionDao;
import ua.kiev.inspector.model.dao.UserDao;
import ua.kiev.inspector.model.entity.User;

public class RunModel {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfigInspectorModel.class);
		applicationContext.refresh();
		applicationContext.start();
		DaoFactory daoFactory = (DaoFactory) applicationContext.getBean(DaoFactory.class);
		UserDao userDao = daoFactory.createuUserDao();
		User user = userDao.byId(544);
		System.out.println(user.getUserRoles().size());
	}

}
