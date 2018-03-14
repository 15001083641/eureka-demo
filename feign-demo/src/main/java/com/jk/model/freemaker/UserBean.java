package com.jk.model.freemaker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserBean {

    private Integer id;
    private String userName;
    private Integer sex;
    private Date birthday;
    private String address;
    private Integer age;
    private String wordYear; //工作年限
    private String xueLi;
    private String professional;//专业
    private String phone;
    private String email;
    private String workXingZhi; //工作性质
    private String workPosition; //目标职位
    private String expectedSalary; // 期望薪资
    private String workAddress;  //工作地
    private String selfAssessment; //自我评价

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        if(birthday==null){
            return null;
        }
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        return sim.format(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWordYear() {
        return wordYear;
    }

    public void setWordYear(String wordYear) {
        this.wordYear = wordYear;
    }

    public String getXueLi() {
        return xueLi;
    }

    public void setXueLi(String xueLi) {
        this.xueLi = xueLi;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkXingZhi() {
        return workXingZhi;
    }

    public void setWorkXingZhi(String workXingZhi) {
        this.workXingZhi = workXingZhi;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    public String getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(String expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getSelfAssessment() {
        return selfAssessment;
    }

    public void setSelfAssessment(String selfAssessment) {
        this.selfAssessment = selfAssessment;
    }
}
