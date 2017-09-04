package ua.kiev.inspector.model.dao;

import java.util.List;

import ua.kiev.inspector.model.entity.InspectorTask;

public interface InspectorTaskDao {
	
	List<InspectorTask> getAllRisoDoc(int inspectorUserId);
	InspectorTask getByRispDoc(int id, int userId);

}
