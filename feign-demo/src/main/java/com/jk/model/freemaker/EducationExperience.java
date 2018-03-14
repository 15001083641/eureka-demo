package com.jk.model.freemaker;
//教育经历
public class EducationExperience {

    private Integer id;

    private String dataQuJian;

    private String schoolName;

    private String educationStage; //教育阶段

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataQuJian() {
        return dataQuJian;
    }

    public void setDataQuJian(String dataQuJian) {
        this.dataQuJian = dataQuJian;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getEducationStage() {
        return educationStage;
    }

    public void setEducationStage(String educationStage) {
        this.educationStage = educationStage;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "EducationExperience{" +
                "id=" + id +
                ", dataQuJian='" + dataQuJian + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", educationStage='" + educationStage + '\'' +
                ", userId=" + userId +
                '}';
    }
}
