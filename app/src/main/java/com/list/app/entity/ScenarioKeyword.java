package com.list.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCENARIO_KEYWORD")
public class ScenarioKeyword {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "SCENARIO_KEYWORD_ID")
	private int scenarioKeywordId;
	@Column(name = "SCENARIO_ID")
	private int scenarioId;
	@Column(name = "KEYWORD_ID")
	private int keyWordId;
	@Column(name = "ACTIVE_SW")
	private String activeSW;
	public int getScenarioKeywordId() {
		return scenarioKeywordId;
	}
	public void setScenarioKeywordId(int scenarioKeywordId) {
		this.scenarioKeywordId = scenarioKeywordId;
	}
	public int getScenarioId() {
		return scenarioId;
	}
	public void setScenarioId(int scenarioId) {
		this.scenarioId = scenarioId;
	}
	public int getKeyWordId() {
		return keyWordId;
	}
	public void setKeyWordId(int keyWordId) {
		this.keyWordId = keyWordId;
	}
	public String getActiveSW() {
		return activeSW;
	}
	public void setActiveSW(String activeSW) {
		this.activeSW = activeSW;
	}

}
