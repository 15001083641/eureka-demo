package com.jk.model.freemaker;

//工作经历
public class WorkExperience {

    private Integer id;
    private String dataQuJian;
    private String company; //公司
    private String position; //担任职位
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "id=" + id +
                ", dataQuJian='" + dataQuJian + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", userId=" + userId +
                '}';
    }
}
