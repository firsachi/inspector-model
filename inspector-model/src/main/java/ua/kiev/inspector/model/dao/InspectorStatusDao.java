package ua.kiev.inspector.model.dao;

import java.util.List;

import ua.kiev.inspector.model.entity.InspectorStatus;

public interface InspectorStatusDao {

	List<InspectorStatus> getListStatys();
}
