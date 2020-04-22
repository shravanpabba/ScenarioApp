package com.list.app.entity;

import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCENARIOS")
public class Scenarios {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "SCENARIO_NAME")
	private String name;
	@Column(name = "SCENARIO_DESC")
	private Clob scenarioDesc;
	@Column(name = "REL_PATH")
	private String relPath;
	@Column(name = "FILE_NAME")
	private String fileName;
	@Column(name = "ACTIVE_SW")
	private String activeSW;

	
	
	public String getActiveSW() {
		return activeSW;
	}

	public void setActiveSW(String activeSW) {
		this.activeSW = activeSW;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Clob getScenarioDesc() {
		return scenarioDesc;
	}

	public void setScenarioDesc(Clob scenarioDesc) {
		this.scenarioDesc = scenarioDesc;
	}

	public String getRelPath() {
		return relPath;
	}

	public void setRelPath(String relPath) {
		this.relPath = relPath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
