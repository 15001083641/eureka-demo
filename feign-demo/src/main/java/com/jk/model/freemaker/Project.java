package com.jk.model.freemaker;

public class Project {

    private Integer id;
    private String title;
    private String developmentEnvironment; //开发环境
    private String projectFramework; //项目框架
    private String projectDescription; //项目描述
    private String responsibilityDescription; //责任描述
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDevelopmentEnvironment() {
        return developmentEnvironment;
    }

    public void setDevelopmentEnvironment(String developmentEnvironment) {
        this.developmentEnvironment = developmentEnvironment;
    }

    public String getProjectFramework() {
        return projectFramework;
    }

    public void setProjectFramework(String projectFramework) {
        this.projectFramework = projectFramework;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getResponsibilityDescription() {
        return responsibilityDescription;
    }

    public void setResponsibilityDescription(String responsibilityDescription) {
        this.responsibilityDescription = responsibilityDescription;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
