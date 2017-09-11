package ua.kiev.inspector.model.dao;

import java.util.List;

import ua.kiev.inspector.model.entity.InspectorTask;

public interface InspectorTaskDao {
	
	List<InspectorTask> getListTask(String email);
	InspectorTask byTask(int id, String email);

}
