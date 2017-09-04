package ua.kiev.inspector.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inspector_region database table.
 * 
 */
@Entity
@Table(name="inspector_region")
public class InspectorRegion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="region_id")
	private int regionId;

	@Column(name="name")
	private String name;

	public InspectorRegion() {
	}

	public int getRegionId() {
		return this.regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}