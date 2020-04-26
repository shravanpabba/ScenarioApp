package com.list.app.model;

public class ScenarioModel {

    private int scenarioId;
    private String scenarioName;

    public int getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(int scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public String getScenarioDesc() {
        return scenarioDesc;
    }

    public void setScenarioDesc(String scenarioDesc) {
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

    public String getScenarioParams() {
        return scenarioParams;
    }

    public void setScenarioParams(String scenarioParams) {
        this.scenarioParams = scenarioParams;
    }

    private String scenarioDesc;
    private String relPath;
    private String fileName;
    private String scenarioParams;

}
