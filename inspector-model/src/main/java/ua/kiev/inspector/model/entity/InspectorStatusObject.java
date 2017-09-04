package ua.kiev.inspector.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inspector_stan database table.
 * 
 */
@Entity
@Table(name="inspector_stan")
public class InspectorStatusObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="stan_id")
	private int stanId;
	
	@Column(name="name")
	private String name;

	public InspectorStatusObject() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStanId() {
		return this.stanId;
	}

	public void setStanId(int stanId) {
		this.stanId = stanId;
	}

}